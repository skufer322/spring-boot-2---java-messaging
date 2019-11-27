# Spring Boot 2 - Java Messaging

* docker-compose up im Verzeichnis von docker-compose.yml aufrufen.
* RabbitMQ console: http://localhost:15672/ (user: guest, password: guest)
* AmqpAdmin zur Konfiguration der Queues und anderem
* AmqpTemplate = Interface, RabbitTemplate die Implementierung davon
* relevante Beans (durch AMQPStarter berücksichtigt):
    * Queue
    * MessageConverter (Default: Java-Serialisierung genutzt -> schwierig wg. Cross-Plattform-Kompatibilität => kann aber angepasst werden, z.B. Jackson2JsonMessageConverter)
    * RabbitListenerConfigurer
* Nachrichten nicht direkt über Queue und Topic verschickt, sondern über Exchange -> Routing nicht mehr an eigentlichen Nachrichtentransport gekoppelt (s. a. https://medium.com/faun/different-types-of-rabbitmq-exchanges-9fefd740505d)