package com.codingdojo.books.repositories;


import com.codingdojo.books.models.book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<book, Long> {
    // this method retrieves all the books from the database
    List<book> findAll();

    // this method finds books with descriptions containing the search string
    List<book> findByDescriptionContaining(String search);

    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);

    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}
