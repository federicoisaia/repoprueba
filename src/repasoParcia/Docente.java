package repasoParcia;

public class Docente {
private String nombre;
private String email;
private int antiguedad;
private double costo_hora;
public Docente(String nombre, String email, int antiguedad, double costo_hora) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.antiguedad = antiguedad;
	this.costo_hora = costo_hora;
}
public int getAntiguedad() {
	return antiguedad;
}
public double getCostoHora(){
	return this.costo_hora;
}
@Override
public String toString() {
	return "Docente [nombre=" + nombre + "]";
}

}
