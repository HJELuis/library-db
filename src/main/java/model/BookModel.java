package model;

import dto.Author;
import dto.Book;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookModel {

    private final EntityManager entityManager;

    public BookModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Book book){
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public void update(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.merge(book);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }

    }

    public Book getById(int id) {
        return entityManager.find(Book.class, id);
    }

    public void remove(Book book){
        EntityTransaction transaction = entityManager.getTransaction();

        Book managedBook = entityManager.find(Book.class, book.getIdBook());

        try {
            transaction.begin();
            entityManager.remove(managedBook);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }
}
