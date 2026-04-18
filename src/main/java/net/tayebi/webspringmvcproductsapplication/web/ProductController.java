package net.tayebi.webspringmvcproductsapplication.web;

import net.tayebi.webspringmvcproductsapplication.entities.Product;
import net.tayebi.webspringmvcproductsapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
       return "index";
    }
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/index";
    }
//    @GetMapping("products")
//    @ResponseBody
//    public List<Product> products() {
//        return productRepository.findAll();
//
//    } ca c rest car retrn json pas vue
}
