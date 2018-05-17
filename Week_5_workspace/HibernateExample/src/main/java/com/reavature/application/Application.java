package com.reavature.application;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.hibernate.entity.Address;
import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.entity.Trainer;
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
		
//		TrainerService.insertTrainer(new Trainer("Brock"), new Address("1234 Rocky Road", "Pewter City"));
		
//		Trainer brock = TrainerService.getTrainer("Brock");
//		
//		TrainerService.addPokemon("Brock", new Pokemon("Onix"));
		
//		TrainerService.insertTrainer(new Trainer("Lance"), new Address("5678 Dragon Court", "Elite Four"));
//		TrainerService.addPokemon("Lance", new Pokemon("Kingdra"));
//		TrainerService.addPokemon("Brock", new Pokemon("Rhydon"));
//		TrainerService.addPokemon("Brock", new Pokemon("Golem"));
//		TrainerService.addPokemon("Lance", new Pokemon("Onix"));

		Trainer trainer = TrainerService.getTrainer("Lance");
		TrainerService.deleteTrainer(trainer);


//		Session session = null;
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			List<Pokemon> pokemon = session.createQuery("from Pokemon", Pokemon.class).getResultList();
//			for (Pokemon p : pokemon) {
//				System.out.println(p);
//				for (Trainer t : p.getTrainers()) {
//					System.out.println(t);
//				}
//			}
//		} catch (HibernateException he) {
//			he.printStackTrace();
//		} finally {
//			HibernateUtil.shutdownSession(session);
//		}
		
		
		
		HibernateUtil.shutdown();
	}
}













