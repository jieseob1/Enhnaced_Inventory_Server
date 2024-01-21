package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.entity.WMS.Product;
import enhanced_inventory.server.repository.WMS.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> findProductById(Long id) {
    return productRepository.findById(id);
  }
  @Transactional
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Transactional
  public Product updateProduct(Long id, Product newProductData) {
    //Todo. 해당 부분 가능한지 확인
    return productRepository.findById(id) // nullable체크
        .map(product -> {
          product.setName(newProductData.getName());
          product.setDescription(newProductData.getDescription());
          product.setPrice(newProductData.getPrice());
          // 추가적인 필드 업데이트
          return productRepository.save(product);
        })
        .orElseThrow(() -> new RuntimeException("Product not found"));
  }
  @Transactional
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  public List<Product> getProductsByCategory(String categoryId) {
    return productRepository.findByCategories_Id(categoryId);
  }


}
