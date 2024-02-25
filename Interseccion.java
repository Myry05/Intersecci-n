import java.util.Random;

public class Interseccion {

    public static void main(String[] args) {
        // Inicialización de la intersección y los semáforos
        Interseccion interseccion = new Interseccion();
        Semaforo[][] semaforos = new Semaforo[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                semaforos[i][j] = new Semaforo();
            }
        }

        // Variables de simulación
        int horaDelDia = 0; // Hora inicial
        Random random = new Random();

        // Simulación del paso del tiempo
        for (int i = 0; i < 24; i++) { // Simular un ciclo de 24 horas
            // Obtener el tráfico en ese momento (por simplicidad, uso un número aleatorio)
            int[][] trafico = new int[4][2];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    trafico[j][k] = random.nextInt(100);
                }
            }

            // Ajustar la duración del semáforo verde basado en el tráfico
            int[][] duracionesVerde = interseccion.calcularDuracionesVerde(trafico);

            // Mostrar la hora y la duración del verde de los semáforos
            System.out.println("Hora: " + horaDelDia + ":00");
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.println("Semaforo Calle " + (j + 1) + ", Carril " + (k + 1) + " - Verde: " + duracionesVerde[j][k] + " segundos");
                }
            }
            System.out.println();

            // Incrementar la hora del día
            horaDelDia++;
            if (horaDelDia == 24) horaDelDia = 0;
        }
    }

    // Método para calcular las duraciones del verde de los semáforos basado en el tráfico
    public int[][] calcularDuracionesVerde(int[][] trafico) {
        // Por simplicidad, suponemos una relación lineal entre el tráfico y la duración del verde
        // En la implementación real, esto podría ser mucho más complejo, utilizando datos históricos, predicciones, etc.
        int[][] duracionesVerde = new int[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                duracionesVerde[i][j] = Math.max(10, 60 - trafico[i][j]); // Duración mínima de 10 segundos, máxima de 60 segundos
            }
        }
        return duracionesVerde;
    }
}

class Semaforo {
    // Clase para representar un semáforo (actualmente no contiene datos específicos)
}
