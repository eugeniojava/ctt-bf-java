# ctt-bf-java


## System details

This is an API that centralizes information about vaccinations against COVID-19 in Brazilian cities. To generate a report, information about vaccinations must be provided, such as: city (previously registered. Also, needs a previously registered state to be assigned), date, total number of vaccinates and the name of the vaccine (previously registered) used in these vaccinations

## Endpoints

API prefix for all endpoints: /api/v1

### States

- GET /states
- GET /states/{id}
- POST /states
- PUT /states/{id}
- DELETE /states/{id}

### Cities

- GET /cities
- GET /cities/{id}
- POST /cities
- PUT /cities/{id}
- DELETE /cities/{id}

### Vaccines

- GET /vaccines
- GET /vaccines/{id}
- POST /vaccines
- PUT /vaccines/{id}
- DELETE /vaccines/{id}

### Reports

- GET /reports
- GET /reports/{id}
- POST /reports
- PUT /reports/{id}
- DELETE /reports/{id}
- GET /reports/totalVaccinatedByCity?cityName={cityName}&startDate={startDate, format yyyy-MM-dd}&endDate={endDate, format yyyy-MM-dd}
- GET /reports/totalVaccinatedByState?stateName={stateName}&startDate={startDate, format yyyy-MM-dd}&endDate={endDate, format yyyy-MM-dd}
- GET /reports/totalVaccinatedByVaccine?startDate={startDate, format yyyy-MM-dd}&endDate={endDate, format yyyy-MM-dd}
