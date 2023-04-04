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


import com.example.demo.Payments;
import com.example.demo.PaymentsServices;




@RestController
public class PaymentsController {
	
	
	
	@Autowired
	 private PaymentsServices paymentsService;

		@ExceptionHandler
		@GetMapping("/payments")
		public List<Payments> list() {
			return paymentsService.listAll();
		}
		
		@GetMapping("/payments/{payment_id}")
		public ResponseEntity<Payments> get(@PathVariable Integer payment_id) {
			try {
			Payments payments = paymentsService.get(payment_id);
			return new ResponseEntity<Payments>(payments, HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
			}
		}
		
		@GetMapping("/payments/{customerpay_id}")
		public ResponseEntity<Payments> getbycus(@PathVariable Integer customerpay_id) {
			try {
			Payments payments = paymentsService.get(customerpay_id);
			return new ResponseEntity<Payments>(payments, HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
			}
		}
		
		@GetMapping("/payments/{purchased_id}")
		public ResponseEntity<Payments> getbypurchase(@PathVariable Integer purchased_id) {
			try {
			Payments payments = paymentsService.get(purchased_id);
			return new ResponseEntity<Payments>(payments, HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
			}
		}
		
		
		@PostMapping("/payments")
		public void add(@RequestBody Payments payments) {
			paymentsService.save(payments);
		}
		
		@PutMapping("/payments/{payment_id}")
		public ResponseEntity<?> update(@RequestBody Payments payments,
				@PathVariable Integer payment_id) {
			try {
				Payments exsistPurchase = paymentsService.get(payment_id);
				paymentsService.save(payments);
				
				return new ResponseEntity<>(HttpStatus.OK);
			}catch (NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		@DeleteMapping("/payments/{payment_id}")
		public void delete(@PathVariable Integer payment_id) {
			paymentsService.delete(payment_id);
		}

//		@GetMapping("/data")
//		public List<Payments> getDataByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date first_installmentDate) {
//		  return paymentsRepository.findByDate(first_installmentDate);
//		}
}
