package org.java.app;

import org.java.app.pojo.Pizza;
import org.java.app.serve.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Pizza p1 = new Pizza("p1", "overview1", "https://images.pexels.com/photos/1566837/pexels-photo-1566837.jpeg?auto=compress&cs=tinysrgb&w=400", 10.10f);
		Pizza p2 = new Pizza("p2", "overview1", "https://images.pexels.com/photos/7947152/pexels-photo-7947152.jpeg?auto=compress&cs=tinysrgb&w=400", 12.10f);
		Pizza p3 = new Pizza("p3", "overview1", "https://images.pexels.com/photos/5903262/pexels-photo-5903262.jpeg?auto=compress&cs=tinysrgb&w=400", 13.10f);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
	}

}
