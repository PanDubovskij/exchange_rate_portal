# Exchange Rate Portal

The Exchange Rate Portal is a web application that provides users with the latest exchange rates from the Bank of
Lithuania, historical exchange rate data, and a currency calculator for converting amounts between different currencies.

## Features

- **Central Bank Exchange Rates**: Display the latest exchange rates from the Bank of Lithuania.
- **Exchange Rate History**: View the historical exchange rates for a specific currency in a table format.
- **Currency Calculator**: Convert amounts between currencies using the latest exchange rates.

## Using the project on live environment

The final app hosted on https://exchange-rate-portal-client-production.up.railway.app/.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing
purposes.

### Prerequisites

- Docker

### Installing

To set up the project for development:

1. Clone the repository from branch master to your local machine.
   ```sh
   git clone https://example.com/exchange-rate-portal.git
   cd exchange-rate-portal
2. Run docker command.
   ```sh
   docker compose up
3. Open your web browser and navigate to http://localhost:4200 to view the application.
4. By the way the backend listen http://localhost:8080 and possible urls are:

- GET /api/v0.0.2/exchange-rates-portal/current-rates
- GET /api/v0.0.2/exchange-rates-portal/rates-for-currency?currencyCode=USD
- GET /api/v0.0.2/exchange-rates-portal/all-rates

### Built With

- Spring Boot - The backend framework used
- Maven - Dependency Management
- Angular - Frontend Framework
- H2 Database - Lightweight database for data storage

### Author

- [@Jan Dubovsky](https://github.com/PanDubovskij)