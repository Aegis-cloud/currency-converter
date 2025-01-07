# Currency Converter

A simple Spring Boot application that provides currency conversion services by fetching real-time exchange rates from an external API.

## Features
- Fetch current exchange rates for a given base currency.
- Convert an amount from one currency to another using the exchange rates.
- Graceful handling of errors when the external API is unavailable.

---

## Technologies Used
- Java
- Spring Boot
- RestTemplate (for API requests)
- Maven (for build and dependency management)

---

## Base URL
http://localhost:8080/api

---

## Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Any IDE (I used Visual Studio Code)

---
## Project Structure

currency-converter/ │ ├── src/ │ ├── main/ │ │ ├── java/com/project/currency_converter/ │ │ │ ├── CurrencyConverterApplication.java │ │ │ ├── CurrencyConverterService.java │ │ │ ├── ConversionRequest.java │ │ │ ├── ConversionResponse.java │ │ │ └── ExchangeRateResponse.java │ │ └── resources/ │ │ └── application.properties │ └── test/ │ └── java/com/project/currency_converter/ │ └── CurrencyConverterServiceTest.java ├── pom.xml ├── README.md └── .gitignore 

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Aegis-cloud/currency-converter.git
   cd currency-converter
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## Running Tests
Run the unit tests using:
```bash
mvn test
```

---

## Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Test

---

## Using POSTMAN

1. Fetch all available rates:
   - Method: GET
   - URL: `http://localhost:8080/api/rates`

   ```json
   // Response example:
   {
     ....
           "EUR": 0.85,
           "GBP": 0.75,
           "INR": 74.5
     ....
   }
   ```

2. Convert an amount from one currency to another:
   - Method: POST
   - URL: `http://localhost:8080/api/convert`

   - Body (raw - JSON):
     ```json
     {
         "from": "USD",
         "to": "EUR",
         "amount": 100
     }
     ```
   - Response (raw - JSON):
     ```json
     {
         "from": "USD",
         "to": "EUR",
         "amount": 100.0,
         "convertedAmount": 96.3
     }
     ```

