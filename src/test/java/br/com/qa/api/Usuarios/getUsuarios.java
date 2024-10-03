package br.com.qa.api.Usuarios;


import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class getUsuarios {

    @Test
    public void getTestes() {

        baseURI = "https://reqres.in/api/users";

        given()
                .when()
                .get("/?page=2")
                .then()
                .log().body()
                .statusCode(200)
                .body("last_name", not(empty()))
                .and()
                .body("first_name", not(empty()))
                .and()
                .body(containsString("Michael"));
    }
}
