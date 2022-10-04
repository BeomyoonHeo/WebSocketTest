package site.metacoding.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import site.metacoding.websocket.websocket.Greeting;
import site.metacoding.websocket.websocket.HelloMessage;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(500); // simulated delay
        // htmlEscape 메서드를 사용하여 xss 예방 escape sequence가 코드 형태로 들어감
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    // @MessageMapping("/bye")
    // @sendTo("")

}