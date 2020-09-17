package com.uttara.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.uttara.test.Actor;

@Repository
public class ActorMssqlDao implements ActorDao {

	@Autowired
	SessionFactory factory;
	
	public String saveActor(Actor actor) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(actor);
		
		tx.commit();
		session.close();
		return "actorsave.success";
	}

	public String deleteActor(Long id) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println(id);
	    Actor a=session.get(Actor.class,id);
	    System.out.println(a);
	    session.delete(a);
		
		tx.commit();
		session.close();
		return "actordelete.success";
	}

	public String updateActor(Long sl) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Actor a=session.get(Actor.class, sl);
		
		session.update(a);
		
		tx.commit();
		session.close();
		return "actorupdate.success";
		
	}

	
	public Actor openUpdateActor(Long sl) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Actor a=session.get(Actor.class, sl);
		tx.commit();
		session.close();
		return a;
	}

	public Actor getActor(Long sl) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Actor a=session.get(Actor.class, sl);
		
		
		tx.commit();
		session.close();
		return a;
	}

	public List<Actor> getActors() {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		List<Actor> actors= session.createQuery("from Actor order by uname").getResultList();
		
		tx.commit();
		session.close();
		return actors;
	}

	public List<Actor> getActor(String fname) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Actor where fname= :fn");
		q.setParameter("fn", fname);
		List<Actor> actors=q.getResultList();
		
		tx.commit();
		session.close();
		return actors;
	}

	public String updateActor(Actor actor) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.update(actor);
		
		tx.commit();
		session.close();
		return "actorupdate.success";
	}

	


}
