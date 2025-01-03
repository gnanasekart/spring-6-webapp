package tgs.springframework.spring_6_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tgs.springframework.spring_6_webapp.domain.Author;
import tgs.springframework.spring_6_webapp.domain.Book;
import tgs.springframework.spring_6_webapp.domain.Publisher;
import tgs.springframework.spring_6_webapp.repositories.AuthorRepository;
import tgs.springframework.spring_6_webapp.repositories.BookRepository;
import tgs.springframework.spring_6_webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author();
        author.setFirstName("Gnana");
        author.setLastName("Sekar");

        Book book = new Book();
        book.setTitle("Spring 5 Recipes");
        book.setIsbn("978-1-4842-4224-3");

        Publisher pub = new Publisher();
        pub.setPublisherName("Packt Publishing");
        pub.setAddress("SILK");
        pub.setState("KA");
        pub.setCity("MY");
        pub.setZip("560033");

        Author authorSave = authorRepository.save(author);
        Book bookSave = bookRepository.save(book);
        Publisher publisher = publisherRepository.save(pub);

        Author tgs = new Author();
        tgs.setFirstName("sus");
        tgs.setLastName("sss");

        Book book1 = new Book();
        book1.setTitle("me");
        book1.setIsbn("978-1-4842");

        Author authorSave1 = authorRepository.save(tgs);
        Book bookSave1 = bookRepository.save(book1);

        author.getBooks().add(book1);
        tgs.getBooks().add(book);

        authorRepository.save(author);
        authorRepository.save(tgs);

        System.out.println("Author count: "+ authorRepository.count());
        System.out.println("Book count: "+ bookRepository.count());
        System.out.println("Publisher count: "+ publisherRepository.count());
    }
}
