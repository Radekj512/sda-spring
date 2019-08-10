package pl.sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sda.spring.bean.BeanWithList;
import pl.sda.spring.bean.SomeBean;
import pl.sda.spring.bean.SomeBean2;
import pl.sda.spring.bean.SomeBean3;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

//        Object someBean = context.getBean("someBean");
//        SomeBean someBean2 = context.getBean("someBean2", SomeBean.class);
//        SomeBean someBean3 = context.getBean("someBean3", SomeBean.class);
//        System.out.println(someBean);
//        System.out.println(someBean2);
//        System.out.println(someBean3);
//
//        System.out.println();
//        SomeBean2 newBean1 = context.getBean("newBean1", SomeBean2.class);
//        SomeBean2 newBean2 = context.getBean("newBean2", SomeBean2.class);
//        SomeBean2 newBean3 = context.getBean("newBean3", SomeBean2.class);
//        System.out.println(newBean1);
//        System.out.println(newBean2);
//        System.out.println(newBean3);

        //bean domyslnie (scope) jest singletonem
//        SomeBean someBean1 = context.getBean("someBean", SomeBean.class);
//        SomeBean someBean2 = context.getBean("someBean", SomeBean.class);
//        SomeBean someBean3 = context.getBean("someBean", SomeBean.class);
//
//        System.out.println(someBean1);
//        System.out.println(someBean2);
//        System.out.println(someBean3);
//
//        someBean1.setName("zmieniony tekst");
//
//        System.out.println(someBean1);
//        System.out.println(someBean2);
//        System.out.println(someBean3);

        BeanWithList beanWithList = context.getBean("beanWithList", BeanWithList.class);
        System.out.println(beanWithList);

    }
}
