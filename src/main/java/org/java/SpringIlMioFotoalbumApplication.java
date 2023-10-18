package org.java;

import org.java.db.pojo.Photo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Photo ph1 = new Photo("Il mare", "Foto del mare", "#", false);
		Photo ph2 = new Photo("La Montagna", "Foto della montagna", "#");
		
		System.out.println(ph1);
		System.out.println("\n---------------------\n");
		System.out.println(ph2);
		
	}

}
