public class Empleado {

//atributos
private int numTrabajador;
private String nombres;
private String apellidoMaterno;
private String apellidoPaterno;
private float horasExtras;
private float sueldoBase;
private int anioingreso;

//constructor sobrecargado
public Empleado(int numTrabajador, String nombres, String apellidoMaterno, String apellidoPaterno, float horasExtras,
        float sueldoBase, int anioingreso) {
    this.numTrabajador = numTrabajador;
    this.nombres = nombres;
    this.apellidoMaterno = apellidoMaterno;
    this.apellidoPaterno = apellidoPaterno;
    this.horasExtras = horasExtras;
    this.sueldoBase = sueldoBase;
    this.anioingreso = anioingreso;
}

//getters y setters
public int getNumTrabajador() {
    return numTrabajador;
}

public void setNumTrabajador(int numTrabajador) {
    this.numTrabajador = numTrabajador;
}

public String getNombres() {
    return nombres;
}

public void setNombres(String nombres) {
    this.nombres = nombres;
}

public String getApellidoMaterno() {
    return apellidoMaterno;
}

public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
}

public String getApellidoPaterno() {
    return apellidoPaterno;
}

public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
}

public float getHorasExtras() {
    return horasExtras;
}

public void setHorasExtras(float horasExtras) {
    this.horasExtras = horasExtras;
}

public float getSueldoBase() {
    return sueldoBase;
}

public void setSueldoBase(float sueldoBase) {
    this.sueldoBase = sueldoBase;
}

public int getAnioingreso() {
    return anioingreso;
}

public void setAnioingreso(int anioingreso) {
    this.anioingreso = anioingreso;
}

//metodo toString
@Override
public String toString() {
    return "Empleado{" +
            "numTrabajador=" + numTrabajador +
            ", nombres='" + nombres + '\'' +
            ", apellidoPaterno='" + apellidoPaterno + '\'' +
            ", apellidoMaterno='" + apellidoMaterno + '\'' +
            ", horasExtras=" + horasExtras +
            ", sueldoBase=" + sueldoBase +
            ", anioingreso=" + anioingreso +
            ", sueldoTotal=$" + String.format("%.2f", calcularSueldo()) +
            '}';
}

    //metodo para calcular el sueldo del empleado
    public double calcularSueldo() {
    int anioActual = 2026;
    int aniosAntiguedad = anioActual - this.anioingreso;
    
    // 3% por cada año de antigüedad aplicado sobre el sueldo base
    double prestacionAntiguedad = this.sueldoBase * (0.03 * aniosAntiguedad);
    
    // Pago de horas extra ($276.50 por hora)
    double pagoHorasExtra = this.horasExtras * 276.5;
    
    // Sueldo Total
    return this.sueldoBase + prestacionAntiguedad + pagoHorasExtra;
}

}
