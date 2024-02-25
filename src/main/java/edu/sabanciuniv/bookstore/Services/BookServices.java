package edu.sabanciuniv.bookstore.Services;

import edu.sabanciuniv.bookstore.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class BookServices {

    private final EntityManager em = Persistence.createEntityManagerFactory("it526").createEntityManager();

    public void saveBook(String title, String name, String author, String publishYear, String genre) {

        try {
            em.getTransaction().begin();
            Book book = new Book(0, name, title, author, publishYear, genre);
            em.persist(book);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }


    }

    public void getBook() {
    }

    public List<Book> getAllBook() {

        try {
            em.getTransaction().begin();
            var books = em.createQuery("select b from Book b").getResultList();
            em.getTransaction().commit();
            System.out.println(books);
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return null;

    }

    public void deleteBook(int id) {

        try {
            em.getTransaction().begin();
            Book book = em.find(Book.class, id);
            em.remove(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void updateBook(int id, String name, String title, String author, String year, String genre) {
        try {
            em.getTransaction().begin();
            Book book = em.find(Book.class, id);
            book.setBookName(name);
            book.setBookTitle(title);
            book.setBookAuthor(author);
            book.setBookPublisher(year);
            book.setGenre(genre);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Book> searchBook(String searchType, String searchQuery) {
        var type = searchType == "Title" ? "bookTitle" : "bookAuthor";

        try {
            em.getTransaction().begin();
            String query = String.format(
                    "SELECT * FROM Book b WHERE bookName LIKE '%%%s%%' OR bookAuthor LIKE '%%%s%%' OR bookName = '%s' OR bookAuthor = '%s';",
                    searchQuery, searchQuery, searchQuery, searchQuery
            );

            var books = em.createNativeQuery(query, Book.class)
                    .getResultList();
            em.getTransaction().commit();
            System.out.println(searchQuery);
            System.out.println(books);
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return null;

    }


}
