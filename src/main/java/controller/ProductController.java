package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Product;
import com.example.demo.ProductServices;

@RestController
public class ProductController {
	
	 @Autowired
	    private ProductServices productServices;
	 
	 @GetMapping("/product")
	  public List<Product> getAllProducts() {
	        return productServices.getAllProducts();
	    }
	 
	    @GetMapping("/product/{product_id}")
	    public Product getProductById(@PathVariable int product_id) {
	        return productServices.getProductById(product_id);
	    }
	    
	    @PostMapping("/product")
	    public Product createProduct(@RequestBody Product product) {
	        return productServices.createProduct(product);
	    }
	    
	    @DeleteMapping("/product/{product_id}")
	    public void deleteProduct(@PathVariable int product_id) {
	        productServices.deleteProduct(product_id);
	    }

}
