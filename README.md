# Microservices Tutorial

### Standardized Ports

| Application                       | Port                  |
| --------------------------------- | --------------------- |
| Limits Service                    | 8080, 8081, ...       |
| Spring Cloud Config Server        | 8888                  |
| Currency Exchange Service         | 8000, 8001, 8002, ..  |
| Currency Conversion Service       | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server      | 8761                  |
| Spring Cloud API Gateway          | 8765                  |
| Zipkin Distributed Tracing Server | 9411                  |

### Standardized URLs

| Application                 | URL                                                          |
| --------------------------- | ------------------------------------------------------------ |
| Limits Service              | [http://localhost:8080/limits](http://localhost:8080/limits) <br />[http://localhost:8080/actuator/refresh](http://localhost:8080/actuator/refresh) (POST) |
| Spring Cloud Config Server  | [http://localhost:8888/limits-service/default](http://localhost:8888/limits-service/default) <br />[http://localhost:8888/limits-service/dev](http://localhost:8888/limits-service/dev) |
| Currency Exchange Service   | [http://localhost:8000/currency-exchange/from/EUR/to/INR](http://localhost:8000/currency-exchange/from/EUR/to/INR) <br />[http://localhost:8000/currency-exchange/from/USD/to/INR](http://localhost:8000/currency-exchange/from/USD/to/INR) |
| Currency Conversion Service | [http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10](http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10) |
| Eureka Naming Server        | [Eureka Console - http://localhost:8761/](http://localhost:8761/) |
| Spring Cloud API Gateway    | [http://localhost:8765/currency-exchange/from/USD/to/INR](http://localhost:8765/currency-exchange/from/USD/to/INR)<br />[http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10](http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10)<br />[http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10](http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10) |
| Zipkin Distributed Tracing  | [http://localhost:9411/zipkin/](http://localhost:9411/zipkin/) |
| Spring Cloud Bus Refresh    | http://localhost:8080/actuator/bus-refresh (POST)            |



### Hosted URLs

| Application                 | URL                                                          |
| --------------------------- | ------------------------------------------------------------ |
| Limits Service              | [http://localhost:8080/limits](http://localhost:8080/limits) <br />[http://localhost:8080/actuator/refresh](http://localhost:8080/actuator/refresh) (POST) |
| Spring Cloud Config Server  | [http://localhost:8888/limits-service/default](http://localhost:8888/limits-service/default) <br />[http://localhost:8888/limits-service/dev](http://localhost:8888/limits-service/dev) |
| Currency Exchange Service   | [http://sg-test.eastus.cloudapp.azure.com:8000/currency-exchange/from/EUR/to/INR](http://sg-test.eastus.cloudapp.azure.com:8000/currency-exchange/from/EUR/to/INR) <br />[http://sg-test.eastus.cloudapp.azure.com:8000/currency-exchange/from/USD/to/INR](http://sg-test.eastus.cloudapp.azure.com:8000/currency-exchange/from/USD/to/INR) |
| Currency Conversion Service | [http://sg-test.eastus.cloudapp.azure.com:8100/currency-conversion/from/USD/to/INR/quantity/10](http://sg-test.eastus.cloudapp.azure.com:8100/currency-conversion/from/USD/to/INR/quantity/10) |
| Eureka Naming Server        | [http://sg-test.eastus.cloudapp.azure.com:8761/](http://sg-test.eastus.cloudapp.azure.com:8761/) |
| Spring Cloud API Gateway    | [http://sg-test.eastus.cloudapp.azure.com:8765/currency-exchange/from/USD/to/INR](http://sg-test.eastus.cloudapp.azure.com:8765/currency-exchange/from/USD/to/INR)<br />[http://sg-test.eastus.cloudapp.azure.com:8765/currency-conversion/from/USD/to/INR/quantity/10](http://sg-test.eastus.cloudapp.azure.com:8765/currency-conversion/from/USD/to/INR/quantity/10)<br />[http://sg-test.eastus.cloudapp.azure.com:8765/currency-conversion-new/from/USD/to/INR/quantity/10](http://sg-test.eastus.cloudapp.azure.com:8765/currency-conversion-new/from/USD/to/INR/quantity/10) |
| Zipkin Distributed Tracing  | [http://sg-test.eastus.cloudapp.azure.com:9411/zipkin/](http://sg-test.eastus.cloudapp.azure.com:9411/zipkin/) |
| Spring Cloud Bus Refresh    | http://localhost:8080/actuator/bus-refresh (POST)            |

