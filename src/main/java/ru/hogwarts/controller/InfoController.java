package ru.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.service.GetPortService;



@RequestMapping("/getPort")
@RestController
public class InfoController {

    private final GetPortService getPortService;

    public InfoController(GetPortService getPortService) {
        this.getPortService = getPortService;
    }


    @GetMapping
    public ResponseEntity<Integer> getUserPort (){
        return ResponseEntity.ok(getPortService.getPort());
    }

}
