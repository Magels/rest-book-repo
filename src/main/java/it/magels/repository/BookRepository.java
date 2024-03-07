package it.magels.repository;

import it.magels.model.Book;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository
{
    public List<Book> getAllBooks()
    {
        return List.of(
                new Book(1,"Quarkus Introduction","Antonio",2024,"IT"),
                new Book(2,"Quarkus Practise","John",2024,"IT"),
                new Book(3,"Quarkus and Java","Bill",2022,"IT"),
                new Book(4,"Development whit Quarkus","Stan",2020,"IT")
        );
    }

    public int countAllBooks()
    {
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id)
    {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }

}
