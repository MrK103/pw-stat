package by.mrk.pwstat.entity.enums;

public enum PointEnum {
    ONLINE(1),
    OFFLINE(2);

    private final Integer id;
    PointEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
