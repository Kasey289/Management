package com.management.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 谢开欣 on 2018/5/7.
 *
 * 角色类
 */
@Entity
@Table(name = "mm_role")
public class Role {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String rid;

    @Column(length = 30)
    private String rname;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})       //指定多对多关系
    @JoinTable(name="ROLE_AUTHORITY",                       //指定第三张表
    joinColumns={@JoinColumn(name="ROLE_ID")},             //本表与中间表的外键对应
    inverseJoinColumns={@JoinColumn(name="AUTHORITY_ID")})  //另一张表与第三张表的外键的对应关系
    private Set<Authority> Authoritys;

    public Set<Authority> getAuthoritys() {
        return Authoritys;
    }

    public void setAuthoritys(Set<Authority> authoritys) {
        Authoritys = authoritys;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid='" + rid + '\'' +
                ", rname='" + rname + '\'' +
                ", Authoritys=" + Authoritys +
                '}';
    }
}
