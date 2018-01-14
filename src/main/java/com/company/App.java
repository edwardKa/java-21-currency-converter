package com.company;

import com.company.model.FixerCurrencyResponse;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
public class App {

    @SneakyThrows
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        //base one of what to convert
        //symbols to what to convert
        String url = "https://api.fixer.io/latest";

//        FixerCurrencyResponse body = restTemplate
//                .getForEntity(url, FixerCurrencyResponse.class)
//                .getBody();

        ResponseEntity<FixerCurrencyResponse> response =
                restTemplate
                .getForEntity(url, FixerCurrencyResponse.class);
        FixerCurrencyResponse body = response.getBody();
        HttpStatus statusCode = response.getStatusCode();
        int statusCodeValue = response.getStatusCodeValue();
        System.out.println("BODY: " + body.toString());
        System.out.println(statusCode.name());
        System.out.println(statusCodeValue);

    }
}
