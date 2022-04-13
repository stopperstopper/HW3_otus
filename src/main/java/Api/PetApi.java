package Api;

import dto.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    private RequestSpecification spec;
    private static  String PATH = "/store/order";


    public PetApi() {

        spec = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON);
    }

    public Response placeOrderPetPost(Pet pet) {
        return
                given(spec)
                        .with()
                        .body(pet)
                        .log().all()
                        .when()
                        .post(PATH)
                        ;
    }

    public <Order> Response placeOrderPetGet(Order order) {
        return
                given(spec)
                        .with()
                       // .body(pet)
                        .log().all()
                        .when()
                        .get(PATH+ order)
                ;
    }
}
