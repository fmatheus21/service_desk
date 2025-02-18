package br.com.fmatheus.app.controller.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestResource {

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

}
