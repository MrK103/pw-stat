package by.mrk.pwstat.service.impl;

import by.mrk.pwstat.dto.*;
import by.mrk.pwstat.entity.*;
import by.mrk.pwstat.entity.enums.PointEnum;
import by.mrk.pwstat.entity.id.PointId;
import by.mrk.pwstat.repository.*;
import by.mrk.pwstat.service.StaticService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class StaticServiceImpl implements StaticService {
    private final UserRepository userRepository;
    private final ClanRepository clanRepository;
    private final PointRepository pointRepository;
    private final TopRepository topRepository;
    private final DonateRepository donateRepository;


    @Override
    public StatisticDTO getStatistic() {
        var acc = userRepository.getAllCount();
        var clans = clanRepository.getAllCount();
        var online = pointRepository.online(PointEnum.ONLINE.getId());
        var genderList = topRepository.getGenderList();
        var female = genderList.stream().filter(p -> p == 1).count();
        var male = genderList.stream().filter(p -> p == 0).count();

        return new StatisticDTO(acc, clans, online, female, male);
    }

    @Override
    public List<ClanDTO> getClanStat() {
        var clans = clanRepository.getTopTenClans();

        return clans.stream().map(clan -> new ClanDTO(clan.getName()
                , clan.getMasterName()
                , clan.getMembers()
                , clan.getTerr2()
                , clan.getTerr2()
                , clan.getTerr3()
                , clan.getLevel())).collect(Collectors.toList());
    }

    @Override
    public List<TopDTO> getTop() {
//        var start = Instant.now();

        var topUser = topRepository.getAll().stream().limit(20).collect(Collectors.toList());
        var pointIds = topUser.stream().map(top -> new PointId(top.getUserid(), 1)).collect(Collectors.toList());
        var points = pointRepository.findAllById(pointIds);
        var userOnline = points.stream().parallel().collect(Collectors.toMap(
                key -> key.getPointId().getUid(),
                point -> Optional.ofNullable(point.getZoneId()).orElse(0)));

        Map<Top, Integer> maps = new LinkedHashMap<>();
        for (int i = 0; i < 20; i++) {
            maps.put(topUser.get(i), userOnline.get(topUser.get(i).getUserid()));
        }
//        var finish = Instant.now();
//        var elapsed = Duration.between(start, finish).toMillis();
//        System.err.println("Прошло времени, мс: " + elapsed);
        return maps.entrySet().stream().map(top ->
            new TopDTO(top.getKey().getRolename(),
                    top.getKey().getRolelevel(),
                    top.getKey().getFactionid().getName(),
                    top.getValue(),
                    top.getKey().getPk_count())
        ).collect(Collectors.toList());
    }

    @Override
    public List<PCDTO> getPCStat() {

        var pcList = topRepository.getAll();
        return pcList.stream().limit(20).map(pc -> new PCDTO(
                pc.getRolename(),
                "Хз где лежат",
                pc.getRolelevel(),
                pc.getPk_count(),
                makeReadableTime(Long.valueOf(pc.getPinknametime())),
                makeReadableTime(pc.getTimeused())))
                .collect(Collectors.toList());
    }

    @Override
    public List<DonateDTO> getDonateStat() {

        var allDonateFromBD = donateRepository.getAllDonat();
        allDonateFromBD = allDonateFromBD.stream().filter(donate -> donate.getMoney() > 0).collect(Collectors.toList());
        Map<User, Integer> distinctDonate = new HashMap<>();
        for (Donate donate : allDonateFromBD) {
            Integer money = distinctDonate.getOrDefault(donate.getUserId(), 0);
            money = money + donate.getMoney();
            distinctDonate.put(donate.getUserId(), money);
        }
        return distinctDonate.entrySet().stream()
                .sorted(Map.Entry.<User, Integer>comparingByValue().reversed())
                .limit(20)
                .map(p -> new DonateDTO(p.getKey().getName(), p.getValue()))
                .collect(Collectors.toList());

    }

    private String makeReadableTime(Long sec) {
        return String.format("%d:%02d:%02d", sec / 3600, sec % 3600 / 60, sec % 60);
    }

//    @PostConstruct
//    void test() {
//        getDonateStat();
//    }

}
