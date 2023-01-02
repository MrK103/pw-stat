package by.mrk.pwstat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ClanDTO implements Serializable {
    private final String name;
    private final String masterName;
    private final Integer members;
    private byte terr1;
    private byte terr2;
    private byte terr3;
    private short level;

    @Override
    public String toString() {
        return "ClanDTO{" +
                "name='" + name + '\'' +
                ", masterName='" + masterName + '\'' +
                ", members=" + members +
                ", terr1=" + terr1 +
                ", terr2=" + terr2 +
                ", terr3=" + terr3 +
                ", level=" + level +
                '}';
    }
}
