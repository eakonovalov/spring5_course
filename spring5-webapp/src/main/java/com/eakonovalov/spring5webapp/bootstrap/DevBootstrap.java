package com.eakonovalov.spring5webapp.bootstrap;

import com.eakonovalov.spring5webapp.model.Author;
import com.eakonovalov.spring5webapp.model.Book;
import com.eakonovalov.spring5webapp.model.Publisher;
import com.eakonovalov.spring5webapp.repositories.AuthorRepository;
import com.eakonovalov.spring5webapp.repositories.BookRepository;
import com.eakonovalov.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher hc = new Publisher("Harper Collins");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        hc.getBooks().add(ddd);

        publisherRepository.save(hc);
//        authorRepository.save(eric);
        bookRepository.save(ddd);
        authorRepository.save(eric);

        Publisher wrox = new Publisher("Wrox");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "4321", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(wrox);
//        authorRepository.save(rod);
        bookRepository.save(noEJB);
        authorRepository.save(rod);
    }
}
