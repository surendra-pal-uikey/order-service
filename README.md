# order-service
 
This micro-service will take care of the Orders. 

This service will talk to the Inventory service to get the available inventory, process the order, and then update the inventory accordingly

Order service will have two endpoints to get the order details.

Endpoints:

GET /order - Returns a list of all the place orders.
POST /order –  Places an order and updates inventory accordingly. 

Requirement:
Java17 JDK, IntellIJ

Tech Stack:
- Language: Java
- Framework: Springboot
- Database: H2 in-memory DB, Liquibase(creating tables and loading initial data)
- Build Tool: Maven
- Tool for Inter-service communication: Web Client 

## Project setup instruction

- You need to import this repository and open it in the IntellIJ
- We are using H2 DB, so no need to set up the local
- Need to install the Maven dependency
- Run the main function of KrbrOrderApplication(make sure to run the inventory service as well before processing the order).
