package net.tayebi.webspringmvcproductsapplication;

import net.tayebi.webspringmvcproductsapplication.entities.Product;
import net.tayebi.webspringmvcproductsapplication.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebSpringMvcProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSpringMvcProductsApplication.class, args);
    }
@Bean
    CommandLineRunner init(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("PC")
                    .price(12000)
                    .quantity(12)
                    .build()
            );
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(50000)
                    .quantity(22)
                    .build()
            );
            productRepository.save(Product.builder()
                    .name("Mouse")
                    .price(40)
                    .quantity(30)
                    .build()
            );
            productRepository.save(Product.builder()
                    .name("Keyboard")
                    .price(100)
                    .quantity(10)
                    .build()
            );
        };
}
}
