package com.lfreitas.spring5demo.bootstrap;

import com.lfreitas.spring5demo.domain.Author;
import com.lfreitas.spring5demo.domain.Book;
import com.lfreitas.spring5demo.domain.Publisher;
import com.lfreitas.spring5demo.repositories.AuthorRepository;
import com.lfreitas.spring5demo.repositories.BookRepository;
import com.lfreitas.spring5demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher("Rua turiassu", "Sao Paulo", "SP", 32324242L);
        publisherRepository.save(publisher);
        System.out.println("Publisher: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author leo = new Author("Leonardo", "freitas");
        Book lorem = new Book("Lorem Ipsum", "122121");
        leo.getBooks().add(lorem);
        lorem.getAuthors().add(leo);

        authorRepository.save(leo);
        bookRepository.save(lorem);

        System.out.println("Authors: " + authorRepository.count());
        System.out.println("Books: " + bookRepository.count());

        publisher.getBooks().add(ddd);
        publisher.getBooks().add(lorem);
        publisher.setName("Lorem Ipsum");
        publisherRepository.save(publisher);
    }
}
