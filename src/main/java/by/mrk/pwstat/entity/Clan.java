package by.mrk.pwstat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter
@Table(name = "klan")
public class Clan {
    public Clan(){
        name = "-";
    }

    @Id
    private Integer id;
    private String name;
    private String desc;
    private Short level;
    @Column(name = "masterid")
    private Integer masterId;
    @Column(name = "mastername")
    private String masterName;
    private Integer members;
    private Byte terr1;
    private Byte terr2;
    private Byte terr3;
}
