package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {


    public static <T> T convertJsonStrToJava(String JsonStr, Class<T> classType) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(JsonStr, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
