package by.mrk.pwstat.service;

import by.mrk.pwstat.dto.ClanDTO;
import by.mrk.pwstat.dto.StatisticDTO;
import by.mrk.pwstat.repository.ClanRepository;
import by.mrk.pwstat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StaticServiceImpl implements StaticService {
    private final UserRepository userRepository;
    private final ClanRepository clanRepository;


    @Override
    public StatisticDTO getStatistic() {
        var acc = userRepository.getAllCount();
        var clans = clanRepository.getAllCount();

        return new StatisticDTO(acc, clans);
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


}
