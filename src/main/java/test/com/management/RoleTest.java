package test.com.management;

import com.management.entity.Authority;
import com.management.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 谢开欣 on 2018/5/7.
 */
public class RoleTest {

    private ApplicationContext context;

    private SessionFactory sessionFactory;

    @Before
    public void before() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-hibernate.xml","spring.xml");
    }

    @Test
    public void addRole(){
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Authority authority = new Authority();
        authority.setAname("用户查询");

        session.save(authority);

        Authority authority1 = new Authority();
        authority1.setAname("用户权限管理");

        session.save(authority1);

        Role role = new Role();
        role.setRname("超级管理员");

        Set<Authority> su1 = new HashSet();

        su1.add(authority);
        su1.add(authority1);

        role.setAuthoritys(su1);

        session.save(role);

        session.getTransaction().commit();
    }
}
