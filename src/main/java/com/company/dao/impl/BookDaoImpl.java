package com.company.dao.impl;

import com.company.dao.BookDao;
import com.company.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public Book findById(Integer id) {
        return entityManager.createQuery("select b from Book b where b.id = :id", Book.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Book> getAllBooksSorted() {
        return entityManager.createQuery("select b from Book b order by b.name asc", Book.class)
                .getResultList();
    }

    @Override
    public List<Book> getBooksByUsername(String username) {
        return entityManager.createQuery("select b from Book b where b.author.username = :username",
                Book.class).setParameter("username", username).getResultList();
    }

    @Override
    public Long countBooks() {
        return entityManager.createQuery("SELECT count(b.name) from Book b",Long.class).getSingleResult();
    }
}
