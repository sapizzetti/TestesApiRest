package br.com.qa.api.Usuarios;


import io.restassured.http.ContentType;
import org.junit.Test;
import src.Usuarios;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class postUsuarios {

    @Test
    public void postUsuariosQA() {

        baseURI = "https://reqres.in/api/users";

        Usuarios usuarioSucesso = new Usuarios("Samara", "QA");

        given()
                .contentType(ContentType.JSON)
                .body(usuarioSucesso)
                .post()
                .then()
                .assertThat()
                .body("name", equalTo("Samara"))
                .and()
                .body("job", equalTo("QA"))
                .and()
                .body("id", not(empty()))
                .and()
                .body("createdAt", not(empty()))
                .log().body()
                .statusCode(201);
    }
}
