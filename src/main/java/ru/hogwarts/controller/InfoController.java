package ru.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.service.GetPort;



@RequestMapping("/getPort")
@RestController
public class InfoController {

    private final GetPort getPort;

    public InfoController(GetPort getPort) {
        this.getPort = getPort;
    }


    @GetMapping
    public ResponseEntity<Integer> getUserPort (){
        return ResponseEntity.ok(getPort.getPort());
    }

}
