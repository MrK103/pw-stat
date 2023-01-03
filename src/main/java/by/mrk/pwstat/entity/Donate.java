package by.mrk.pwstat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Donate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer inv_id;
    private String p_sys_id;
    private String don_system;
    private LocalDateTime data;
    private Float out_summ;
    private Float don_kurs;
    private Integer money;
    private Integer act_bonus;
    private Integer bonus_money;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id")
//    @Fetch(value = FetchMode.JOIN)
    private User userId;
    private String ip;
}
