package com.management.dao.impl;

import com.management.dao.UserDao;
import com.management.entity.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import com.management.entity.Role;
import com.management.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 谢开欣 on 2018/5/7.
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Resource
    private SessionFactory sessionFactory;

    private static final Logger LOG = LogManager.getLogger(UserDaoImpl.class);


    @Transactional
    @Override
    public User login(User user) {
        LOG.info("开始执行登录操作~~~~~");

        User userobj = null;

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User where account ='" + user.getAccount() + "'" +
                " and password = '" + user.getPassword() + "'");

        userobj = (User) query.uniqueResult();

        LOG.info("查询返回值为:" + userobj);

        return userobj;
    }
    /**
     * 用户登录
     * @param user
     * @return
     */
    public User userLogin(User user) {
        return null;
    }

    /**
     * 添加用户
     * @param user
     */
    public boolean addUser(User user) {
        return false;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public boolean userUpdate(User user) {
        return false;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    public boolean roleAdd(Role role) {
        return false;
    }

    /**
     * 删除用户
     * @param uid
     * @return
     */
    public boolean userDelete(String uid) {
        return false;
    }

    /**
     * 删除角色
     * @param rid
     * @return
     */
    public boolean reolDelete(String rid) {
        return false;
    }

    /**
     * 查询用户信息
     * @param uid
     * @return
     */
    public List<User> userSelect(String uid) {
        return null;
    }
}
