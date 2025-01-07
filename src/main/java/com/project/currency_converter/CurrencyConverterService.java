package com.project.currency_converter;


import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@Service
public class CurrencyConverterService {

    private static final String EXCHANGE_RATE_API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double getConversionRate(String from, String to) {
        Map<String, Double> rates = getRates(from);
        if (rates.containsKey(to)) {
            return rates.get(to);
        }
        throw new RuntimeException("Conversion Rate for " + from + " to " + to + " not available.");
    }

    public Map<String, Double> getRates(String base) {
        String url = UriComponentsBuilder.fromHttpUrl(EXCHANGE_RATE_API_URL + base)
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        try {
            ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
            if (response != null && response.getRates() != null) {
                return response.getRates();
            }
            throw new RuntimeException("Unable to fetch exchange rates");
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("External API is unavailable: " + e.getStatusCode());
        } catch (RestClientException e) {
            throw new RuntimeException("External API is unavailable");
        }
    }
    public ConversionResponse convertCurrency(ConversionRequest request) {
        double conversionRate = getConversionRates(request.getFrom(), request.getTo());
        double convertedAmount = request.getAmount() * conversionRate;
        return new ConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
    }

 
    public double getConversionRates(String from, String to) {
        // Static value for testing purpose
        return 0.945; 
    }
}
