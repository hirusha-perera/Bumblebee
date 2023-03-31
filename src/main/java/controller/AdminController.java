package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Admin;
import com.example.demo.AdminServices;



@Controller
@RestController
public class AdminController {
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@Autowired
	private AdminServices services;
	@ExceptionHandler
	@GetMapping("/admin")
	public List<Admin> list() {
		return services.listAll();
	}
	
	
	
	

}
