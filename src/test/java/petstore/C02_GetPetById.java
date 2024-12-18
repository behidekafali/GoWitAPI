package petstore;

import Utils.ObjectMapperUtils;
import base_url.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static petstore.C01_CreatePetPojo.expectedData;
import static petstore.C01_CreatePetPojo.petId;


public class C02_GetPetById extends PetStoreBaseUrl {

    @Test
    void getPetTest(){

        spec.pathParams("first", "pet","second", petId);



        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();


        PetPojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls().get(0), expectedData.getPhotoUrls().get(0));
        assertEquals(actualData.getPhotoUrls().get(1), expectedData.getPhotoUrls().get(1));
        assertEquals(actualData.getPhotoUrls().get(2), expectedData.getPhotoUrls().get(2));
        assertEquals(actualData.getTags().get(0).getName(), expectedData.getTags().get(0).getName());
        assertEquals(actualData.getTags().get(1).getName(), expectedData.getTags().get(1).getName());
        assertEquals(actualData.getTags().get(2).getName(), expectedData.getTags().get(2).getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }
}