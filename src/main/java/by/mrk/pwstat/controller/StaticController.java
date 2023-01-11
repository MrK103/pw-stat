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
@RequestMapping("${url.api.static}")
public class StaticController {
    private final StaticService service;

    @GetMapping("${url.api.static.getTop}")
    public ResponseEntity<List<TopDTO>> getTopStatistic() {
        var statistic = service.getTop();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("${url.api.static.getStat}")
    public ResponseEntity<StatisticDTO> getCountAccount() {
        var statistic = service.getStatistic();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("${url.api.static.getClanStat}")
    public ResponseEntity<List<ClanDTO>> getClanStat() {
        var statistic = service.getClanStat();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("${url.api.static.getPCStat}")
    public ResponseEntity<List<PCDTO>> getPCStat() {
        var statistic = service.getPCStat();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
    @GetMapping("${url.api.static.getMembersByName}")
    public ResponseEntity<List<MemberClanDTO>> getPCStat(@PathVariable("clanName") String name) {
        var statistic = service.getMembers(name);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
    @GetMapping("${url.api.static.getDonateTop}")
    public ResponseEntity<List<DonateDTO>> getDonateTop() {
        var statistic = service.getDonateStat();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
}
