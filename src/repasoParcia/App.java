package repasoParcia;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class App {

	
	public static void main(String[] args) {
		//String nombre,boolean prior, Tema tem,  int duracion_horas, double costo_hora, int cupo, int cant_inscriptos
		
	List<Capacitaciones> capList = new ArrayList<Capacitaciones>();
	Talleres t1= new Talleres("tall1", false, Tema.GESTION, 15, 23.54, 40, 30);
	Talleres t2= new Talleres("tall2", true, Tema.IA, 1000, 45.00, 30, 20);
	//String nombre, boolean prior, Tema tema, Docente doc, int cant_clases, double duracion_clases, int creditos_req
	Cursos c1= new Cursos("cur1", false, Tema.INFRAESTRUCTURA,new Docente("Fede", "@mail", 5, 400.00), 4, 4.0, 15);
	Cursos c2= new Cursos("cur2", true, Tema.INFRAESTRUCTURA,new Docente("robeer", "@mail", 5, 400.00), 4, 4.0, 10 );
	capList.add(c2);
	capList.add(c1);
	capList.add(t2);
	capList.add(t1);
	System.out.println("Hola");
	System.out.println(capList.stream().map(t->t.creditos()).reduce(0,(cred1,cred2)->cred1+cred2));
	System.out.println(capList.stream().map(c-> c.costo()).reduce(0.0,(acum,cost1)->acum+cost1));
	System.out.println(capList.stream().map(c-> c.costo()).reduce(0.0, (acum, cost1)->acum+cost1)/capList.size());
	capList.stream().filter((c)->c.getTema()== Tema.INFRAESTRUCTURA).sorted((cur1,cur2)-> cur1.costo().compareTo(cur2.costo())).collect(Collectors.toList());
	System.out.println((((Cursos)(capList.stream().filter(c-> c instanceof Cursos).max((cur1,cur2)->((Cursos) cur1).getCreditos_req().compareTo(((Cursos)cur2).getCreditos_req()))).get()).getDocente()).toString());
	System.out.println(capList.stream().filter(c-> c.getPrioritaria()).collect(Collectors.toList()));
	System.out.println(capList.stream().sorted((cur1,cur2)->cur1.creditos().compareTo(cur2.creditos())).collect(Collectors.toList()));
	}

}
	/*public List<Capacitaciones> filtrarTema(List<Capacitaciones> lcap, Tema tem  ){
		return (lcap.stream().filter(c-> c.getTema()==tem).sorted( (c1,c2)-> c1.compareTo(c2)).collect(Collectors.toList()));
	}
}*/
