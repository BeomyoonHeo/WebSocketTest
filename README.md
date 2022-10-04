### 참고하면 좋은자료
```sql
    웹소켓의 개념 - 번역기 돌리면서 참고해도 상당히 잘되어있다.
    https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-websocket
```

### 의존성 추가해주기:
```sql
    implementation 'org.springframework.boot:spring-boot-starter-websocket'
	implementation 'org.webjars:webjars-locator-core'
	implementation 'org.webjars:sockjs-client:1.0.2'
	implementation 'org.webjars:stomp-websocket:2.3.3'
	implementation 'org.webjars:bootstrap:3.3.7'
	implementation 'org.webjars:jquery:3.1.1-1'
```

### Config 파일 생성
```sql
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}
```
### Controller 메서드 위에 어노테이션 추가해주기
```sql
ex)
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
```