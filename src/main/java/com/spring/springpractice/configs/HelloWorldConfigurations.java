package com.spring.springpractice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * In this class we will define all our beans which will be managed by Spring
 */

record Person(String name, int age, Address address) { }

record Address(String firstLine, String city) { }

@Configuration
public class HelloWorldConfigurations {

    /**
     * @Bean -> Indicates that a method produces a bean to be managed by the Spring container.
     */
    @Bean
    public String name() {
        return "Karansing";
    }

    @Bean
    public int age() {
        return 27;
    }

    @Bean
    public Person person() {
        return new Person("Karansing", 27, new Address("First Address", "Sangli"));
    }

    // Beans related to some other beans (relationship)
    @Bean
    public Person personTwoMethodCalls() {
        return new Person(name(), age(), address());
    }

    // Another way in which you can use parameters getting passed as bean
    @Bean
    public Person personWithParameterAsBean(String name, int age, Address address) {
        return new Person(name, age, address);
    }


    @Bean
    public Address address() {
        return new Address("Plot no. 72", "Jaysingpur");
    }
}


