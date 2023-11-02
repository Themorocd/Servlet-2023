package examen2;

public class Alimento {
	
	String nombre;
	double lipidos,hidratos,proteinas;
	boolean animal;
	char mineyvita;
	
	public Alimento() {
		
	}
	
	public Alimento(String nombre, double lipidos, double hidratos, double proteinas, boolean animal, char mineyvita) {
		super();
		this.nombre = nombre;
		this.lipidos = lipidos;
		this.hidratos = hidratos;
		this.proteinas = proteinas;
		this.animal = animal;
		this.mineyvita = mineyvita;
	}

	public void monstrarinfo() {
		// TODO Esbozo de método generado automáticamente
		System.out.println("Nombre del alimento: "+nombre);
		System.out.println("Contenido en lipidos: "+lipidos);
		System.out.println("Contenido en hidratos de carbono: "+hidratos);
		System.out.println("Contenido en proteinas: "+proteinas);
		System.out.println("Es de origen animal? "+(animal ? "Si" : "No"));
		System.out.println("Contenido en minerales y vitaminas: "+mineyvita);
		System.out.println("Es dietetico: "+(esDietetico()? "Si" : "No"));
		System.out.println("Recomendable para deportistas: "+(esdeportista()? "Si" : "No"));
		System.out.println("Contenido energetico: "+contenidoEnergetico());
		
	}

	private double contenidoEnergetico() {
		// TODO Esbozo de método generado automáticamente
		double callipidos = lipidos * 9.4;
		double calhidratos = hidratos * 4.1;
		double calproteinas = proteinas * 5.3;
		return calhidratos+callipidos+calproteinas;
	}

	private boolean esdeportista() {
		// TODO Esbozo de método generado automáticamente
		return (proteinas >=10 && proteinas <=15)&&(lipidos>=30 && lipidos<=35)&&(hidratos>= 55)&&(hidratos<=65);
	}

	private boolean esDietetico() {
		// TODO Esbozo de método generado automáticamente
		return (lipidos<20)&&(mineyvita !='B' && mineyvita !='b');
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
