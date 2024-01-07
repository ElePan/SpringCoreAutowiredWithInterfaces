# Spring Dependency Injection With Interfaces

## Prerequisites
- Java 17
- enable -ea in your IDE (or use it when launching java) to use assertion.
- Steps in intellij: open "run/build configuration", go to "modify options" -> "add VM options", set "-ea" in this space.
- (To be sure it is working fine just modify an assertion in main() and check it throw an Exception).


## Qualifier
If you have more than one implementation of an interface, you need to say which one to use.
You can do that giving a name at each bean instance:
```
public class AppConfig {
    @Bean
    @Qualifier("first")
    ProductServiceInterface productController() {
        return new ProductServiceImpl();
    }

    @Bean
    @Qualifier("second")
    ProductServiceInterface secondProductController() {
        return new SecondProductServiceImpl();
    }
}
```
Que @Qualifier allow you to do that.
In this case for example the instance of ProductServiceInterface that use ProductServiceImpl is called "first".
In this case for example the instance of ProductServiceInterface that use SecondProductServiceImpl is called "second".

You can automatically inject the correct one using th @Qualifier and the @Autowired together, as here 
(where we are going to use first implementation):
```
@Component
public class ProductUsingServiceInterfaceController {
    @Autowired
    @Qualifier("first")
    private ProductServiceInterface productService;
}
```