public class PolloAsado {
private String tipo;
    private double precio;

    public PolloAsado(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "[" + tipo + " - $" + precio + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PolloAsado pollo = (PolloAsado) obj;
        return tipo.equals(pollo.tipo);
    }
}
