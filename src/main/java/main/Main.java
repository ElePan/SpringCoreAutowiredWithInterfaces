package main;

import config.AppConfig;
import controllers.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductUsingServiceInterfaceController firstImpl = context.getBean(ProductUsingServiceInterfaceController.class);
        //if you want to create an interface instance, you need to use method name to define what instance to use
    }
}