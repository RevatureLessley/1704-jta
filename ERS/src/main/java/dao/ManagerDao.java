package dao;

import model.Manager;

public interface ManagerDao {
	boolean createManager(String inUsername, String inPassword);
	Manager readManager(String inUsername);
	boolean deleteManager(String inUsername);
	String hash(String inUsername, String inPassword);
}
