package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.Product;
import enhanced_inventory.server.repository.WMS.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  @Transactional
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Transactional
  public Product updateProduct(String id, Product newProductData) {
    //Todo. 해당 부분 가능한지 확인
    return productRepository.findById(id)
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
  public void deleteProduct(String id) {
    productRepository.deleteById(id);
  }

}
