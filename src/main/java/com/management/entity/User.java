package com.management.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by 谢开欣 on 2018/5/7.
 *
 * 用户类
 */
@Entity
@Table(name = "mm_user")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String uid; // 主键

    @Column(length = 20,nullable = false)
    private String name; // 姓名

    @Column(length = 2,nullable = false)
    private String sex; // 性别

    @Column(nullable = false)
    private Date birthday; // 出生年月日

    @Column(nullable = false,length = 20)
    private String educationBackground; // 学历

    @Column(length = 50)
    private String home; // 归属地

    @Column(length = 255)
    private String remark; // 备注

    @Column(length = 30,nullable = false)
    private String account; // 登录账号

    @Column(length = 30,nullable = false)
    private String password; // 登录密码

    @Column(length = 2,nullable = false)
    private Integer status = 0; // 0为可用

    @Column(nullable = false)
    private Date createTime; // 创建时间

    @Column(nullable = true)
    private Date updateTime; // 修改时间

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})       //指定多对多关系
    @JoinTable(name="USER_ROLE",                       //指定第三张表
    joinColumns={@JoinColumn(name="USER_ID")},             //本表与中间表的外键对应
    inverseJoinColumns={@JoinColumn(name="ROLE_ID")})  //另一张表与第三张表的外键的对应关系
    private Set<Role> roles;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", educationBackground='" + educationBackground + '\'' +
                ", home='" + home + '\'' +
                ", remark='" + remark + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", roles=" + roles +
                '}';
    }
}
