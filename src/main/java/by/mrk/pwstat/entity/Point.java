package by.mrk.pwstat.entity;

import by.mrk.pwstat.entity.id.PointId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@EqualsAndHashCode(exclude = "pointId")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "point")
public class Point {

    @EmbeddedId
    private PointId pointId;
    @Column(name = "time")
    private Integer time;
    @Column(name = "zoneid")
    private Integer zoneId;
    @Column(name = "zonelocalid")
    private Integer zoneLocalId;
    @Column(name = "accountstart")
    private LocalDateTime accountStart;
    @Column(name = "lastlogin")
    private LocalDateTime lastLogin;
    @Column(name = "enddate")
    private LocalDateTime endDate;
}
