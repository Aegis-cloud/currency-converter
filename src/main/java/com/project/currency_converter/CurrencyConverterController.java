package com.project.currency_converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.currency_converter.ConversionRequest;
import com.project.currency_converter.ConversionResponse;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    // GET /api/rates?base=USD
    @GetMapping("/rates")
    public Map<String, Double> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return currencyConverterService.getRates(base);
    }

    // POST /api/convert
    @PostMapping("/convert")
    public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
        double conversionRate = currencyConverterService.getConversionRate(request.getFrom(), request.getTo());
        double convertedAmount = request.getAmount() * conversionRate;
        return new ConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
    }
}
