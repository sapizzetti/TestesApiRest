package br.com.restAssured.api.Simulacoes;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.junit.Test;
import src.Simulacao;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.containsString;


public class PostSimulacoesTest {

    @Test
    public void postSimulacoes() {

        baseURI = "http://localhost:8080/api/v1";

        Simulacao simulacaoJoao = new Simulacao("55326136309", "João da Silva", "emailum@email.com", 1000, 3, true);
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoJoao)
                .post("/simulacoes")
                .then()
                .log().body()
                .statusCode(201)
                .body(containsString("João da Silva"));

        Simulacao simulacaoJoaoDois = new Simulacao("55326136309", "João da Silva", "emaildois@email.com", 1000, 3, true);
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoJoaoDois)
                .post("/simulacoes")
                .then()
                .log().body()
                .statusCode(409)
                .body(containsString("CPF já existente"));

        Simulacao simulacaoMaria = new Simulacao("15519079170", "Maria da Silva", "emailtres@email.com", 25333, 2, true);
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoMaria)
                .post("/simulacoes")
                .then()
                .log().body()
                .statusCode(201)
                .body(containsString("Maria da Silva"));

        Simulacao simulacaoTereza = new Simulacao("31873121288", "Tereza da Silva", "emailquatro@email.com", 12000, 1, false);
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoTereza)
                .post("/simulacoes")
                .then()
                .log().body()
                .statusCode(400)
                .body(containsString("Parcelas deve ser igual ou maior que 2"));

        Simulacao simulacaoPedro = new Simulacao("61637353405", "Pedro da Silva", "emailcinco@email.com", 40000, 48, true);
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoPedro)
                .post("/simulacoes")
                .then()
                .log().body()
                .statusCode(201)
                .body(containsString("Pedro da Silva"));

        Simulacao simulacaoJoel = new Simulacao("00166648760", "Joel da Silva", "emailseis@email.com", 45000, 20, false);
        given()
                .contentType(ContentType.JSON)
                .body(simulacaoJoel)
                .post("/simulacoes")
                .then()
                .log().body()
                .statusCode(400)
                .body(containsString("Valor deve ser menor ou igual a R$ 40.000"));

    }

}
