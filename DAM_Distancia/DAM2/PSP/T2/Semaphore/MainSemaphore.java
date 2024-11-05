public class MainSemaphore {
public static void main(String[] args) {
    Parking parking = new Parking(2);

    for (int i = 0; i < 5; i++) {
        new Thread(parking, "Coche"+(i+1)).start();
    }
}
}
