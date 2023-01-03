package by.mrk.pwstat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "top")
public class Top {
    @Id
    private Integer id;
    private Integer create_time;
    private Integer roleid;
    private Integer userid;
    private String rolename;
    private Integer rolelevel;
    private Byte rolegender;
    private Byte roleprof;
    private Integer rednametime;
    @ManyToOne()
    @JoinColumn(name = "factionid", referencedColumnName = "id")
//    @Fetch(value = FetchMode.JOIN)
    @NotFound(action = NotFoundAction.IGNORE)
    private Clan factionid;
    private Short factionrole;
    private Integer pinknametime;
    private Short level2;
    private Integer exp;
    private Integer hp;
    private Integer mp;
    private Integer sp;
    private Long timeused;
    private Integer goldadd;
    private Integer goldbuy;
    private Integer goldsell;
    private Integer goldused;
    private Integer pk_count;
    private Integer task_count;


}