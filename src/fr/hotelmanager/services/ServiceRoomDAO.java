package fr.hotelmanager.services;

import java.util.List;

public interface ServiceRoomDAO<T> {
	
	public T save(T t);
	public int find(int id);
	public List<T> findAll();
	public boolean update(int id);
	public T delete(int id);
    List<T> findAllByState(boolean b);
}
