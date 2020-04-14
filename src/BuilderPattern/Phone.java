package BuilderPattern;

public class Phone {

    private String Os, type;
    private int screenSize, prize, batteryLife;

    public Phone(String os, String type, int screenSize, int prize, int batteryLife) {
        Os = os;
        this.type = type;
        this.screenSize = screenSize;
        this.prize = prize;
        this.batteryLife = batteryLife;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "Os='" + Os + '\'' +
                ", type='" + type + '\'' +
                ", screenSize=" + screenSize +
                ", prize=" + prize +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
