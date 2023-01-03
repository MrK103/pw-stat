package by.mrk.pwstat.service;

import by.mrk.pwstat.dto.*;

import java.util.List;

public interface StaticService {

    StatisticDTO getStatistic();

    List<ClanDTO> getClanStat();

    List<TopDTO> getTop();

    List<PCDTO> getPCStat();

    List<DonateDTO> getDonateStat();
}
