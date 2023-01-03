package by.mrk.pwstat.entity.enums;

public enum RoleClanEnum {
    PROF_0( 0, "-"),
    PROF_2(2, "Мастер"),
    PROF_3( 3, "Маршал"),
    PROF_4(4, "Майор"),
    PROF_5(5, "Капитан"),
    PROF_6(6, "Рядовой");


    private final Integer id;
    private final String name;


    RoleClanEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
