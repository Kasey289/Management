package com.management.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 谢开欣 on 2018/5/7.
 *
 * 权限类
 */
@Entity
@Table(name = "mm_authority")
public class Authority {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String aid;

    @Column(length = 30)
    private String aname;

    @Column(length = 100)
    private String url;


    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
