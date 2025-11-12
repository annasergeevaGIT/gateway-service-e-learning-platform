package at.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import reactor.core.publisher.Hooks;
/*
 В приложениях, использующих реактивный стек Spring WebFlux, каким является наш Gateway Server, управление контекстом выполнения запросов осуществляется немного иначе, чем в традиционных блокирующих приложениях. Поскольку WebFlux использует реактивное программирование для асинхронной обработки запросов, сохранение и передача контекста выполнения (например, контекста трассировки) между различными стадиями выполнения запроса становится более сложной задачей. В этом случае для автоматической передачи контекста выполнения (включая контекст трассировки и другие пользовательские контексты) через потоки выполнения реактивных операций используется метод Hooks.enableAutomaticContextPropagation() проекта Project Reactor, который является составной частью Spring WebFlux. Это позволяет разработчикам использовать распределённую трассировку, не беспокоясь о явном сохранении и восстановлении контекста при каждом переключении между потоками исполнения.
 Hooks.enableAutomaticContextPropagation() следует вызывать при старте приложения, например, в методе main до вызова SpringApplication.run(), чтобы обеспечить автоматическую передачу контекста на протяжении всего жизненного цикла приложения:
 https://spring.io/blog/2023/03/30/context-propagation-with-project-reactor-3-unified-bridging-between-reactive
 */
@SpringBootApplication(exclude = ReactiveUserDetailsServiceAutoConfiguration.class)
public class GatewayServiceApplication {

    public static void main(String[] args) {
        Hooks.enableAutomaticContextPropagation();
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
