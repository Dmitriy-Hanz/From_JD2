package JD2.Kurs_15_03_2022;

public enum Parts {
    HEAD(1),
    BODY(2),
    RIGHT_HAND(3),
    LEFT_HAND(4),
    RIGHT_LEG(5),
    LEFT_LEG(6),
    CPU(7),
    RAM(8),
    HDD(9);
    private int id;

    Parts(int id) {
        this.id = id;
    }

    public static Parts ret(int id) {
        return switch (id) {
            case 1 -> HEAD;
            case 2 -> BODY;
            case 3 -> RIGHT_HAND;
            case 4 -> LEFT_HAND;
            case 5 -> RIGHT_LEG;
            case 6 -> LEFT_LEG;
            case 7 -> CPU;
            case 8 -> RAM;
            default -> HDD;
        };
    }
}
