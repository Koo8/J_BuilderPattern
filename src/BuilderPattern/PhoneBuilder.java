package BuilderPattern;

public class PhoneBuilder {

    // set default values
    private String Os = "android";
    private String type = "handheld";
    private int screenSize = 600;
    private int prize = 1000;
    private int batteryLife = 3;

    // create all setters with return type to this class

    public PhoneBuilder setOs(String os) {
        Os = os;
        return this;
    }

    public PhoneBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public PhoneBuilder setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setPrize(int prize) {
        this.prize = prize;
        return this;
    }

    public PhoneBuilder setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
        return this;
    }

    // create phone getter method

    public Phone createPhone() {
        return new Phone(Os, type,screenSize, prize,batteryLife);
    }
}
