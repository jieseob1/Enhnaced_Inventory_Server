package enhanced_inventory.server.service;

import enhanced_inventory.server.domain.Product;
import enhanced_inventory.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //findAll & saveProduct
    public List<Product> findAllProducts() {
        return productRepository.findAll(); // jpaRepo
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

}
