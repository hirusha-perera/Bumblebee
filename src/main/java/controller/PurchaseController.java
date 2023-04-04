package controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Purchase;
import com.example.demo.PurchaseServices;

@RestController
public class PurchaseController {
	
	@Autowired
	 private PurchaseServices purchaseService;

		@ExceptionHandler
		@GetMapping("/purchases")
		public List<Purchase> list() {
			return purchaseService.listAll();
		}
		
		@GetMapping("/purchases/{purchase_id}")
		public ResponseEntity<Purchase> get(@PathVariable Integer purchase_id) {
			try {
			Purchase purchase = purchaseService.get(purchase_id);
			return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
			}
		}
		
		@GetMapping("/purchases/{purchased_customer}")
		public ResponseEntity<Purchase> getbycus(@PathVariable Integer purchased_customer) {
			try {
			Purchase purchase = purchaseService.get(purchased_customer);
			return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
			}
		}
		
		@PostMapping("/purchases")
		public void add(@RequestBody Purchase purchase) {
			purchaseService.save(purchase);
		}
		
		@PutMapping("/purchases/{purchase_id}")
		public ResponseEntity<?> update(@RequestBody Purchase purchase,
				@PathVariable Integer purchase_id) {
			try {
				Purchase exsistPurchase = purchaseService.get(purchase_id);
				purchaseService.save(purchase);
				
				return new ResponseEntity<>(HttpStatus.OK);
			}catch (NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		@DeleteMapping("/purchase/{purchase_id}")
		public void delete(@PathVariable Integer purchase_id) {
			purchaseService.delete(purchase_id);
		}
		
		

}
