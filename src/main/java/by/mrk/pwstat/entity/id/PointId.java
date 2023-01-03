package by.mrk.pwstat.entity.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PointId implements Serializable {
    private int uid;

    @Override
    public String toString() {
        return "PointId{" +
                "uid=" + uid +
                ", aid=" + aid +
                '}';
    }

    private Integer aid;
}

