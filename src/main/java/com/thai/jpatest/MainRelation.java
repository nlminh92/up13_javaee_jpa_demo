package com.thai.jpatest;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.Instrument;
import com.thai.model.InstrumentType;
import com.thai.model.MusicType;
import com.thai.model.Musician;
import com.thai.model.Song;

public class MainRelation {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        Musician singer = new Musician();
        singer.setId(1);
        singer.setName("Adele");
        calendar.set(1999, 12, 12);
        singer.setMusicType(MusicType.POP);
        singer.setDateOfBirth(calendar.getTime());

        Instrument instrument = new Instrument();
        instrument.setId(1);
        instrument.setName("Piano");
        instrument.setInstrumentType(InstrumentType.KEYBOARD);

        instrument.setMusician(singer);

        singer.setInstrument(instrument);

        Song song1 = new Song();
        song1.setName("If I were a boy");
        song1.setMusician(singer);

        Song song2 = new Song();
        song2.setName("If I ain't got you");
        song2.setMusician(singer);

        singer.setSong(song1);
        singer.setSong(song2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(singer);

        em.getTransaction().commit();

        System.out.println(singer);
        System.out.println(instrument);

    }
}
