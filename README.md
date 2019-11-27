# Spring Boot 2 - Java Messaging

* docker run -p 61616:61616 -p 8161:8161 --name='activemq' -d --rm -e 'ACTIVEMQ_CONFIG_MINMEMORY=512' -e 'ACTIVEMQ_CONFIG_MAXMEMORY=2048' -P webcenter/activemq:latest
* The account admin is "admin" and password is "admin". All settings is the default ActiveMQ's settings.
* Achtung: Beim Laufenlassen aufpassen, dass man in die Konsole des richtigen Modules schaut.
