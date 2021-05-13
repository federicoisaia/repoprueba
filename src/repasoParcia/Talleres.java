package repasoParcia;

public class Talleres extends Capacitaciones{
private int duracion_horas;
private double costo_hora;
private int cupo;
private int cant_inscriptos;

public Talleres(String nombre,boolean prior, Tema tem,  int duracion_horas, double costo_hora, int cupo, int cant_inscriptos) {
	super(nombre,prior,tem);
	this.duracion_horas = duracion_horas;
	this.costo_hora = costo_hora;
	this.cupo = cupo;
	this.cant_inscriptos = cant_inscriptos;
}
public Integer creditos() {
	return (this.duracion_horas == 432 )?  12 : this.duracion_horas/6;
}
public Double costo() {
	return (this.prioritaria? this.duracion_horas * this.costo_hora*1.20: this.duracion_horas*this.costo_hora);
}

public void inscribir(Alumno a) throws TallerCompletoException{
	if(this.cupo==this.cant_inscriptos)throw new TallerCompletoException();
	else this.cant_inscriptos++;
}

}
