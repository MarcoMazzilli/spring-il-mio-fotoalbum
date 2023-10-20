package org.java;

import org.java.db.pojo.Category;
import org.java.db.pojo.Photo;
import org.java.db.repository.CategoryRepository;
import org.java.db.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Photo ph1 = new Photo("Il mare", "Foto del mare", "##", false);
		Photo ph2 = new Photo("La Montagna", "Foto della montagna", "##");
		
		System.out.println(ph1);
		System.out.println("\n---------------------\n");
		System.out.println(ph2);
		
		photoRepository.save(ph1);
		photoRepository.save(ph2);
		
		Category c1 = new Category("Paesaggi");
		Category c2 = new Category("Tramonti");
		
		System.out.println(c1);
		System.out.println("\n---------------------\n");
		System.out.println(c2);
		
		categoryRepository.save(c1);
		categoryRepository.save(c2);
		
		Photo ph3 = new Photo("Tramonto", "Descrizione del tramonto", "url Foto", c1,c2);
		photoRepository.save(ph3);
		
		System.err.println(ph3);
	}

}
