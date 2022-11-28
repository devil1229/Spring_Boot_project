package com.spring.project.SpringWebApp.Bootstrap;

import com.spring.project.SpringWebApp.Model.Author;
import com.spring.project.SpringWebApp.Model.Book;
import com.spring.project.SpringWebApp.Model.Publisher;
import com.spring.project.SpringWebApp.Repositories.AuthorRepository;
import com.spring.project.SpringWebApp.Repositories.BookRepository;
import com.spring.project.SpringWebApp.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

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

        System.out.println("started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count() + "Publisher Count: " + publisherRepository.count());
    }
}
