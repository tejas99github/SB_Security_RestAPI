package com.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SbSecurityRestApiApplication {

//	@Autowired
//	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(SbSecurityRestApiApplication.class, args);

		BCryptPasswordEncoder b = new BCryptPasswordEncoder();

		String encode = b.encode("alex_jones");
		
		System.out.println(encode);
	}

}
