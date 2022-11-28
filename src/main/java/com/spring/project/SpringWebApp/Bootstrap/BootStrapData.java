package com.spring.project.SpringWebApp.Bootstrap;

import com.spring.project.SpringWebApp.Model.Author;
import com.spring.project.SpringWebApp.Model.Book;
import com.spring.project.SpringWebApp.Model.Publisher;
import com.spring.project.SpringWebApp.Repositories.AuthorRepository;
import com.spring.project.SpringWebApp.Repositories.BookRepository;
import com.spring.project.SpringWebApp.Repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Author sujit = new Author("sujit", "sable");
        Book fame = new Book("Fame of Sujit", "12345");
        Publisher john = new Publisher();

        john.setName("John");
        john.setAddress("Bhoom, Osmanabad India");


        sujit.getBooks().add(fame);
        fame.getAuthors().add(sujit);
        john.getBooks().add(fame);

        authorRepository.save(sujit);
        bookRepository.save(fame);
        publisherRepository.save(john);

        Author ajay = new Author("ajay", "sable");
        Book goat = new Book("hall of fame", "1234589");

        ajay.getBooks().add(goat);
        goat.getAuthors().add(ajay);
        john.getBooks().add(goat);

        authorRepository.save(ajay);
        bookRepository.save(goat);
        publisherRepository.save(john);

        System.out.println("started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count() + "Publisher Count: " + publisherRepository.count());
    }
}
