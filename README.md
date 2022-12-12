# Bill-Pay-Application

Requirement overview and high level features 

Registration : Provide a feature to “register” customer for paying bills. As part of registration capture email id only.  Successful registration should create a “stored value account’ (wallet) associated with the registered customer.  Option for customer to move funds to the wallet as part of registration.

Pay Biller : Pay your utility bills

a) Fetch billers from system, assume a list of billers and corresponding bill data is already stored in the application.

b) Select a biller, fetch the bill and pay that using the wallet.

c) Move funds from customer wallet to biller account.

Make suitable assumptions if required. Document the same and share.

# Technology Used

Application written in Java-8 (or greater) and Spring Boot

All the web-service APIs are following Restful API architecture

In-memory data-based used to store all the data

Code coverage report getting generate.

Maven based project structure

Logging implementation.

Swagger Implementn

# Tech Stack 

Java 8

Maven 3.2

Spring boot 3

Log4j2

H2

Swagger maven plugin

Jacoco maven plugin

Junit and mockito for unit testing

# Following Requirements are implemented

Given customer wants to register for bill payment, When customer provides valid email id, Then wallet is created and registered for the customer

Given customer wants to register for bill payment, When customer provide invalid email id, Then appropriate error is given

Given customer wants to register for bill payment, When customer provide email id already present in the system,  Then appropriate error is given

Given customer has registered for bill payment, When customer wants to transfer funds to wallet, Then they should have option to add funds to wallet

Given customer wants to pay bill, When customer selects the biller, Then they should get  unpaid bill for the month

Given customer has selected a bill, When customer selects pay bill option, Then bill should be paid and amount deducted from the wallet and credited to biller account
