package by.mrk.pwstat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopDTO {

    private String userName;
    private Integer level;
    private String role;
    private String clan;
    private Integer isOnline;
    private Integer killWhite;

}
