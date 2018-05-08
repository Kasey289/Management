package test.com.management;

import com.management.entity.Authority;
import com.management.entity.Role;
import com.management.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 谢开欣 on 2018/5/7.
 */
public class UserTest {
    private ApplicationContext context;

    private SessionFactory sessionFactory;

    @Before
    public void before() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-hibernate.xml","spring.xml");
    }

    @Test
    public void addUser(){
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.openSession();


        session.beginTransaction();
        Query query = session.createQuery("FROM Role where rname = '超级管理员'");
        Role role = (Role) query.uniqueResult();

        System.out.println(role);

        User user = new User();
        user.setName("wuming");
        user.setAccount("5201314");
        user.setPassword("123456");
        Date date = new Date();
        user.setBirthday(date);
        user.setEducationBackground("大专");
        user.setHome("重庆");
        user.setSex("男");
        user.setRemark("很努力");
        Date date2 = new Date();
        user.setCreateTime(date2);
        user.setStatus(0);



        Set<Role> su1 = new HashSet();
//
        su1.add(role);

        user.setRoles(su1);

        session.save(user);

        session.getTransaction().commit();
    }
}
