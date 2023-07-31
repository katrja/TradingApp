# TradingApp
This is coding task. 

New trading application was writen using:
- java 17
- maven
- spring boot 3.1.2

In project structure find two main packages: `algo` and `trading`.\
The Trading Algo team's code cannot be modified and arranged in algo' package: `SignalHandler` and `Algo` classes.\
My teams' code was placed in `trading` package. `Application` class was provided to extend code in order to fill requirements.

Main requrements:
- provide service with HTTP endpoint to handle signals (1, 2, 3 and default)
- application should be tested with unit tests
- easy to maintain in order to extend application with new signals
- easy to understand and debug

To run this application, run following commands in terminal:
```
$ git clone https://github.com/katrja/TradingApp.git
$ mvn clean install
$ mvn spring-boot:run
```
For just running tests: 
```
$ mvn test
```
For manual testing use Postman: `HTTP POST localhost:8086/signal` with integer value in request body.\
Or by running curl comands in terminal. Examples:
```
curl --request POST --location 'localhost:8086/signal' --header 'Content-Type: application/json' --data '1'
curl --request POST  --location 'localhost:8086/signal' --header 'Content-Type: application/json' --data '2'
curl --request POST --location 'localhost:8086/signal' --header 'Content-Type: application/json' --data '3'
curl --request POST --location 'localhost:8086/signal' --header 'Content-Type: application/json' --data '10'
curl --request POST --location 'localhost:8086/signal' --header 'Content-Type: application/json' --data ''
```






