package com.divyam.rest.webservices.restfulwebservices.controllers;

import com.divyam.rest.webservices.restfulwebservices.models.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    MessageSource messageSource;


    //@RequestMapping(method = RequestMethod.GET , path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello World, Your name is "+name);
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name = "Accept-Language",required = false)Locale locale
            ){
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }


    @GetMapping(path = "/hello-world-internationalized2")
    public String helloWorldInternationalized2(){
        return messageSource.getMessage("good.morning.message",null,"Default Message", LocaleContextHolder.getLocale());
    }

}
