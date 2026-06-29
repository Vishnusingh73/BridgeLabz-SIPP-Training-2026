public class ExceptionPropagationDemo {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    public static void method2() {
        method1();
    }

    public static void method1() {
        int value = 10 / 0;
        System.out.println(value);
    }
}
