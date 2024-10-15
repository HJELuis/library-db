package model;

import dto.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AuthorModel {
    private final EntityManager entityManager;

    public AuthorModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Author author) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(author);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public void update(Author author) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(author);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public Author getById(int id) {
        return entityManager.find(Author.class, id);
    }

    public void remove(Author author) {
        EntityTransaction transaction = entityManager.getTransaction();

        Author managedAuthor = entityManager.find(Author.class, author.getIdAuthor());

        try {
            transaction.begin();
            entityManager.remove(managedAuthor);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }

    }
}
