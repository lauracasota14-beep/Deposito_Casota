package DesignPatternObserver1;

public class TestSerra {

    public static void main(String[] args) {

        Termometro termometro = new Termometro();

        // Primo osservator  ventilatore.
        termometro.iscrivi(temperatura -> {
            if (temperatura > 28) {
                System.out.println("Ventilatore acceso");
            } else {
                System.out.println("Ventilatore spento");
            }
        });

        // Secondo osservator  display.
        termometro.iscrivi(temperatura -> {
            System.out.println("Display: " + temperatura + " °C");
        });

        termometro.registra(25);
        termometro.registra(29);
        termometro.registra(27);
    }
}
