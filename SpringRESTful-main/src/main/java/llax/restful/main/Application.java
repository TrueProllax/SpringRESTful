package llax.restful.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
public class Application {
    
    private static String urlAPI = "https://raw.githubusercontent.com/TrueProllax/SpringRESTful/main/books.json";    
    
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        converter.setPrefixJson(true);
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        
        ToConvert toConvert = restTemplate.getForObject(urlAPI, ToConvert.class);
        
        ArrayList<LinkedHashMap> listUsers = toConvert.getUsers();
        
        for (LinkedHashMap item:listUsers){
            System.out.println(
                "id: " + item.get("userId") + " {\n" +
                "\t lastName: " + item.get("lastName") + "\n" +
                "\t emailAddress: " + item.get("emailAddress") + "\n}"
            );
        }
        
        Object object = restTemplate.getForEntity(urlAPI, Object.class);
    }

}
