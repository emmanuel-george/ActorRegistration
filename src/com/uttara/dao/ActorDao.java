package com.uttara.dao;

import java.util.List;

import com.uttara.test.Actor;

public interface ActorDao {
	
	public String saveActor(Actor actor);
	public String deleteActor(Long sl);
	public String updateActor(Long sl);
	public String updateActor(Actor actor);
	public Actor getActor(Long sl);
	public List<Actor> getActors();
	public List<Actor> getActor(String fname);
	public Actor openUpdateActor(Long sl);
}
