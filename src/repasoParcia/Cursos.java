package repasoParcia;

public class Cursos extends Capacitaciones{
private Docente doc;
private int cant_clases;
private double duracion_clases;
private Integer creditos_req;

public Cursos (String nombre, boolean prior, Tema tema, Docente doc, int cant_clases, double duracion_clases, int creditos_req) {
	super(nombre,prior,tema);
	this.doc = doc;
	this.cant_clases = cant_clases;
	if(duracion_clases >2.0 && duracion_clases<4.0) this.duracion_clases = duracion_clases;
	this.creditos_req = creditos_req;
}
public Integer creditos() {
	int creditos=0;
	if (this.prioritaria)creditos+=2;
	creditos+= cant_clases>5? 10: cant_clases*2;
	if(this.doc.getAntiguedad()>=0 && this.doc.getAntiguedad()<5) return creditos++;
	if (this.doc.getAntiguedad()>=5 && this.doc.getAntiguedad()<15) return creditos+= 3;
	if (this.doc.getAntiguedad()>15) return creditos+= 5;
	return creditos;
	
}
public Double costo() {
	
	return (this.prioritaria ? this.cant_clases*this.duracion_clases*this.doc.getCostoHora()*1.1: this.cant_clases*this.duracion_clases*this.doc.getCostoHora());
	
}
public Integer getCreditos_req() {
	return this.creditos_req;
}
public Docente getDocente() {
	return this.doc;
}
public void inscribir(Alumno a) throws CreditosInsuficientesException{
	if(a.creditosObtenidos()< this.creditos_req)throw new CreditosInsuficientesException();
}
}
