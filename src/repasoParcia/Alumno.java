package repasoParcia;

import java.util.List;

public class Alumno {
private int nro_matricula;
private List<Capacitaciones> cap_aprobadas;
private List<Capacitaciones> cap__curso;

public Integer creditosObtenidos() {
	return (this.cap_aprobadas).stream().map(t->t.creditos()).reduce(0,(cred1,cred2)->cred1+cred2);
}
public void inscribir(Capacitaciones c) {
	try {
	c.inscribir(this);
	this.cap__curso.add(c);
	}catch(CreditosInsuficientesException e) {
		
	}catch(TallerCompletoException e) {
		
	}
	
}
}
