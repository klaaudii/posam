package sk.posam.fsa.jpa;

import sk.posam.fsa.jpa.domain.Actor;
import sk.posam.fsa.jpa.domain.Category;
import sk.posam.fsa.jpa.domain.Film;
import sk.posam.fsa.jpa.domain.Language;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class JpaApplication {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dvdrental-pu-name");
        EntityManager em = factory.createEntityManager();

        //jpql
//        Query q = em.createQuery("select c from Category c");
//        List<Category> categories = q.getResultList();
//        for (Category category : categories) {
//            System.out.println(category);
//        }
//        System.out.println("Size: " + categories.size());

        // create new entry
//        em.getTransaction().begin();
//        Category category = new Category();
//        category.setName("This is a test");
//        category.setLastUpdated(new Date());
//        em.persist(category);  // z transient sa stala persistent
//        em.getTransaction().commit();
//        em.close();


//        Query q = em.createQuery("select l from Language l");
//        List<Language> languages = q.getResultList();
//        for (Language language : languages) {
//            System.out.println(language);
//        }
//        System.out.println("Size: " + languages.size());


//        Query q = em.createQuery("select f from Film f");
//        List<Film> films = q.getResultList();
//        for (Film film : films) {
//            System.out.println(film);
//        }
//        System.out.println("Size: " + films.size());


        // create new entry
//        em.getTransaction().begin();
//        Actor actor = new Actor();
//        actor.setFirstName("Jozef");
//        actor.setLastName("Cibula");
//        actor.setLastUpdated(new Date());
//        em.persist(actor);
//        em.getTransaction().commit();
//        Query q = em.createQuery("select a from Actor a WHERE a.lastName = 'Cibula'");
//        List<Actor> actors = q.getResultList();
//        for (Actor a : actors) {
//            System.out.println(a);
//        }

        Query q = em.createQuery("select a from Actor a");
        List<Actor> actors = q.getResultList();
        for (Actor a : actors) {
            System.out.println(a);
        }

        em.close();
    }
}