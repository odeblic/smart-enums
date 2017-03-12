import java.io.FileNotFoundException;

public class SmartEnumDemo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to smart enums !");

        SmartEnum e3 = SmartEnum.fromCode(3);
        System.out.println("e3 = " + e3);
        SmartEnum e5 = SmartEnum.fromName("Five");
        System.out.println("e5 = " + e5);

        SmartEnumLoader eL3 = SmartEnumLoader.fromCode(3);
        System.out.println("e3 = " + e3);
        SmartEnumLoader eL5 = SmartEnumLoader.fromName("Five");
        System.out.println("e5 = " + e5);

    }
}
