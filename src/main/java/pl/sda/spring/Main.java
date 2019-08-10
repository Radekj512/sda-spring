package pl.sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.spring.bean.knight.Knight;
import pl.sda.spring.bean.knight.KnightOne;
import pl.sda.spring.bean.quest.Quest;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//
//        Knight knightOne = context.getBean("knightOne", Knight.class);
//        Knight knightTwo = context.getBean("knightTwo", Knight.class);
//        Knight knightThree = context.getBean("knightThree", Knight.class);
//        List<Knight> knights = Arrays.asList(knightOne, knightTwo, knightThree);
//
//        for (Knight knight : knights) {
//            knight.embarkQuest();
//            System.out.println();
//        }

        Knight knightOne = context.getBean("knightOne", Knight.class);
        knightOne.embarkQuest();
    }
}
