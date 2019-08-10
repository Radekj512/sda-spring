package pl.sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sda.spring.bean.SomeBean;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Object someBean = context.getBean("someBean");
        SomeBean someBean2 = context.getBean("someBean2", SomeBean.class);
        System.out.println(someBean);
        System.out.println(someBean2);
    }
}
