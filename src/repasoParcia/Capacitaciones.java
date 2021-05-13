package repasoParcia;

public abstract class Capacitaciones implements Comparable<Capacitaciones>{
protected String nombre;
protected boolean prioritaria;
protected Tema temaCap;

public Capacitaciones() {
	
}
public Capacitaciones(String nombre, boolean prioritaria, Tema tem) {
 super();
 this.nombre=nombre;
 this.prioritaria=prioritaria;
 this.temaCap=tem;
}
public abstract Double costo();
@Override
public String toString() {
	return "Capacitaciones [nombre=" + nombre + ", temaCap=" + temaCap + "]";
}
public abstract Integer creditos();
public Tema getTema() {
	return this.temaCap;
}
public int compareTo(Capacitaciones c2) {
	if(this.costo()>c2.costo())return 1;
	if(this.costo()<c2.costo())return -1;
	return 0;
}
public boolean getPrioritaria() {
	return this.prioritaria;
}
public abstract void inscribir (Alumno a)throws TallerCompletoException, CreditosInsuficientesException;
}
