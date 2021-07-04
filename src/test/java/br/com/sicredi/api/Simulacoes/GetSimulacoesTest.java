package br.com.sicredi.api.Simulacoes;


import org.junit.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetSimulacoesTest {

    @Test
    public void getSimulacoes() {

        baseURI = "http://localhost:8080/api/v1";

        String cpfJoao = "55326136309";
        String cpfMaria = "15519079170";
        String cpfTereza = "31873121288";
        String cpfPedro = "61637353405";
        String cpfJoel = "00166648760";


        given()
                .pathParam("cpf", cpfJoao)
                .when()
                .get("/simulacoes/{cpf}")
                .then()
                .log().body()
                .statusCode(200)
                .body("cpf", notNullValue())
                .and()
                .body("nome", not(empty()))
                .and()
                .body(containsString("João"));

        given()
                .pathParam("cpf", cpfMaria)
                .when()
                .get("/simulacoes/{cpf}")
                .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("cpf", notNullValue())
                .and()
                .body("nome", not(empty()))
                .and()
                .body(containsString("Maria"));

        given()
                .pathParam("cpf", cpfTereza)
                .when()
                .get("/simulacoes/{cpf}")
                .then()
                .log().body()
                .assertThat()
                .statusCode(404)
                .body(containsString("CPF 31873121288 não encontrado"));

        given()
                .pathParam("cpf", cpfPedro)
                .when()
                .get("/simulacoes/{cpf}")
                .then()
                .log().body()
                .statusCode(200)
                .body("cpf", notNullValue())
                .and()
                .body("nome", not(empty()))
                .and()
                .body(containsString("Pedro"));

        given()
                .pathParam("cpf", cpfJoel)
                .when()
                .get("/simulacoes/{cpf}")
                .then()
                .log().body()
                .statusCode(404)
                .body(containsString("CPF 00166648760 não encontrado"));

    }
}
