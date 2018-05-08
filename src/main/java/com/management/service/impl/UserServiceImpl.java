package com.management.service.impl;

import com.management.dao.UserDao;
import com.management.entity.User;
import com.management.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.management.entity.Role;
import com.management.entity.User;
import com.management.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 谢开欣 on 2018/5/7.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
    @Resource
    private UserDao dao;

    public User userLogin(User user) {
        return dao.userLogin(user);
    }
    @Transactional
    public boolean addUser(User user) {
        return dao.addUser(user);
    }
    @Transactional
    public boolean userUpdate(User user) {
        return dao.userUpdate(user);
    }
    @Transactional
    public boolean roleAdd(Role role) {
        return dao.roleAdd(role);
    }
    @Transactional
    public boolean userDelete(String uid) {
        return dao.userDelete(uid);
    }
    @Transactional
    public boolean reolDelete(String rid) {
        return dao.reolDelete(rid);
    }
    @Transactional
    public List<User> userSelect(String uid) {
        return dao.userSelect(uid);
    }
}
