package com.example.demo;

import java.util.List;
//import com.example.demo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
	
	@Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int product_id) {
        return productRepository.findById(product_id).orElse(null);
    }
    

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer product_id, Product product) {
       Product existingProduct = productRepository.findById(product_id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProduct_name(product.getProduct_name());
            existingProduct.setProduct_description(product.getProduct_description());
            existingProduct.setProduct_quantity(product.getProduct_quantity());
            existingProduct.setProduct_price(product.getProduct_price());
            existingProduct.setProduct_image(product.getProduct_image());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(int product_id) {
        productRepository.deleteById(product_id);
    }
}


