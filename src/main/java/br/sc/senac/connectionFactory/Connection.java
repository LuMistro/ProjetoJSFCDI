package br.sc.senac.connectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    public static EntityManager getConnection() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CadastroPessoa-PU");
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
}
