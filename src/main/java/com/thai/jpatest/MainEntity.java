package com.thai.jpatest;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.MusicType;
import com.thai.model.Musician;
import com.thai.model.Musician;

public class MainEntity {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        Musician singer = new Musician();
        singer.setId(1);
        singer.setName("Adele");
        calendar.set(1999, 12, 12);
        singer.setMusicType(MusicType.POP);
        singer.setDateOfBirth(calendar.getTime());

        Musician chanter = new Musician();
        chanter.setId(2);
        chanter.setName("Edith Piaf");
        calendar.set(1999, 2, 2);
        chanter.setDateOfBirth(calendar.getTime());
        chanter.setMusicType(MusicType.FOLK);

        Musician saxophonist = new Musician();
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
        Musician musician = em.find(Musician.class, 3L);
        System.out.println("Musician pour PK 3: " + musician);

        // Update
        em.getTransaction().begin();
        musician = em.find(Musician.class, 2L);
        musician.setName("Les Gacons");
        em.getTransaction().commit();

        // Delete
        em.getTransaction().begin();
        musician = em.find(Musician.class, 1L);
        em.remove(musician);
        em.getTransaction().commit();
    }
}
