package vxteam.plugin.championship.tools;

public enum Teams {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    SKY,
    BLUE,
    PURPLE,
    PINK;

    public static Teams ofIndex(int index){
        switch (index){
            case 0:
                return RED;
            case 1:
                return ORANGE;
            case 2:
                return YELLOW;
            case 3:
                return GREEN;
            case 4:
                return SKY;
            case 5:
                return BLUE;
            case 6:
                return PURPLE;
            case 7:
                return PINK;
        }
        return RED;
    }
}
