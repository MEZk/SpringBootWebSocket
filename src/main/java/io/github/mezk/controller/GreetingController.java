package io.github.mezk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.mezk.dto.Greeting;
import io.github.mezk.dto.HelloMessage;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    public void greeting(HelloMessage message) throws Exception {
        System.out.println(message.getName());
    }

    @RequestMapping(value="/greetings1", method= RequestMethod.GET)
    public void greet1(String greeting) {
        this.template.convertAndSend("/topic/greetings", new Greeting("Hello1!"));
    }
}