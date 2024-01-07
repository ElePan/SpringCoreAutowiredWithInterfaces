package config;


import controllers.ProductUsingServiceInterfaceController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.ProductServiceImpl;
import services.ProductServiceInterface;
import services.SecondProductServiceImpl;

@Configuration
//Annotation to tell spring that class is a config one
@ComponentScan(basePackages = {"controllers", "services"})
//Annotations to tell spring we have components that he needs to add to the config
public class AppConfig {
    @Bean
    ProductUsingServiceInterfaceController productUsingServiceInterfaceController() {
        return new ProductUsingServiceInterfaceController();
    }

    @Bean
    @Qualifier("first")
    ProductServiceInterface productService() {
        return new ProductServiceImpl();
    }
    //if you want to create an interface instance, you need to use method name to define what instance to use

    @Bean
    @Qualifier("second")
    ProductServiceInterface secondProductService() {
        return new SecondProductServiceImpl();
    }
}
//You are declaring a config class in this file
