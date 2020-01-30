public class Main {
    public static void main(String[] args) throws Exception {

        Printer printer = new Printer("src/fileText.txt");

        printer.printLinesWhichContain("flowers");
        System.out.println("-----");
        printer.printLinesWhichContain("Frank Zappa");
        System.out.println("-----");
        printer.printLinesWhichContain("");
        System.out.println("-----");
    }
}
