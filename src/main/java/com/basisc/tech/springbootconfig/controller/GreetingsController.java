package com.basisc.tech.springbootconfig.controller;

import com.basisc.tech.springbootconfig.config.DBSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingsController {

    @Value("${my.greetings:default value}")
    private String myGreeting;

    @Value("Some Static Message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${db.connection}}")
    private Map<String,String> dbValues;

    @Autowired
    private DBSettings dbSettings;

    @GetMapping("/greeting")
    public String getGreetings(){
        return myGreeting+" "+staticMessage+" "+listValues+dbValues +
                dbSettings.getConnection()+" "+dbSettings.getHost()+" "+dbSettings.getPort();
    }
}
