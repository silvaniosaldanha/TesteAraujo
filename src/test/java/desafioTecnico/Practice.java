package desafioTecnico;

import io.restassured.http.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Practice {

    //Cadastrar novo pedido de pet com sucesso (POST/store/order)
    @Test
    public void cadastrarPedidoDePetComSucesso() {
        JSONObject store = new JSONObject();
        store.put("id", 9999);
        store.put("petId", 1234);
        store.put("quantity", 1);
        store.put("shipDate", "2025-04-15T18:09:30.675Z");
        store.put("status", "placed");
        store.put("complete", true);

        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/store/order")
                .contentType(ContentType.JSON)
                .body(store)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("id", equalTo(9999));
    }

    // Pesquisar por um pet inexistente (GET/pet/{petId})
    @Test
    public void pesquisarPetInexistente() {

        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/{petId}")
                .pathParam("petId", 44109)
                .when()
                .get()
                .then()
                .statusCode(404)
                .body("message", containsString("Pet not found"));
    }

    // Atualizar dados de um pet existente (PUT/pet)
    @Test
    public void atualizarPetExistente() {
        JSONObject category = new JSONObject();
        category.put("id", 123);
        category.put("name", "gato theo");

        JSONArray photoUrls = new JSONArray();
        photoUrls.add("http://foto.com/gato.png");

        JSONObject tag = new JSONObject();
        tag.put("id", 1);
        tag.put("name", "fofo");

        JSONArray tags = new JSONArray();
        tags.add(tag);

        JSONObject pet = new JSONObject();
        pet.put("id", 263);
        pet.put("category", category);
        pet.put("name", "Bichano");
        pet.put("photoUrls", photoUrls);
        pet.put("tags", tags);
        pet.put("status", "available");

        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put()
                .then()
                .statusCode(200)
                .body("name", equalTo("Bichano"));
    }

    // Pesquisar por pets com status “pending” (GET/pet/findByStatus)
    @Test
    public void pesquisarPetsPorStatusPending() {
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/findByStatus")
                .queryParam("status", "pending")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("status", everyItem(equalTo("pending")));
    }
}
