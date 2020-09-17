package com.uttara.services;

import java.util.List;

import com.uttara.test.Actor;

public interface ActorService {

	
	public String createActor(Actor actor);
	public String deleteActor(Long sl);
	public String updateActor(Actor actor);
	public Actor openUpdateactor(Long sl);

	public Actor getActor(Long sl);
	public List<Actor> listActors();
	public List<Actor> ListActorsByCharname(String fname);
}
