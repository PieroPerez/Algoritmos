public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        setEsquina1(c1);
        setEsquina2(c2);
    }

    // Métodos setter y getter
    public void setEsquina1(Coordenada coo) {
        this.esquina1 = coo;
    }

    public void setEsquina2(Coordenada coo) {
        this.esquina2 = coo;
    }

    public Coordenada getEsquina1() {
        return this.esquina1;
    }

    public Coordenada getEsquina2() {
        return this.esquina2;
    }

    // Método para calcular el área del rectángulo
    public double calculoArea() {
        double ancho = Math.abs(this.esquina2.getX() - this.esquina1.getX());
        double alto = Math.abs(this.esquina2.getY() - this.esquina1.getY());
        return ancho * alto;
    }

    // Método toString modificado para mostrar las coordenadas en el orden ingresado
    @Override
    public String toString() {
        return "(" + this.esquina2.toString() + ", " + this.esquina1.toString() + ")";
    }
}