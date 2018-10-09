package com.example.jmssender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{symbol}")
    public String getStock(@PathVariable String symbol) {
        jmsTemplate.convertAndSend("StockQueue",symbol);
        return "You'll receive the stock value soon\n";
    }
}
