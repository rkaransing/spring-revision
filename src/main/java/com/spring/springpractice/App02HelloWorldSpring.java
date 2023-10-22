package com.spring.springpractice;

import com.spring.springpractice.configs.HelloWorldConfigurations;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // 1. Launch spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfigurations.class);


        // 2. Configure the that we want to manage with help of @Configuration
        //    => Created HelloWorldConfiguration and bound it with context above.

        // Retrieving the beans managed by Spring.
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("personTwoMethodCalls"));
        System.out.println(context.getBean("personWithParameterAsBean"));

    }
}
