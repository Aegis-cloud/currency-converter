package com.project.currency_converter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrencyConverterServiceTest {

    
    private CurrencyConverterService currencyConverterService;

    @BeforeEach
    void setUp() {
        // Initialize the service before each test
        currencyConverterService = new CurrencyConverterService();
    }

    @Test
    void testConvertCurrency() {
        System.out.println("*****STARTED TESTING********");
        
        ConversionRequest request = new ConversionRequest("USD", "EUR", 100);

    
        ConversionResponse response = currencyConverterService.convertCurrency(request);
        System.out.println("FROM:" + response.getFrom());
        System.out.println("TO:" + response.getTo());
        System.out.println("Amount:" + response.getAmount());
        assertNotNull(response, "The response should not be null");
        assertEquals("USD", response.getFrom(), "The 'from' currency should be USD");
        assertEquals("EUR", response.getTo(), "The 'to' currency should be EUR");
        assertEquals(100, response.getAmount(), "The amount should be 100");
        assertTrue(response.getConvertedAmount() > 0, "The converted amount should be greater than 0");
        System.out.println("Converted amount: " + response.getConvertedAmount());
    }
}
