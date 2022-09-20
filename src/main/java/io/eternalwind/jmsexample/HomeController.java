package io.eternalwind.jmsexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private Producer producer;

    @GetMapping("/sendMessage")
    public void sendMessage(@RequestParam String payload) {
        producer.sendMessage(payload);
    }
}
