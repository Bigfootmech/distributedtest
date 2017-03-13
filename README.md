# distributedtest

Build:
mvn clean install

Run Consumer:
mvn spring-boot:run

Wait until tomcat starts up (default Tomcat, on localhost, port 8080, if it's different, you need to change config file of producer)

Run Producer:
mvn exec:java

Needs to have mongo db running (can change location in config file in dao)

Nees to have an authorized user for mongo
use admin
db.createUser({user: "admin", pwd: "blue", roles: [ "root" ] } )
