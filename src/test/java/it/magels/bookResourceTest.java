package it.magels;

import io.quarkus.test.junit.QuarkusTest;
import it.magels.model.Book;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class bookResourceTest
{
    @Test
    void shouldGetAllBooks()
    {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .get("/api/books")
                .then()
                .statusCode(200)
                .body("size()",is(4));
    }

    @Test
    void shouldCountAllBooks()
    {
        given()
                .header(HttpHeaders.ACCEPT,MediaType.TEXT_PLAIN)
                .when()
                .get("/api/books/bookcount")
                .then()
                .statusCode(200)
                .body(is("4"));
    }

    @Test
    void shouldGetBook()
    {
        given()
                .header(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON)
                .pathParam("id",1)
                .when()
                .get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("title",is("Quarkus Introduction"))
                .body("author",is("Antonio"))
                .body("yearOfPublication",is(2024))
                .body("genre",is("IT"));
    }
}