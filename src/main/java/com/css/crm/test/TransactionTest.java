package com.css.crm.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 学习编程式事务管理！
 * <p>
 * 定义sql语句
 * <p>
 * Created by 46597 on 2018/2/16.
 */
public class TransactionTest {


    private static final String CREATE_TABLE_SQL = "CREATE TABLE test  (id INT  PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(100))";
    private static final String DROP_TABLE_SQL = "drop table test";
    private static final String INSERT_SQL = "insert into test(name) values(?)";
    private static final String COUNT_SQL = "select count(*) from test";


    private static ApplicationContext ctx;
    private static PlatformTransactionManager txManager;
    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;

    //必须为静态方法  相当于junit 4 beforeClass
    @BeforeClass
    public static void setUpClass() {
        String[] configLocations = new String[]{
                //奇了怪了 为什么这边貌似不支持spring/applicationContext-*.xml 写法；
                "classpath:spring/applicationContext-dao.xml",
                "classpath:spring/applicationContext-trans.xml"};
        ctx = new ClassPathXmlApplicationContext(configLocations);
        txManager = ctx.getBean(PlatformTransactionManager.class);
        dataSource = ctx.getBean(DataSource.class);
        jdbcTemplate = new JdbcTemplate(dataSource);


    }

    /**
     * 这tm的idea的 try...catch... 的快捷键是啥；
     * <p>
     * TODO No qualifying bean of type [org.springframework.transaction.PlatformTransactionManager] is defined;
     */
    @Test
    public void testPlatformTransactionManager() {

        //事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        //隔离级别 ：
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        //传播行为
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //事务状态类
        TransactionStatus status = txManager.getTransaction(def);
        //通过jdbcTemplate对象执行相应的sql操作，且自动享受到事务支持，注意事务是线程绑定的
        //因此事务管理器可以运行在多线程中；
        jdbcTemplate.execute(CREATE_TABLE_SQL);
        try {
            jdbcTemplate.update(INSERT_SQL, "test");
            int x = 1 / 0;
            txManager.commit(status);
        } catch (RuntimeException e) {
            txManager.rollback(status);
        }
        // jdbcTemplate.execute(DROP_TABLE_SQL);
    }

    /**
     * 低级别解决方案来进行事务管理器测试  -- 不使用这种方式
     */
    @Test
    public void testPlatformTransactionManagerForLowLevel1() {


        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(def);
        Connection conn = DataSourceUtils.getConnection(dataSource);

        try {
            conn.prepareStatement(CREATE_TABLE_SQL).execute();
            PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
            pstmt.setString(1, "test");
            pstmt.execute();
            conn.prepareStatement(DROP_TABLE_SQL).execute();
            txManager.commit(status);
        } catch (SQLException e) {
            status.setRollbackOnly();
            txManager.rollback(status);
        } finally {
            DataSourceUtils.releaseConnection(conn, dataSource);
        }


    }

    /**
     * alipay 就是使用的这种方式  重点！！！
     */
    @Test
    public void testTransactionTemplate() {

        jdbcTemplate.execute(CREATE_TABLE_SQL);

        TransactionTemplate transactionTemplate = new TransactionTemplate(txManager);

        // PlatformTransactionManager实现，并通过其相应方法设置事务定义，如事务隔离级别、传播行为等，此处未指定传播行为，其默认为PROPAGATION_REQUIRED
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);

        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    jdbcTemplate.update(INSERT_SQL, "test");
                    int x = 1 / 0;
                }
            });
        } catch(Exception e){
            //throw new RuntimeException("算数异常");
            System.out.println("算数异常");
        }
        // jdbcTemplate.execute(DROP_TABLE_SQL);


    }


}
