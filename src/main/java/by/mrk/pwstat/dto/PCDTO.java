package by.mrk.pwstat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PCDTO {
    private String name;
    private String classUser;
    private Integer level;
    private Integer killWhite;
    private String online;
    private String pcTime;
}
