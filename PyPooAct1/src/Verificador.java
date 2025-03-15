public class Verificador {
    // Método para verificar si dos rectángulos se superponen
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        Coordenada r1Esquina1 = r1.getEsquina1();
        Coordenada r1Esquina2 = r1.getEsquina2();
        Coordenada r2Esquina1 = r2.getEsquina1();
        Coordenada r2Esquina2 = r2.getEsquina2();

        // Calcular los límites de los rectángulos
        double r1MinX = Math.min(r1Esquina1.getX(), r1Esquina2.getX());
        double r1MaxX = Math.max(r1Esquina1.getX(), r1Esquina2.getX());
        double r1MinY = Math.min(r1Esquina1.getY(), r1Esquina2.getY());
        double r1MaxY = Math.max(r1Esquina1.getY(), r1Esquina2.getY());

        double r2MinX = Math.min(r2Esquina1.getX(), r2Esquina2.getX());
        double r2MaxX = Math.max(r2Esquina1.getX(), r2Esquina2.getX());
        double r2MinY = Math.min(r2Esquina1.getY(), r2Esquina2.getY());
        double r2MaxY = Math.max(r2Esquina1.getY(), r2Esquina2.getY());

        // Verificar superposición
        if (r1MaxX <= r2MinX || r2MaxX <= r1MinX) {
            return false; // No hay superposición en el eje X
        }
        if (r1MaxY <= r2MinY || r2MaxY <= r1MinY) {
            return false; // No hay superposición en el eje Y
        }

        return true; // Hay superposición
    }

    // Método para verificar si dos rectángulos están juntos
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        Coordenada r1Esquina1 = r1.getEsquina1();
        Coordenada r1Esquina2 = r1.getEsquina2();
        Coordenada r2Esquina1 = r2.getEsquina1();
        Coordenada r2Esquina2 = r2.getEsquina2();

        // Calcular los límites de los rectángulos
        double r1MinX = Math.min(r1Esquina1.getX(), r1Esquina2.getX());
        double r1MaxX = Math.max(r1Esquina1.getX(), r1Esquina2.getX());
        double r1MinY = Math.min(r1Esquina1.getY(), r1Esquina2.getY());
        double r1MaxY = Math.max(r1Esquina1.getY(), r1Esquina2.getY());

        double r2MinX = Math.min(r2Esquina1.getX(), r2Esquina2.getX());
        double r2MaxX = Math.max(r2Esquina1.getX(), r2Esquina2.getX());
        double r2MinY = Math.min(r2Esquina1.getY(), r2Esquina2.getY());
        double r2MaxY = Math.max(r2Esquina1.getY(), r2Esquina2.getY());

        // Verificar si están juntos en el eje X
        if (r1MaxX == r2MinX || r2MaxX == r1MinX) {
            // Verificar si hay superposición en el eje Y
            if (!(r1MaxY < r2MinY || r2MaxY < r1MinY)) {
                return true; // Están juntos en el eje X
            }
        }

        // Verificar si están juntos en el eje Y
        if (r1MaxY == r2MinY || r2MaxY == r1MinY) {
            // Verificar si hay superposición en el eje X
            if (!(r1MaxX < r2MinX || r2MaxX < r1MinX)) {
                return true; // Están juntos en el eje Y
            }
        }

        return false; // No están juntos
    }
}