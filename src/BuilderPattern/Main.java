package BuilderPattern;


public class Main {
    public static void main(String[] args) {
//        Phone myPhone = new Phone("android", "hand-held", 800, 760, 2);
        PhoneBuilder builder = new PhoneBuilder();
        Phone myPhone = builder.setBatteryLife(2).setPrize(700).createPhone();
        System.out.println(myPhone);
        System.out.println("hello");


    }
}
