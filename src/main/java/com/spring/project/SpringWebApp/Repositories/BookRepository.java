package com.spring.project.SpringWebApp.Repositories;

import com.spring.project.SpringWebApp.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
