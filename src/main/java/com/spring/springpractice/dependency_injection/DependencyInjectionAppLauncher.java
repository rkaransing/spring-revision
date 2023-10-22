package com.spring.springpractice.dependency_injection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class FirstDependency{

}

@Component
class SecondDependency{

}

@Component
class MyOwnClass {



    /**
     * Field injection.
     * */
    /*
    @Autowired
    private FirstDependency firstDependency;

    @Autowired
    private SecondDependency secondDependency;
    */

    /**
     * Setter Injection
     * */
    /*

    private FirstDependency firstDependency;
    private SecondDependency secondDependency;

    @Autowired
    public void setFirstDependency(FirstDependency firstDependency) {
        this.firstDependency = firstDependency;
    }

    @Autowired
    public void setSecondDependency(SecondDependency secondDependency) {
        this.secondDependency = secondDependency;
    }
    */

    /**
     * Constructor Injection
     * */
    private FirstDependency firstDependency;
    private SecondDependency secondDependency;

    public MyOwnClass(FirstDependency firstDependency, SecondDependency secondDependency) {
        System.out.println("Constructor Injection.");
        this.firstDependency = firstDependency;
        this.secondDependency = secondDependency;
    }

    @Override
    public String toString(){
        return "MyOwnClass: " + firstDependency + ", " + secondDependency;
    }
}

@Configuration
@ComponentScan
public class DependencyInjectionAppLauncher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjectionAppLauncher.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(MyOwnClass.class));
    }
}
