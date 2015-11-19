package com.thai.jpatest;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.MusicType;
import com.thai.model.Musican;

public class Main {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        Musican singer = new Musican();
        singer.setId(1);
        singer.setName("Adele");
        calendar.set(1999, 12, 12);
        singer.setMusicType(MusicType.POP);
        singer.setDateOfBirth(calendar.getTime());

        Musican chanter = new Musican();
        chanter.setId(2);
        chanter.setName("Edith Piaf");
        calendar.set(1999, 2, 2);
        chanter.setDateOfBirth(calendar.getTime());
        chanter.setMusicType(MusicType.FOLK);

        Musican saxophonist = new Musican();
        saxophonist.setId(3);
        saxophonist.setName("Kenny G");
        calendar.set(1999, 11, 11);
        saxophonist.setDateOfBirth(calendar.getTime());
        saxophonist.setMusicType(MusicType.INSTRUMENTAL);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(singer);
        em.persist(chanter);
        em.persist(saxophonist);

        em.getTransaction().commit();

        // Retrieve
        Musican musician = em.find(Musican.class, 3L);
        System.out.println("Musician pour PK 3: " + musician);

        // Update
        em.getTransaction().begin();
        musician = em.find(Musican.class, 2L);
        musician.setName("Les Gacons");
        em.getTransaction().commit();

        // Delete
        em.getTransaction().begin();
        musician = em.find(Musican.class, 1L);
        em.remove(musician);
        em.getTransaction().commit();
    }
}
