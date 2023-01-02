package by.mrk.pwstat.service;

import by.mrk.pwstat.dto.ClanDTO;
import by.mrk.pwstat.dto.PCDTO;
import by.mrk.pwstat.dto.StatisticDTO;
import by.mrk.pwstat.dto.TopDTO;

import java.util.List;

public interface StaticService {

    StatisticDTO getStatistic();

    List<ClanDTO> getClanStat();

    List<TopDTO> getTop();

    List<PCDTO> getPCStat();
}
