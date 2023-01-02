package by.mrk.pwstat.service.impl;

import by.mrk.pwstat.dto.ClanDTO;
import by.mrk.pwstat.dto.StatisticDTO;
import by.mrk.pwstat.dto.TopDTO;
import by.mrk.pwstat.entity.enums.PointEnum;
import by.mrk.pwstat.entity.id.PointId;
import by.mrk.pwstat.repository.ClanRepository;
import by.mrk.pwstat.repository.PointRepository;
import by.mrk.pwstat.repository.TopRepository;
import by.mrk.pwstat.repository.UserRepository;
import by.mrk.pwstat.service.StaticService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StaticServiceImpl implements StaticService {
    private final UserRepository userRepository;
    private final ClanRepository clanRepository;
    private final PointRepository pointRepository;
    private final TopRepository topRepository;


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
        var tops = topRepository.getTop20Users();

        return tops.stream().map(top -> {
            Integer online = Optional.ofNullable(pointRepository.onlineByUserId(new PointId(top.getUserid(), 1)))
                    .orElse(0);
            System.out.println(online);
            return new TopDTO(top.getRolename(),
                    top.getRolelevel(),
                    getFactionName(top.getFactionid()),
                    top.getPk_count(),
                    online);
        }).collect(Collectors.toList());
    }

    private String getFactionName(Integer clanId) {
        if (clanId == 0) {
            return "-";
        } else {
            System.out.println(clanId);
            return clanRepository.getClanNameById(clanId);
        }
    }
}
