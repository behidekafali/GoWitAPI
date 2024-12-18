package petstore;

import Utils.ObjectMapperUtils;
import base_url.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static petstore.C01_CreatePetPojo.petId;

public class C03_UpdatePet extends PetStoreBaseUrl {



    @Test
    void updatePetTest() {

        spec.pathParams("first", "pet");


        String strExpectedData = """
                           {
                                         
                                           "category": {
                                             "id": 0,
                                             "name": "Köpek"
                                           },
                                           "name": "Çomar",
                                           "photoUrls": [
                                             "url1", "url2"
                                           ],
                                           "tags": [
                                             {
                                               "id": 0,
                                               "name": "Kara"
                                             }
                                           ],
                                           "status": "sold"
                                         }
                """;

        PetPojo expectedData = ObjectMapperUtils.convertJsonStrToJava(strExpectedData, PetPojo.class);

       expectedData.setId(petId);
        System.out.println("expectedData = " + expectedData);


        Response response = given(spec).body(expectedData).put("{first}");
        response.prettyPrint();


        PetPojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls().get(0), expectedData.getPhotoUrls().get(0));
        assertEquals(actualData.getPhotoUrls().get(1), expectedData.getPhotoUrls().get(1));
        assertEquals(actualData.getTags().getFirst().getName(), expectedData.getTags().getFirst().getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }
}