package by.mrk.pwstat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberClanDTO {

    private  String name;
    private Integer level;
    private String clanRole;
    private String role;
    private Integer hp;
    private Integer mp;
    private Integer killWhite;

}
