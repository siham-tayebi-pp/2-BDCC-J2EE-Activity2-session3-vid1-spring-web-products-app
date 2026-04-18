package net.tayebi.webspringmvcproductsapplication.web;

import net.tayebi.webspringmvcproductsapplication.entities.Product;
import net.tayebi.webspringmvcproductsapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200") // jautorise ce domaine a menvoyer des req
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

// pour cree une api rest pn ajoute documentation swagger via 
//       <dependency>
//      <groupId>org.springdoc</groupId>
//      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
//      <version>2.8.17</version>
//   </dependency>
//    http://localhost:8086/swagger-ui.html

    @GetMapping("/products")
//    @ResponseBody pas besoin car c restcontroller
    public List<Product> products() {
        return productRepository.findAll();

    }
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id) {
        return productRepository.findById(id).get();
    }
    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
         productRepository.deleteById(id);
    }
}
