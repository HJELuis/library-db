package model;

import dto.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserModel {
    private final EntityManager entityManager;

    public UserModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user){
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public void update(User user) {
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }

    }

    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    public void remove(User user){
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(user);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }
}
