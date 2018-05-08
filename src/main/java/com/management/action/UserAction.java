package com.management.action;

import com.management.entity.User;
import com.management.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Created by 谢开欣 on 2018/5/7.
 */
@Controller
public class UserAction extends ActionSupport{
    private static final Logger LOG = LogManager.getLogger(UserAction.class);


    @Resource
    private UserService userService;

    private String account;
    private String password;

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

    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        if (account == null && password == null) {
            return ERROR;
        } else {
            if(session.get("user") == null){
                try {
                    LOG.info("account的值为:"+account);
                    LOG.info("password的值为:"+password);
                    User user = new User();
                    user.setAccount(account);
                    user.setPassword(password);
                    User user2 = userService.login(user);
                    if(user2 != null){
                        session.put("user",user2);
                        request.setAttribute("message","success");
                        return SUCCESS;
                    }else {
                        request.setAttribute("message","用户名或密码有误，登录失败！");
                        return ERROR;
                    }
                }catch (Exception e){
                    LOG.error("失败:" + e.getMessage());
                    request.setAttribute("message","系统发生未知错误，请求失败！");
                    return ERROR;
                }
            }else{
                return SUCCESS;
            }
        }
    }



}
