package com.ybi.dm.cartable;

import com.ybi.dm.cartable.models.Table;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bouddha on 27/11/2017.
 */
public class DBTest {

    @Test
    public void testDBConnectWrite() {
        System.out.println("Hello");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("e:/coding/java/Workspace/cartable/test.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Table table = new Table();
        table.setName("zeoifzp");
        table.setDescription("zpeofpze");
        table.setSchema("zefjoze");
        table.setSource("zoiefoz");
        table.setLocation("zoeifozeifzoeif");
        table.setCreation(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        table.setUpdated(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        table.setVersion("v1.0a");
        table.setStatus("active");
        em.persist(table);
        em.getTransaction().commit();
        emf.close();
    }

    @Test
    public void testDBConnectRead() {
        System.out.println("Hello");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("e:/coding/java/Workspace/cartable/test.odb");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        //em.getTransaction().commit();
        long count = em.createQuery("SELECT count(t) FROM Table t", Long.class).getSingleResult();
        System.out.println("Table Count " + count);
        Table table = em.createQuery("SELECT t FROM Table t", Table.class).setFirstResult(0).setMaxResults(1).getSingleResult();
        System.out.println("Table Name " + table.getName());
        List<Table> tables = em.createQuery("SELECT t FROM Table t", Table.class).getResultList();
        for (Table t : tables) {
            System.out.println("Table Name " + t.getName() + " - " + t.getId());
        }
        emf.close();
    }
}
