package com.example.restful;

import com.example.restful.model.News;
import com.example.restful.model.Structure;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
public class RestfulApplication {
    
    private static String apiKey = "-u53fdT_EvUWuG7IOBy04VTyqXGNqMwNNkZ3RL30tJYc4mbR";
    private static String url = "https://api.currentsapi.services/v1/latest-news?apiKey=" + apiKey;

    public static void main(String[] args) {
	
        //https://www.currentsapi.services/en/docs/
        //https://stackabuse.com/spring-boot-guide-to-resttemplate/
        
        RestTemplate restTemplate = new RestTemplate();
        
        Structure st =  restTemplate.getForObject(url, Structure.class);
        

        List <LinkedHashMap> listNews = st.getNews();
        
        for (LinkedHashMap item:listNews) {
            System.out.println(
                "id: " + item.get("id") + " {\n" +
                "\t title: " + item.get("title") + "\n" +
                "\t author: " + item.get("author") + "\n}"
            );
            
        }
        
        System.out.println("");
    }

}
