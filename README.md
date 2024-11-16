# Microservices Tutorial



### Hosted URLs

| Application                 | URL                                                          | Supervisor Application Name |
| --------------------------- | ------------------------------------------------------------ | --------------------------- |
| Limits Service              | [http://localhost:8080/limits](http://localhost:8080/limits) <br />[http://localhost:8080/actuator/refresh](http://localhost:8080/actuator/refresh) (POST) |                             |
| Spring Cloud Config Server  | [http://localhost:8888/limits-service/default](http://localhost:8888/limits-service/default) <br />[http://localhost:8888/limits-service/dev](http://localhost:8888/limits-service/dev) | config-server               |
| Currency Exchange Service   | [http://swarnadeep.centralindia.cloudapp.azure.com:8000/currency-exchange/from/EUR/to/INR](http://swarnadeep.centralindia.cloudapp.azure.com:8000/currency-exchange/from/EUR/to/INR) <br />[http://swarnadeep.centralindia.cloudapp.azure.com:8000/currency-exchange/from/USD/to/INR](http://swarnadeep.centralindia.cloudapp.azure.com:8000/currency-exchange/from/USD/to/INR) | currency-exchange           |
| Currency Conversion Service | [http://swarnadeep.centralindia.cloudapp.azure.com:8100/currency-conversion/from/USD/to/INR/quantity/10](http://swarnadeep.centralindia.cloudapp.azure.com:8100/currency-conversion/from/USD/to/INR/quantity/10) | currency-conversion         |
| Eureka Naming Server        | [https://swarnadeep.centralindia.cloudapp.azure.com/registry/](https://swarnadeep.centralindia.cloudapp.azure.com/registry/) | naming-server               |
| Spring Cloud API Gateway    | [https://swarnadeep.centralindia.cloudapp.azure.com/api/currency-exchange/from/USD/to/INR](https://swarnadeep.centralindia.cloudapp.azure.com/api/currency-exchange/from/USD/to/INR)<br />[https://swarnadeep.centralindia.cloudapp.azure.com/api/currency-conversion/from/USD/to/INR/quantity/10](https://swarnadeep.centralindia.cloudapp.azure.com/api/currency-conversion/from/USD/to/INR/quantity/10)<br />[https://swarnadeep.centralindia.cloudapp.azure.com/api/currency-conversion-new/from/USD/to/INR/quantity/10](https://swarnadeep.centralindia.cloudapp.azure.com/api/currency-conversion-new/from/USD/to/INR/quantity/10) | api-gateway                 |
| Zipkin Distributed Tracing  | [https://swarnadeep.centralindia.cloudapp.azure.com/zipkin/](https://swarnadeep.centralindia.cloudapp.azure.com/zipkin/) | zipkin                      |



### Devops Hosted URLs

| Service                 | URL                                                          | Username                 | Password     |
| ----------------------- | ------------------------------------------------------------ | ------------------------ | ------------ |
| Jenkins                 | [https://swarnadeep.centralindia.cloudapp.azure.com/](https://swarnadeep.centralindia.cloudapp.azure.com/) | swarnadeep               | swarnadeep   |
| Tomcat                  | [https://swarnadeep.centralindia.cloudapp.azure.com/tomcat/](https://swarnadeep.centralindia.cloudapp.azure.com/tomcat/) | swarnadeep               | swarnadeep   |
| Sonarqube               | [https://swarnadeep.centralindia.cloudapp.azure.com/sonar/](https://swarnadeep.centralindia.cloudapp.azure.com/sonar/) | swarnadeep<br />or admin | Password@123 |
| Supervisor - Monitoring | [https://swarnadeep.centralindia.cloudapp.azure.com/monitor/](https://swarnadeep.centralindia.cloudapp.azure.com/monitor/) | swarnadeep               | swarnadeep   |



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

