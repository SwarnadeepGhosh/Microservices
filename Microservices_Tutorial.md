# Microservices Tutorial

**Tech Stack :** 

<img src="https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png" alt="Spring Boot (@springboot) / X" style="zoom: 40%;" /> <img src="https://static.javatpoint.com/tutorial/spring-cloud/images/spring-cloud.png" alt="Spring Cloud Tutorial - Javatpoint" style="zoom: 67%;" /> <img src="https://miro.medium.com/v2/resize:fit:486/1*mwUghPGDjdVNOe8y7Pkrpg.png" alt="Implementing Service Discovery Using Netflix Eureka | by Seonggil Jeong |  Medium" style="zoom: 50%;" /> <img src="https://camo.githubusercontent.com/c9c03fc8fd1261971c38aafd0b95f59eee0af2b435277586949579dfe8b5198d/68747470733a2f2f692e696d6775722e636f6d2f6d52536f7345702e706e67" alt="GitHub - Netflix/zuul: Zuul is a gateway service that provides dynamic  routing, monitoring, resiliency, security, and more." style="zoom: 15%;" /> <img src="https://avatars.githubusercontent.com/u/11860887?v=4" alt="GitHub - openzipkin/zipkin: Zipkin is a distributed tracing system" style="zoom:35%;" /> <img src="https://miro.medium.com/v2/resize:fit:720/1*FNJ6C1uNvCAhkJR3i7pvoQ.jpeg" alt="Hystrix + Spring Boot Implementation | by Vinesh | The Jabberjays | Medium" style="zoom: 40%;" /> <img src="https://avatars.githubusercontent.com/u/20077752?s=64&v=4" alt="OpenFeign · GitHub" style="zoom:30%;" /> <img src="https://howtodoinjava.com/wp-content/uploads/2019/12/spring-hateoas.png" alt="Spring Boot HATEOAS Links Example" style="zoom: 50%;" /> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hPnQgYIb2fp0KenorFRSOXY268hay_nISrnJtv-6ng&s" alt="Docker full logo transparent PNG - StickPNG" style="zoom: 80%;" /> <img src="https://sue.eu/wp-content/uploads/sites/6/2022/06/kubernetes-logo-920x920-sue-v0.png" alt="Kubernetes | SUE Cloud & IT Professionals" style="zoom: 20%;" />

[Udemy Course Link](https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/?couponCode=UPGRADE02223)

<img src="images/roadmap1.png" alt="" style="zoom: 67%;" />

<img src="images/roadmap2.png" alt="" style="zoom: 67%;" />



# Web Service

> **Definition : ** Software system designed to support interoperable machine-to-machine interaction over a network.

- **3 Keys of Web Service** 

  - Designed for machine-to-machine (or application-to-application) interaction 

  - Should be interoperable - Not platform dependent. As it shouldn't matter which language our web service made i.e. Java, PHP, .Net etc.

  - Should allow communication over a network

- How does data exchange between applications take place?

  - By Request and Response

- How can we make web services platform independent?

  - There are 2 popular formats widely accepted by most of frontend and backend languages - **XML** and **JSON**



**Transport** - It defines how a service is called. 

- **HTTP** - It is the service exposed over the internet.

- **MQ** - Message Queue (e.g. WebSphere MQ) is the service exposed over a queue. *Here Service requestor place a message in queue, Service Provider listening on the queue and as soon as there is a request on the queue, it would take the request, do the processing of it, create the response and put it back into the queue.*

  <img src="images/transport.png" alt="transport" style="zoom: 80%;" />



**Web Service Groups** : There are 2 types of web services - 

1. *SOAP (Simple Object Access Protocol)*
2. *REST (Representational State Transfer)*



1. ***SOAP (Simple Object Access Protocol)*** 

   - Format - SOAP XML Request - SOAP XML Response 
   - Transport :  MQ or HTTP , There is no restriction.
   - Service Definition : WSDL (Web Services Description Language)

   <img src="images/soap.png" alt="transport" style="zoom: 50%;" />

   SOAP Example Request / Response : 

   ```xml
   <SOAP-ENV:Envelope xmlns:SOAPENV="http://schemas.xmlsoap.org/soap/envelope/">
       <SOAP-ENV:Header/>
       <SOAP-ENV:Body>
           <ns2:getCourseDetailsResponse xmlns:ns2="http://in28minutes.com/courses">
               <ns2:course>
                   <ns2:id>Course1</ns2:id>
                   <ns2:name>Spring</ns2:name>
                   <ns2:description>10 Steps</ns2:description>
               </ns2:course>
           </ns2:getCourseDetailsResponse>
       </SOAP-ENV:Body>
   </SOAP-ENV:Envelope>
   ```

2. ***REST (Representational State Transfer)*** 

   - Data Exchange Format - No Restriction. JSON is popular 
   - Transport : Only HTTP 
   - Service Definition : No Standard. WADL/Swagger/…

- **HOW to build a great REST API?**
  - Identifying Resources (/users, /users/{id}/posts)
  - Identifying Actions (GET, POST, PUT, DELETE, ...)
  - Defining Request and Response structures
  - Using appropriate Response Status (200, 404, 500, ..)
  - Understanding REST API Best Practices 
    - Thinking from the perspective of your consumer
    - **Validation, Internationalization - i18n, Exception Handling, HATEOAS, Versioning,**
      **Documentation, Content Negotiation** and a lot more!



---

# Building REST API

**What's Happening in the Background?**

Let's explore some Spring Boot Magic: Enable Debug Logging. WARNING: Log change frequently!

1. How are our requests handled?

   - DispatcherServlet - Front Controller Pattern
     - Mapping servlets: dispatcherServlet urls=[/]
     - Auto Configuration (DispatcherServletAutoConfiguration)

2. How does HelloWorldBean object get converted to JSON?

   - @ResponseBody + JacksonHttpMessageConverters
   - Auto Configuration (JacksonHttpMessageConvertersConfiguration)

3. Who is configuring error mapping?

   - Auto Configuration (ErrorMvcAutoConfiguration)

4. How are all jars available(Spring, Spring MVC, Jackson, Tomcat)?

   - Starter Projects - Spring Boot Starter Web (spring-webmvc, spring-web, springboot-starter-tomcat, spring-boot-starter-json)



### Advanced Rest API Features

- Documentation - Swagger
- Content Negotiation (What if consumer expect a XML response back ? )
- Internationalization - i18n  (How to customize API response according to language of user throughout the world ? )
- Versioning
- HATEOAS
- Static Filtering
- Dynamic Filtering
- Monitoring



#### **Documentation**

We need to use springdoc-openapi version 2+ for Spring Boot 3 and JDK17.

```xml
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	<version>2.0.0</version>
</dependency>
```



#### **Content Negotiation**

- Same Resource - Same URI 

- HOWEVER Different Representations are possible 
  - Example: Different Content Type - XML or JSON (Accept header (MIME types - application/xml, application/json, ...)
  - Example: Different Language - English or Dutch or french (Accept-Language header (en, nl, fr, ..))

**Steps of Content Negotiation**

- STEP 1: add this in ***pom.xml***

  ```xml
  <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml -->
  <dependency>
      <groupId>com.fasterxml.jackson.dataformat</groupId>
      <artifactId>jackson-dataformat-xml</artifactId>
  </dependency>
  ```

- STEP 2: Add `Accept` header in postman for `application/xml`. If we don't provide this header, default is `application/json`

  ```bash
  curl --location 'http://localhost:8080/users' \
  --header 'Accept: application/xml'
  ```



#### **Internationalization** 

Typically HTTP Request Header - `Accept-Language` is used. `Accept-Language` - indicates natural language and locale
that the consumer prefers

- Example: en - English (Good Morning)
- Example: nl - Dutch (Goedemorgen)
- Example: fr - French (Bonjour)
- Example: de - Deutsch (Guten Morgen)



#### **Versioning**

1. **URI Versioning - Twitter**
   - http://localhost:8080/v1/person
   - http://localhost:8080/v2/person
2. **Request Parameter versioning - Amazon**
   - http://localhost:8080/person?version=1
   - http://localhost:8080/person?version=2
3. **(Custom) headers versioning - Microsoft**
  - SAME-URL headers=[X-API-VERSION=1]
  - SAME-URL headers=[X-API-VERSION=2]
4. **Media type versioning (a.k.a “content negotiation” or “accept header”) - GitHub**
  - SAME-URL produces=application/vnd.company.app-v1+json
  - SAME-URL produces=application/vnd.company.app-v2+json

- Factors to consider
	- URI Pollution
	- Misuse of HTTP Headers
	- Caching
	- Can we execute the request on the browser?
	- API Documentation
	- Summary: No Perfect Solution
- Recommendations
	- Think about versioning even before you need it!
	- One Enterprise - One Versioning Approach



#### **HATEOAS (Hypermedia as the Engine of Application State)**

- Websites allow you to: See Data AND Perform Actions (using links)

- How about enhancing your REST API to tell consumers how to perform subsequent actions?
	- HATEOAS (In below image, `_links` section coming from `hateoas`)
	
	  <img src="images/hateoas.png" alt="transport" style="zoom: 50%;" />
	
- Implementation Options:
	- 1: Custom Format and Implementation
	- Difficult to maintain
	- 2: Use Standard Implementation
		- HAL (JSON Hypertext Application Language): Simple format that gives a consistent and easy way to hyperlink between resources in your API
		- Spring HATEOAS: Generate HAL responses with hyperlinks to resources

- Steps : 

  - STEP 1: ***pom.xml***

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-hateoas</artifactId>
    </dependency>
    ```

  - STEP 2: [***UserResource.java***](https://github.com/in28minutes/spring-microservices/blob/master/02.restful-web-services/backup07-improving-documentation-with-swagger.md#srcmainjavacomin28minutesrestwebservicesrestfulwebservicesuseruserresourcejava-1) : Here we have added `all-users` link section of response which is of generic type `hateoas.Resource`

    ```java
    import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
    import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
    import org.springframework.hateoas.Resource;
    import org.springframework.hateoas.mvc.ControllerLinkBuilder;
    ...
        @RestController
        public class UserResource {
    
            @GetMapping("/users/{id}")
            public Resource<User> retrieveUser(@PathVariable int id) {
                User user = service.findOne(id);
    
                if(user==null)throw new UserNotFoundException("id-"+ id);
    
                //"all-users", SERVER_PATH + "/users"
                //retrieveAllUsers
                Resource<User> resource = new Resource<User>(user);
    
                ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
                resource.add(linkTo.withRel("all-users"));
    
                //HATEOAS
                return resource;
            }
    
            @PostMapping("/users")
            public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
                User savedUser = service.save(user);
                // CREATED
                // /user/{id}     savedUser.getId()
    
                URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedUser.getId()).toUri();
                return ResponseEntity.created(location).build();
            }
        }
    ```



#### **HAL Explorer**

- An API explorer for RESTful Hypermedia APIs using HAL
- Enable your non-technical teams to play with APIs
- Spring Boot HAL Explorer
	- Auto-configures HAL Explorer for Spring Boot Projects
	- Import in pom.xml using `spring-data-rest-hal-explorer`

<img src="images/halExplorer.png" alt="transport" style="zoom: 43%;" />





# Microservices(V1)

This is a older version compatible with Spring boot < 2.3.0, For newer Versions, Please refer []

**Problems and Solutions for each problem :** 

- CENTRALIZED CONFIGURATION MANAGEMENT -  ***Spring Cloud Config Server***
- LOCATION TRANSPARANCY - Naming Server (***Eureka***)
- LOAD BALANCING - ***Ribbon*** (Client Side)
- VISIBILITY AND MONITORING - 
  - ***Zipkin Distributed Tracing*** 
  - ***Netflix API Gateway***
- FAULT TOLERANCE - ***Hystrix***

### Standardized Ports

| Application                       | Port                  |
| --------------------------------- | --------------------- |
| Limits Service                    | 8080, 8081, ...       |
| Spring Cloud Config Server        | 8888                  |
| Currency Exchange Service         | 8000, 8001, 8002, ..  |
| Currency Conversion Service       | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server      | 8761                  |
| Netflix Zuul API Gateway Server   | 8765                  |
| Zipkin Distributed Tracing Server | 9411                  |

### Standardized URLs

| Application                                  | URL                                                          |
| -------------------------------------------- | ------------------------------------------------------------ |
| Limits Service                               | http://localhost:8080/limits <br />http://localhost:8080/actuator/refresh (POST) |
| Spring Cloud Config Server                   | http://localhost:8888/limits-service/default <br />http://localhost:8888/limits-service/dev |
| Currency Converter Service - Direct Call     | http://localhost:8100/currency-converter/from/USD/to/INR/quantity/10 |
| Currency Converter Service - Feign           | http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000 |
| Currency Exchange Service                    | http://localhost:8000/currency-exchange/from/EUR/to/INR http://localhost:8001/currency-exchange/from/USD/to/INR |
| Eureka                                       | http://localhost:8761/                                       |
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10 |
| Zipkin                                       | http://localhost:9411/zipkin/                                |
| Spring Cloud Bus Refresh                     | http://localhost:8080/actuator/bus-refresh (POST)            |



---

# **Microservices(V2)**

**Problems and Solutions for each problem :** 

- CENTRALIZED CONFIGURATION MANAGEMENT -  ***Spring Cloud Config Server***
- LOCATION TRANSPARANCY - Naming Server (***Eureka***)
- LOAD BALANCING - ***Spring Cloud Load-balancer*** instead of *Ribbon* (Client Side)
- VISIBILITY AND MONITORING - 
  - ***Zipkin Distributed Tracing*** 
  -  ***Spring Cloud Gateway*** instead of *Netflix Zuul API Gateway*
- FAULT TOLERANCE - ***Resilience4j*** instead of *Hystrix*
- **OpenTelemetry** : One Standard - Logs, Traces & Metrics 
- **Micrometer** (Replaces Spring Cloud Sleuth)



<img src="images/dia1.png" alt="transport" style="zoom: 43%;" />

## Currency Config Repository

- [Git Repo Link](https://github.com/SwarnadeepGhosh/Microservices)

- File name pattern : **`<microservice-name>-<profile>.properties`**

- Spring Cloud Config Repository is having highest priority. That means, if someone write same property within project and also he is fetching that property value from Git repo, then the property of git repo will overwrite the property value present in microservice property file.

- **STEP 1:** Create property files

  - ***limits-service.properties***

    ```properties
    limits.service.minimum=4
    limits.service.maximum=996
    ```

  - ***limits-service-dev.properties***

    ```properties
    limits.service.minimum=5
    limits.service.maximum=995
    ```

  - ***limits-service-qa.properties***

    ```properties
    limits.service.minimum=6
    limits.service.maximum=994
    ```

- **STEP 2:** Initialize a git repository and push changes into master branch 

  - ```sh
    $ git init
    $ git add .
    $ git commit -m "added files"
    ```

  - If its a remote branch , then we need to create api key from : Github > Settings > Developer Settings 



---

## Config Server Microservice

- [Starting Project - Config Server Microservice (Spring.io)](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=21&groupId=com.swarna.microservices&artifactId=config-server&name=config-server&description=Centralized%20config%20server%20microservice&packageName=com.swarna.microservices.config-server&dependencies=devtools,cloud-config-server)

- [Git Repo Link](https://github.com/SwarnadeepGhosh/Microservices)

- Connecting with Git Repo : 

  - **STEP 1** : Import downloaded Zip from start.spring.io and add `@EnableConfigServer` annotation in main class : ***ConfigServerApplication.java***

    ```java
    import org.springframework.cloud.config.server.EnableConfigServer;
    
    @EnableConfigServer
    @SpringBootApplication
    public class ConfigServerApplication {
        public static void main(String[] args) { SpringApplication.run(ConfigServerApplication.class, args); }
    }
    ```

  - **STEP 2**: ***application.properties***

    ```properties
    spring.application.name=config-server
    server.port=8888
    
    #Sample URI for local git repo in Windows local system
    #spring.cloud.config.server.git.uri=file:///D:/Microservices/config-repo
    
    #Sample URI for Git repo from Github
    spring.cloud.config.server.git.uri=https://github.com/SwarnadeepGhosh/currency-config-repo
    spring.cloud.config.server.git.default-label=master
    spring.cloud.config.server.git.username=SwarnadeepGhosh
    spring.cloud.config.server.git.password=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
    #spring.cloud.config.server.git.ignore-local-ssh-settings=true
    #spring.cloud.config.server.git.private-key=<private-key>
    ```

  - **STEP 3**: Fetch Config using GET api calls : 

    - Default: [http://localhost:8888/limits-service/default](http://localhost:8888/limits-service/default)
    - Dev: [http://localhost:8888/limits-service/dev](http://localhost:8888/limits-service/dev)
    - Qa: [http://localhost:8888/limits-service/qa](http://localhost:8888/limits-service/qa)



---


## Limits Microservice

- [Starting Project - Limits Microservice (Spring.io)](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=21&groupId=com.swarna.microservices&artifactId=limit-service&name=limit-service&description=Limit%20Microservice&packageName=com.swarna.microservices.limit-service&dependencies=web,devtools,actuator,lombok,cloud-config-client)

- [Git Repo Link](https://github.com/SwarnadeepGhosh/Microservices)

- Connecting with Config server and eventually fetching config from config repo : 

  - **STEP 1** : Import downloaded Zip from start.spring.io and add below in ***application.properties***

    ```properties
    spring.application.name=limits-service
    spring.config.import=optional:configserver:http://localhost:8888
    
    spring.profiles.active=dev
    spring.cloud.profiles.active=dev
    ```

  - **STEP 2**: ***PropertyConfig.java*** - This will fetch data from property files, so that we can use it in application.

    ```java
    @ConfigurationProperties("limits.service")
    @Component
    @Data
    public class PropertyConfig {
        private int minimum;
        private int maximum;
    }
    ```

  - **STEP 3**: ***LimitController.java*** - This will fetch data from property files, so that we can use it in application.

    ```java
    @RestController
    public class LimitController {
    
        @Autowired
        PropertyConfig propertyConfig;
    
        @GetMapping("/limits")
        public Limits retrieveLimits(){
            return new Limits(propertyConfig.getMinimum(), propertyConfig.getMaximum());
        }
    }
    ```

  - **STEP 3**: Fetch response using GET api calls : [http://localhost:8080/limits](http://localhost:8080/limits) . Here property coming from git repo to config server and to limit service.



---

## Currency Exchange

- URLs

  - [Starting Project - Currency Exchange Microservice (Spring.io)](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=21&groupId=com.swarna.microservices&artifactId=currency-exchange&name=currency-exchange&description=Currency%20Exchange%20Microservice&packageName=com.swarna.microservices.currency-exchange&dependencies=web,devtools,actuator,lombok,cloud-config-client)
  - [Git Repo Link](https://github.com/SwarnadeepGhosh/Microservices)
  - H2 Console : [http://localhost:8000/h2-console](http://localhost:8000/h2-console)
  - [http://localhost:8000/currency-exchange/from/USD/to/INR](http://localhost:8000/currency-exchange/from/USD/to/INR)

- **Service Working example :** 

  - If you ask it the value of 1 USD in INR, or 1 Australian Dollar in INR, the Currency Exchange Service answers

    - 1 USD is 60 INR
    - 1 Australian Dollars is 50 INR.

    GET : http://localhost:8000/currency-exchange/from/EUR/to/INR

    ```json
    {
      "id": 10002,
      "from": "EUR",
      "to": "INR",
      "conversionMultiple": 75.00,
      "exchangeEnvironmentInfo": "37f1ad927c6e v1 27c6e"
    }
    ```

- ***application.properties***

  ```properties
  spring.application.name=currency-exchange
  server.port=8000
  
  spring.jpa.show-sql=true
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.jpa.defer-datasource-initialization=true
  spring.h2.console.enabled=true
  
  spring.config.import=optional:configserver:
  
  spring.devtools.restart.poll-interval=2s
  spring.devtools.restart.quiet-period=1s
  spring.devtools.livereload.port=35731
  ```

  

---

## Currency Conversion

- URLs

  - [Starting Project - Currency Conversion Microservice (Spring.io)](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=21&groupId=com.swarna.microservices&artifactId=currency-conversion&name=currency-conversion&description=Currency%20Conversion%20Microservice&packageName=com.swarna.microservices.currency-conversion&dependencies=web,devtools,actuator,lombok,cloud-config-client)
  - [Git Repo Link](https://github.com/SwarnadeepGhosh/Microservices)
  - [http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10](http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10)
  
- **Service Working example :** 

  - Currency Conversion Service is used to convert a bucket of currencies. If you want to find the value of 10 USD, Currency Conversion Service returns 600.

    - **STEP 1** : Currency Conversion Service calls the Currency Exchange Service for the value of 1 USD. It gets a response back saying 60.
    - **STEP 2** : The Currency Conversion Service then multiplies 10 by 60, and returns 600 back.

    GET : http://localhost:8100/currency-conversion/from/EUR/to/INR/quantity/10

    ```json
    {
      "id": 10002,
      "from": "EUR",
      "to": "INR",
      "conversionMultiple": 75.00,
      "quantity": 10,
      "totalCalculatedAmount": 750.00,
      "exchangeEnvironmentInfo": "37f1ad927c6e v1 27c6e",
      "conversionEnvironmentInfo": "fb6316b5713d v1 5713d"
    }
    ```


### Feign Client Integration

- Most easiest Rest Template call

- ***application.properties***

  ```properties
  spring.application.name=currency-conversion
  server.port=8100
  
  spring.config.import=optional:configserver:
  currency-exchange.url=http://localhost:8000
  
  spring.devtools.restart.poll-interval=2s
  spring.devtools.restart.quiet-period=1s
  spring.devtools.livereload.port=35730
  ```

- Main Interface to make Feign Client Calls : ***CurrencyExchangeProxy.java***

  ```java
  import org.springframework.cloud.openfeign.FeignClient;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.PathVariable;
  
  @FeignClient(name = "currency-exchange", url = "${currency-exchange.url}")
  public interface CurrencyExchangeProxy {
  
      @GetMapping("/currency-exchange/from/{from}/to/{to}")
      public CurrencyConversion retrieveExchangeValue(
              @PathVariable String from,
              @PathVariable String to);
  }
  ```

- ***CurrencyConversionController.java***

  ```java
  @RestController
  public class CurrencyConversionController {
  
      @Autowired
      private CurrencyExchangeProxy proxy;
  
      @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
      public CurrencyConversion calculateCurrencyConversionFeign(
          @PathVariable String from,
          @PathVariable String to,
          @PathVariable BigDecimal quantity
      ) {
  
          CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
  
          return CurrencyConversion.builder()
              .id(currencyConversion.getId())
              .from(currencyConversion.getFrom())
              .to(currencyConversion.getTo())
              .quantity(quantity)
              .conversionMultiple(currencyConversion.getConversionMultiple())
              .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
              .environment(currencyConversion.getEnvironment() + " feign")
              .build();
      }
  }
  ```



---

## Eureka Naming Server 

<img src="images/namingServer.png" alt="transport" style="zoom: 67%;" />

- Also called **Service Registry**
- 
