# order-service
 
This micro-service will take care of the Orders. 

This service will talk to the Inventory service to get the available inventory, process the order, and then update the inventory accordingly

Order service will have two endpoints to get the order details.

Endpoints:

GET /order - Returns a list of all the place orders.
POST /order –  Places an order and updates inventory accordingly. 

Tech Stack:
- Language: Java
- Framework: Springboot
- Database: H2 in-memory DB, Liquibase(creating tables and loading initial data)
- Build Tool: Maven
- Tool for Inter-service communication: Web Client 

### Prerequisites
- Java 17
- Maven 3.8+
- IntellIJ

## Run Locally

### Steps | Project setup instruction

- You need to import this repository(```bash 
git clone https://github.com/surendra-uikey_Koerber/order-service.git cd order-service```) and open it in the IntellIJ
- We are using H2 DB, so no need to set up the local
- Need to install the Maven dependency(```bash mvn clean-install```)
- Run the main function of KrbrOrderApplication(make sure to run the inventory service as well before processing the order)(```bash mvn spring-boot:run```).
- Your service will be available at [http://localhost:8082](http://localhost:8082)
- Your H2 DB console will be at [http://localhost:8082/h2-console](http://localhost:8082/h2-console)


