package by.mrk.pwstat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class StatisticDTO implements Serializable {
    private final Integer allAccount;
    private final Integer allClan;
    private final Integer online;
    private final Long female;
    private final Long male;
}
