# Spring Boot 2 - Java Messaging

* benötigt eine lokale RabbitMQ-Instanz
    * docker run -d --rm -p 5672:5672 -p 15672:15672 --name='rabbitmq' rabbitmq:management
* JsonConverter und Topics über application.properties konfiguriert
* offene Frage: wie mehrere Channels bedienen?
    * https://docs.spring.io/spring-cloud-stream/docs/1.0.0.M3/reference/html/spring-cloud-stream-overview.html
    * (s. 1.1.1 Multiple Input or Output Channels)