package com.revature.hibernate.services;

import java.util.List;

import com.revature.hibernate.dao.TrainerDao;
import com.revature.hibernate.dao.TrainerDaoImpl;
import com.revature.hibernate.entity.Address;
import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.entity.Trainer;

public class TrainerService {

	private static TrainerDao dao = TrainerDaoImpl.getInstance();
	private TrainerService() {}
	
	public static List<Trainer> getAllTrainers() {
		return dao.getAllTrainers();
	}
	
	public static Trainer getTrainer(String name) {
		return dao.getTrainer(name);
	}
	
	public static boolean insertTrainer(Trainer trainer, Address address) {
		return dao.insertTrainer(trainer, address);
	}
	
	public static boolean deleteTrainer(Trainer trainer) {
		return dao.deleteTrainer(trainer);
	}
	
	public static boolean addPokemon(String trainerName, String pokemonName) {
		return dao.addPokemon(trainerName, pokemonName);
	}
}
