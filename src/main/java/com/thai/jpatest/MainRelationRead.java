package com.thai.jpatest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.Musician;

public class MainRelationRead {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Musician musician = em.find(Musician.class, 1L);

        em.getTransaction().commit();

        System.out.println(musician);
        System.out.println(musician.getInstrument());
        System.out.println(musician.getInstrument().getMusician());
    }

}
