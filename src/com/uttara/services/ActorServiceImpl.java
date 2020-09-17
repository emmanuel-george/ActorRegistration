package com.uttara.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttara.dao.ActorDao;
import com.uttara.dao.ActorMssqlDao;
import com.uttara.test.Actor;
@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorDao dao;

	public String createActor(Actor actor) {
		return dao.saveActor(actor);
	}

	public String deleteActor(Long id) {
		
		return dao.deleteActor(id);
	}

	public String updateActor(Long sl) {
		
		return dao.updateActor(sl);
	}
	public Actor openUpdateactor(Long sl)
	{
		return dao.openUpdateActor(sl);
	}

	public Actor getActor(Long sl) {
		return dao.getActor(sl);
	}

	public List<Actor> listActors() {
		return dao.getActors();
	}

	public List<Actor> ListActorsByCharname(String fname) {
		return dao.getActor(fname);
	}

	public String updateActor(Actor actor) {
		return dao.updateActor(actor);
		
	}

	

}
