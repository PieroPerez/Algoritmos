
public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private static int numRec = 0;

    // Constructor
    public ContainerRect(int capacidad) {
        this.n = capacidad;
        this.rectangulos = new Rectangulo[capacidad];
        this.distancias = new double[capacidad];
        this.areas = new double[capacidad];
    }

    // Método para agregar un rectángulo
    public boolean addRectangulo(Rectangulo rect) {
        if (numRec < n) {
            rectangulos[numRec] = rect;
            distancias[numRec] = rect.getEsquina1().distancia(rect.getEsquina2());
            areas[numRec] = rect.calculoArea();
            numRec++;
            return true;
        } else {
            System.out.println("No se puede agregar más rectángulos. Capacidad máxima alcanzada.");
            return false;
        }
    }

    // Método toString para mostrar el contenido del contenedor
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| Rectángulo | Coordenadas | Distancia | Área |\n");
        sb.append("|------------|-------------|-----------|------|\n");
        for (int i = 0; i < numRec; i++) {
            sb.append(String.format("| %d | %s | %.3f | %.2f |\n",
                    i + 1,
                    rectangulos[i].toString(),
                    distancias[i],
                    areas[i]));
        }
        return sb.toString();
    }
}