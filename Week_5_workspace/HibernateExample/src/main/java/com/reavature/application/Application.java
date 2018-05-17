package com.reavature.application;

import java.util.List;

import com.revature.hibernate.entity.Address;
import com.revature.hibernate.entity.Trainer;
import com.revature.hibernate.services.AddressService;
import com.revature.hibernate.services.TrainerService;
import com.revature.hibernate.util.HibernateUtil;

public class Application {

	// public static void main(String[] args) {
	// Session session = null;
	// Transaction transaction = null;
	// try {
	// session = HibernateUtil.getSessionFactory().openSession();
	// transaction = session.beginTransaction();
	//
	// Employee employee = new Employee("Max", "email@email.com");
	// session.save(employee);
	//
	//// Pokemon pokemon = new Pokemon("Pidgey");
	//// session.save(pokemon);
	//
	// transaction.commit();
	//
	// } catch (HibernateException he) {
	// if (transaction != null) {
	// transaction.rollback();
	// System.out.println("Transaction successfully rolledback");
	// }
	// he.printStackTrace();
	// } finally {
	// if (session != null) {
	// session.close();
	// System.out.println("Session successfully closed " + !session.isOpen());
	// }
	// }
	// }

//	public static void main(String[] args) {
//		System.out.println("Current number of Pokemon: " + PokemonService.getAllPokemon().size());
//		
//		PokemonService.insertPokemon(new Pokemon("kabutops"));
//		System.out.println("Current number of Pokemon: " + PokemonService.getAllPokemon().size());
//		PokemonService.insertPokemon(new Pokemon("Alakazam"));
//		
//		Pokemon p1 = PokemonService.getPokemon("Alakazam");
////		System.out.println(p1.getName());
//		Pokemon p2 = PokemonService.getPokemon("kabutops");
//		System.out.println(p2);
//		p2.setName("Kabutops");
//		PokemonService.updatePokemon(p2);
//		Pokemon p3 = PokemonService.getPokemon("Kabutops");
//		System.out.println(p3);
//	
//		PokemonService.deletePokemon(p3);
//		System.out.println("Current number of Pokemon: " + PokemonService.getAllPokemon().size());
//		
////		PokemonService.deletePokemon(p1);
//		
//		for (Pokemon p : PokemonService.getAllPokemon()) {
//			System.out.println(p);
//		}
//	}
	
	public static void main(String[] args) {
		
		Trainer t = TrainerService.getTrainer("Brock");
		TrainerService.deleteTrainer(t);
		
		for (Address a : AddressService.getAllAddresses()) {
			System.out.println(a);
			System.out.println(a.getTrainer());
		}
		
		HibernateUtil.shutdown();
		
	}
}













