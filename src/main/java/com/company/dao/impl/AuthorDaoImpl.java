package com.company.dao.impl;

import com.company.dao.AuthorDao;
import com.company.entity.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author findById(Integer id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void addAuthor(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void deleteAuthor(Integer authorId) {
        Author author = entityManager.find(Author.class, authorId);
        entityManager.remove(author);
    }

    @Override
    public Author findByUsername(String username) {
        return entityManager.createQuery("SELECT a from Author a where a.username = :username", Author.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public Long countAuthor() {
        return entityManager.createQuery("select count(a.username) from Author a", Long.class).getSingleResult();
    }
}
