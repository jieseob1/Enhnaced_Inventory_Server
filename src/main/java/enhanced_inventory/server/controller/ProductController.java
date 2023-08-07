package enhanced_inventory.server.controller;

import enhanced_inventory.server.domain.Product;
import enhanced_inventory.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product); //service에 존재했던 save기능 가지고 옴
    }
}
