package controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CusAccount;
import com.example.demo.CusAccountServices;
import com.example.demo.Purchase;


@RestController
@CrossOrigin("http://localhost:3000/")
public class CusAccountController {
	
	@Autowired
	private CusAccountServices cusAccountservices;
	
	@ExceptionHandler
	@GetMapping("/cus_account")
	public List<CusAccount> list() {
		return cusAccountservices.listAll();
	}
	
	@GetMapping("/cus_account/{cus_id}")
	public ResponseEntity<CusAccount> get(@PathVariable Integer cus_id) {
		try {
			CusAccount cusaccount = cusAccountservices.get(cus_id);
		return new ResponseEntity<CusAccount>(cusaccount, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<CusAccount>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/cus_account")
	public void add(@RequestBody CusAccount cusaccount) {
		cusAccountservices.save(cusaccount);
	}
	
	@PutMapping("/cus_account/{cus_id}")
	public ResponseEntity<?> update(@RequestBody CusAccount cusaccount,
			@PathVariable Integer cus_id) {
		try {
			CusAccount exsistCusAccount = cusAccountservices.get(cus_id);
			cusAccountservices.save(cusaccount);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/cus_account/{cus_id}")
	public void delete(@PathVariable Integer cus_id) {
		cusAccountservices.delete(cus_id);
	}
	

}
