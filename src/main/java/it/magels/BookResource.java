package it.magels;


import it.magels.model.Book;
import it.magels.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)//The API returns a Book object in JSON format. We specify in the @Produces APPLICATION_JSON as the MediaType for this purpose. Binding from Java object to json is obtained implicitly by JSON-B .
public class BookResource
{

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger logger;

    //The method returns a list of books in JSON format.
    //The conversion from Book as a Java object to Book in JSON format is done by JSON-B
    @GET
    public List<Book> getAllBooks()
    {
        logger.info("getAllBooks() method - He returns all books");
        return  bookRepository.getAllBooks();
    }

    //The method returns the number of books contained in the book list.
    //We specify in the @Produces TEXT_PLAIN as the MediaType to return a number of book in the list as a string.
    @GET
    @Path("/bookcount")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks()
    {
        logger.info("countAllBooks() method - He returns the number of books");
        return bookRepository.countAllBooks();
    }

    //The method returns the first book (in JSON format) with specified id passed as parameter.
    //The conversion from Book as a Java object to Book in JSON format is done by JSON-B.
    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id)
    {
        logger.info("getBook() method - He returns a single book with specified id: "+id);
        return bookRepository.getBook(id);
    }
}
