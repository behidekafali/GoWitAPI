package petstore;

import base_url.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static petstore.C01_CreatePetPojo.petId;


public class C05_GetPetByIdNegative extends PetStoreBaseUrl {


    @Test
    void getPetTest() {

//        spec.pathParams("first", "pet", "second", petId);
//
//
//        Response response = given(spec).get("{first}/{second}");
//        response.prettyPrint();
//
//
//        response
//                .then()
//                .statusCode(404)
//                .body("message", equalTo("Pet not found"));








    }
}