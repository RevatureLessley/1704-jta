package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.entity.Address;
import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.entity.Trainer;

public interface TrainerDao {

	List<Trainer> getAllTrainers();
	Trainer getTrainer(String name);
	
	boolean insertTrainer(Trainer trainer);
	boolean insertTrainer(Trainer trainer, Address address);
	boolean updateTrainer(Trainer trainer);
	boolean deleteTrainer(Trainer trainer);
	
	boolean addPokemon(String trainerName, Pokemon pokemon);
	
}
