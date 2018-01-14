package com.company;

import com.company.model.FixerCurrencyResponse;
import lombok.SneakyThrows;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Graphic {
    @SneakyThrows
    public static void main(String[] args) {
        String [][] field = new String[10][100];
        for (int i = 0; i < 10; i++) {
            LocalDate localDate = LocalDate.now();
            localDate = localDate.minus(i, ChronoUnit.YEARS);
            FixerCurrencyResponse fixerCurrencyResponse = getByDate(localDate);
            int usdRate = (int) (fixerCurrencyResponse.getRates().get("EUR") * 10);
            field[usdRate][i*10] = "@";
        }

        for (String [] line : field) {
            for (String position : line) {
                if (position == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(position);
                }
            }
            System.out.println();
        }






    }

    private static FixerCurrencyResponse getByDate(LocalDate localDate) {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("https://api.fixer.io/%s?symbols=EUR,USD&base=USD", localDate);

        return restTemplate.getForEntity(url, FixerCurrencyResponse.class).getBody();
    }
}
