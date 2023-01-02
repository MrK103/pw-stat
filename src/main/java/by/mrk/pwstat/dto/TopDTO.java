package by.mrk.pwstat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TopDTO {

    private String userName;
    private Integer level;
    private String clan;
    private Integer killWhite;
    private Integer isOnline;

}
