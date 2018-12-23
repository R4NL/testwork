public class Main {
    public static void main(String args[]) {
        try {
            Servise.start("Вася","Витя");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
