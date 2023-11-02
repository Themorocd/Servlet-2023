
public class Alimento {
	String nombre;
	double lipidos,hidratos,protenina;
	boolean animal;
	char mineyvita;
	
	public Alimento() {


	}

	public Alimento(String nombre, double lipidos, double hidratos, double protenina, boolean animal, char mineyvita) {
		super();
		this.nombre = nombre;
		this.lipidos = lipidos;
		this.hidratos = hidratos;
		this.protenina = protenina;
		this.animal = animal;
		this.mineyvita = mineyvita;
	}

	public void mostrarAlimento() {
		// TODO Esbozo de método generado automáticamente
		System.out.println("Nombre del alimento: "+nombre);
		System.out.println("Contenido en lipidos(%): "+lipidos);
		System.out.println("Contenido en hidratos de carbono(%): "+hidratos);
		System.out.println("Contenido en proteinas(%): "+protenina);
		System.out.println("Es de origen animal: "+(animal ? "Si" : "No"));
		System.out.println("Es dietetico: "+(esDietetico() ? "Si" : "No"));
		System.out.println("Recomendable para deportistas: "+(esParadeportistas() ? "Si" : "No"));
		System.out.println("Contenido energetico (Kcal/g): "+contenergetico());
		
		
	}


	private boolean esDietetico() {
		// TODO Esbozo de método generado automáticamente
		
		return (lipidos < 20) && (mineyvita !='B' && mineyvita !='b');
	}

	private double contenergetico() {
		// TODO Esbozo de método generado automáticamente
		double callipidos = lipidos * 9.4;
		double calproteinas = protenina * 5.3;
		double calhidratos = hidratos * 4.1;
		return calhidratos+callipidos+calproteinas;
	}

	private boolean esParadeportistas() {
		// TODO Esbozo de método generado automáticamente
		return (protenina >=10 && protenina <=15)&&(lipidos >=30 && lipidos<=35)&&(hidratos >=55 && hidratos <=65);
	}


	
	
	
	
}
