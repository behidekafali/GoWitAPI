package petstore;

import base_url.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static petstore.C01_CreatePetPojo.petId;

public class C04_DeletePet extends PetStoreBaseUrl {


    @Test
    void deletePetTest() {

        spec.pathParams("first", "pet", "second", petId);


        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();


        response.then().statusCode(200).body("message", equalTo(petId+""));

    }
}

