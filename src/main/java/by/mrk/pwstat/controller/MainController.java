package by.mrk.pwstat.controller;

import by.mrk.pwstat.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
@AllArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping("/getOnline")
    public ResponseEntity<Integer> getOnline(){
        return  new ResponseEntity<>(mainService.getOnline(), HttpStatus.OK);
    }

}
