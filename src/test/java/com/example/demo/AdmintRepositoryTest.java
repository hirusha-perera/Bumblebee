package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class AdmintRepositoryTest {
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateAdmin() {
		Admin admin = new Admin();
		admin.setAdmin_name("Hirusha");
		admin.setAdmin_email("hirushaperera@live.com");
		admin.setAdmin_telephone("0776199350");
		admin.setAdmin_password("Hirusha");
		
		
		
		Admin savedAdmin = repo.save(admin);
		
		Admin existAdmin = entityManager.find(Admin.class, savedAdmin.getAdmin_id());
		
		assertThat(existAdmin.getAdmin_email()).isEqualTo(admin.getAdmin_email());
		
		
		
	}
	

}
