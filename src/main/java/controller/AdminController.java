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

import com.example.demo.Admin;

import com.example.demo.AdminServices;



@RestController
public class AdminController {
	
	@Autowired
    private AdminServices services;

	@ExceptionHandler
	@GetMapping("/admin")
	public List<Admin> list() {
		return services.listAll();
	}
	
	@GetMapping("/admin/{admin_id}")
	public ResponseEntity<Admin> get(@PathVariable Integer admin_id) {
		try {
		Admin admin = services.get(admin_id);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/admin")
	public void add(@RequestBody Admin admin) {
		services.save(admin);
	}
	
	@PutMapping("/admin/{admin_id}")
	public ResponseEntity<?> update(@RequestBody Admin admin,
			@PathVariable Integer admin_id) {
		try {
			Admin exsistAdmin = services.get(admin_id);
			services.save(admin);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/admin/{admin_id}")
	public void delete(@PathVariable Integer admin_id) {
		services.delete(admin_id);
	}
	
	
	
	

}
