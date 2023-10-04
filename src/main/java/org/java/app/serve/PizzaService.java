package org.java.app.serve;

import java.util.List;

import org.java.app.pojo.Pizza;
import org.java.app.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class PizzaService {
	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	public void save(Pizza pizza) {
		
		pizzaRepo.save(pizza);
	}
	public List<Pizza> findAll() {
		
		return pizzaRepo.findAll();
	}
	public Pizza findById(int id) {
		
		return pizzaRepo.findById(id).get();
	}
}
