package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.Product;
import enhanced_inventory.server.service.WMS.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  public List<Product> findAllProducts() {
    return productService.findAllProducts();
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable Long id) {
    Product product = productService.findProductById(id)
        .orElseThrow(() -> new RuntimeException("Product not Found"));
    return product;
  }

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    Product saveProduct = productService.createProduct(product);
    return saveProduct;
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    Product updatedProduct = productService.updateProduct(id, productDetails);
    return ResponseEntity.ok(updatedProduct);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok().build(); //build
  }

  @GetMapping("/{categoryId}")
  public List<Product> getProductsByCategory(@PathVariable String categoryId) {
    return productService.getProductsByCategory(categoryId);
  }
}
