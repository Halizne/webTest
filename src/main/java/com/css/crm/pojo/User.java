package com.css.crm.pojo;

import com.css.crm.controller.annotation.Tel;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by 46597 on 2018/10/28.
 */
public class User {

    private long id;

    @NotBlank(message="姓名不能为空")
    private String name;
    @Length(min=4, max=20, message="{valid.password}")
    private String password;

    @NotBlank(message="{valid.required}")
    @Email(message="{valid.email}")
    private String email;

    @NotNull(message="{valid.required}")
    private boolean married;

    @Min(value = 18, message = "{valid.ageMin}")
    @Max(value = 100, message = "{valid.ageMax}")
    protected int age;

    @NotNull(message="{valid.required}")
    @Past(message="{valid.birthday}")
    private Date birthday;

    @Pattern(regexp="^[a-zA-Z]{2,}$", message="{valid.address}")
    private String address;

    @Size(min=1, message="{valid.likesMin}")
    private String[] likes;

    @Tel(message="{valid.tel}", min=3)
    private String tel;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", likes=" + Arrays.toString(likes) +
                ", tel='" + tel + '\'' +
                '}';
    }
}
