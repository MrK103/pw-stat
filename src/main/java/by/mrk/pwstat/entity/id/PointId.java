package by.mrk.pwstat.entity.id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PointId implements Serializable {
    private int uid;
    private int aid;
}

