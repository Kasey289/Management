package com.management.service;

import com.management.dao.UserDao;
import com.management.entity.Role;
import com.management.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 谢开欣 on 2018/5/7.
 */

public interface UserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
    User userLogin(User user);

    /**
     * 添加用户
     * @param user
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean userUpdate(User user);

    /**
     * 添加角色
     * @param role
     * @return
     */
    boolean roleAdd(Role role);

    /**
     * 删除用户
     * @param uid
     * @return
     */
    boolean userDelete(String uid);

    /**
     * 删除角色
     * @param rid
     * @return
     */
    boolean reolDelete(String rid);

    /**
     * 查询用户信息
     * @param uid
     * @return
     */
    List<User> userSelect(String uid);
}
