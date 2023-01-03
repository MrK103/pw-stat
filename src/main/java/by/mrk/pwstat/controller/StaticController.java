package by.mrk.pwstat.controller;

import by.mrk.pwstat.dto.*;
import by.mrk.pwstat.service.StaticService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/static")
public class StaticController {
    private final StaticService service;

    @GetMapping("/getTop")
    public ResponseEntity<List<TopDTO>> getTopStatistic() {
        var statistic = service.getTop();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("/getStat")
    public ResponseEntity<StatisticDTO> getCountAccount() {
        var statistic = service.getStatistic();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("/getClanStat")
    public ResponseEntity<List<ClanDTO>> getClanStat() {
        var statistic = service.getClanStat();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("/getPCStat")
    public ResponseEntity<List<PCDTO>> getPCStat() {
        var statistic = service.getPCStat();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
    @GetMapping("/getMembers/{id}")
    public ResponseEntity<List<MemberClanDTO>> getPCStat(@PathVariable("id") String id) {
        System.out.println(id);
        var statistic = service.getMembers(id);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
    @GetMapping("/getDonateTop")
    public ResponseEntity<List<DonateDTO>> getDonateTop() {
        var statistic = service.getDonateStat();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
}
