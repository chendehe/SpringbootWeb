package com.chendehe.mybatis.mybatis.mapper;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

// 指定 Bean 别名，可以在 resultType 直接使用别名
// 1. 配置文件指定全类名
// 2. 配置文件指定包
// 3. @Alias 注解
@Alias("User")
public class User implements Serializable {

    private static final long serialVersionUID = -2535178899662614143L;
    private String id;
    private String name;
    private int gender;
    private LocalDate birthday;
    private String address;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", gender=" + gender + ", birthday=" + birthday
            + ", address='" + address + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}