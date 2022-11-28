package com.spring.project.SpringWebApp.Controller;

import com.spring.project.SpringWebApp.Repositories.BookRepository;
import com.spring.project.SpringWebApp.Repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class AppController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model model){

        model.addAttribute("authors", publisherRepository.findAll());

        return "authors/list";
    }
}
