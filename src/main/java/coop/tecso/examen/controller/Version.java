package coop.tecso.examen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class Version {

    @GetMapping("/version")
    public String getVersion() {
        final String s = "Version 1.0.0";
        return s;
    }
}
