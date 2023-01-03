package by.mrk.pwstat.entity.enums;

public enum RoleProfEnum {
    CLASS_0( 0, "Воин"),
    CLASS_1( 1, "Маг"),
    CLASS_2(2, "Шаман"),
    CLASS_3( 3, "Друид"),
    CLASS_4(4, "Оборотень"),
    CLASS_5( 5, "Убийцы"),
    CLASS_6(6, "Лучник"),
    CLASS_7( 7, "Жрец"),
    CLASS_8(8, "Страж"),
    CLASS_9( 9, "Мистик"),
    CLASS_10(10, "Призрак"),
    CLASS_11( 11, "Жнец"),
    CLASS_12(12, "Стрелок"),
    CLASS_13( 13, "Паладин"),
    CLASS_14(14, "Странник");

    private final Integer id;
    private final String name;


    RoleProfEnum(Integer id, String name) {
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
