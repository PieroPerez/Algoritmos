public class Coordenada {
    private double x;
    private double y;

    // Constructor que inicializa x, y a cero
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor que inicializa x, y con valores dados
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor que inicializa x, y con los valores de otra Coordenada
    public Coordenada(Coordenada c) {
        this.x = c.getX();
        this.y = c.getY();
    }

    // Métodos setter
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Métodos getter
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    // Método de instancia que calcula la distancia euclidiana
    public double distancia(Coordenada c) {
        return Math.sqrt(Math.pow(this.x - c.getX(), 2) + Math.pow(this.y - c.getY(), 2));
    }

    // Método de clase que calcula la distancia euclidiana
    public static double distancia(Coordenada c1, Coordenada c2) {
        return Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
    }

    // Método que devuelve los valores de una coordenada en determinado formato
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}