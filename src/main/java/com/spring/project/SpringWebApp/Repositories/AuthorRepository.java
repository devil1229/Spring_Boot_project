package com.spring.project.SpringWebApp.Repositories;

import com.spring.project.SpringWebApp.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
