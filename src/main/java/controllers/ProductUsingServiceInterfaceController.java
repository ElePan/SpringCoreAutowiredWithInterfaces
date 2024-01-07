package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import services.ProductServiceInterface;

@Component
public class ProductUsingServiceInterfaceController {

    @Autowired
    @Qualifier("first")
    //if you want to use an interface instance, you need to use method name to define what instance to use
    private ProductServiceInterface productService;

}
