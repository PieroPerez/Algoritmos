import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un contenedor de rectángulos con capacidad para 10 rectángulos
        ContainerRect contenedor = new ContainerRect(10);

        // Solicitar las coordenadas para el primer rectángulo (A)
        System.out.println("Prueba 1:");
        System.out.print("Ingrese una esquina del 1er rectángulo: ");
        double x1A = scanner.nextDouble();
        double y1A = scanner.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 1er rectángulo: ");
        double x2A = scanner.nextDouble();
        double y2A = scanner.nextDouble();

        // Crear el primer rectángulo y agregarlo al contenedor
        Coordenada esquina1A = new Coordenada(x1A, y1A);
        Coordenada esquina2A = new Coordenada(x2A, y2A);
        Rectangulo rectanguloA = new Rectangulo(esquina1A, esquina2A);
        contenedor.addRectangulo(rectanguloA);

        // Solicitar las coordenadas para el segundo rectángulo (B)
        System.out.print("Ingrese una esquina del 2do rectángulo: ");
        double x1B = scanner.nextDouble();
        double y1B = scanner.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 2do rectángulo: ");
        double x2B = scanner.nextDouble();
        double y2B = scanner.nextDouble();

        // Crear el segundo rectángulo y agregarlo al contenedor
        Coordenada esquina1B = new Coordenada(x1B, y1B);
        Coordenada esquina2B = new Coordenada(x2B, y2B);
        Rectangulo rectanguloB = new Rectangulo(esquina1B, esquina2B);
        contenedor.addRectangulo(rectanguloB);

        // Mostrar la información de los rectángulos
        System.out.println("Rectangulo A = " + rectanguloA.toString());
        System.out.println("Rectangulo B = " + rectanguloB.toString());

        // Determinar en cuál de los casos se encuentran los rectángulos
        if (Verificador.esSobrePos(rectanguloA, rectanguloB)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo rectanguloSobre = rectanguloSobre(rectanguloA, rectanguloB);
            if (rectanguloSobre != null) {
                System.out.printf("Area de sobreposicion = %.2f\n", rectanguloSobre.calculoArea());
            } else {
                System.out.println("No hay área de sobreposición.");
            }
        } else if (Verificador.esJunto(rectanguloA, rectanguloB)) {
            System.out.println("Rectangulos A y B están juntos.");
        } else {
            System.out.println("Rectangulos A y B son disjuntos.");
        }

        // Mostrar el contenido del contenedor
        System.out.println("\nContenido del contenedor de rectángulos:");
        System.out.println(contenedor.toString());

        scanner.close();
    }

    // Método para calcular el rectángulo de superposición
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        // Calcular los límites de los rectángulos
        double r1MinX = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double r1MaxX = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double r1MinY = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        double r1MaxY = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

        double r2MinX = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double r2MaxX = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double r2MinY = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        double r2MaxY = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

        // Calcular las coordenadas del rectángulo de superposición
        double sobreMinX = Math.max(r1MinX, r2MinX);
        double sobreMaxX = Math.min(r1MaxX, r2MaxX);
        double sobreMinY = Math.max(r1MinY, r2MinY);
        double sobreMaxY = Math.min(r1MaxY, r2MaxY);

        // Si no hay superposición, devolver null
        if (sobreMinX >= sobreMaxX || sobreMinY >= sobreMaxY) {
            return null;
        }

        // Crear el rectángulo de superposición
        Coordenada esquina1 = new Coordenada(sobreMinX, sobreMinY);
        Coordenada esquina2 = new Coordenada(sobreMaxX, sobreMaxY);
        return new Rectangulo(esquina1, esquina2);
    }
}