package Pet.placeOrder;

import dto.Pet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PlacedOrderPetTest  extends PetBaseTest{
    Response response;
    Pet pet;
    Long orderID = 11L; //Задает id
    String pathOrderGet="/11"; //Задает путь для метода GET


    /**
     * Тест выполняет метод Post с заданными полями
     * Проверяет, что ответ возвращает статус 200
     */
    @Test
    @Order(1)
    public void postOrderPetStatus200() {

        pet = Pet.builder()
                .Id(orderID)
                .PetId(0L)
                .Quantity(0)
                .Complete(false)
                .Status("placed")
                .build();


        response = petApi.placeOrderPetPost(pet);

        response
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);
    }

    /**
     * Тест выполняет метод Post с заданными полями
     * Проверяет, что ответ возвращает "placed" для поля Status
     */
    @Test
    @Order(1)
    public void postOrderPetCheckStatus() {

        pet = Pet.builder()
                .Id(orderID)
                .PetId(0L)
                .Quantity(0)
                .Complete(false)
                .Status("placed")
                .build();


        response = petApi.placeOrderPetPost(pet);

        response
                .then()
                .log().all()
                ;

        assertEquals("placed",pet.getStatus());

    }
    /**
     * Тест выполняет метод Get с заданными полями
     * Проверяет, что ответ возвращает статус 200
     */
    @Test
    @Order(2)
    public void getOrderPetStatus200(){

        response = petApi.placeOrderPetGet(pathOrderGet);

        response
                  .then()
                  .log().all()
                  .statusCode(HttpStatus.SC_OK);
    }

    /**
     * Тест выполняет метод Post с заданными полями
     * Проверяет, что ответ возвращает false для поля Complete
     */
    @Test
    @Order(2)
    public void getOrderPetCheckCompleteField(){

        response = petApi.placeOrderPetGet(pathOrderGet);

        response
                .then()
                .log().all()
                ;

        Assertions.assertEquals(false,response.jsonPath().get("complete"));

    }
}
