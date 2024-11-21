public class MainEj1 {
    public static void main(String[] args) {
        Parking parking = new Parking(10);
        int numCoches = 10;

        for (int i = 0; i < numCoches; i++) {
            new Thread(parking, "Coche"+(i+1)).start();
        }
    }
}
