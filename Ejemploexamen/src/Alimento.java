

public class Alimento {

	//Inicializamos las variables necesarias 
	String nombre;
	double lipidos,hidratos,proteinas;
	boolean animal;
	char Mineyvita;
	
	//Ahora creamos los contructores necesarios
	
	public Alimento() {
		//Uno siempre vacio
	}

	public Alimento(String nombre, double lipidos, double hidratos, double proteinas, boolean animal, char mineyvita) {
		super();
		this.nombre = nombre;
		this.lipidos = lipidos;
		this.hidratos = hidratos;
		this.proteinas = proteinas;
		this.animal = animal;
		this.Mineyvita = mineyvita;
	}

	public void mostrarAlimento() {
		// TODO Esbozo de método generado automáticamente
		//Aqui mediante sout mostramos por pantalla los datos obtenidos y los resultados
		System.out.println("El nombre del producto es: "+nombre);
		System.out.println("Contenido en lipidos (%): "+lipidos);
		System.out.println("Contenido en hidratos de carbono (%): "+hidratos);
		System.out.println("Contenido en proteinas (%): "+proteinas);
		System.out.println("Es de origen animal: "+(animal ? "Si" : "No"));
		System.out.println("Contenido en minerales y vitaminas: "+Mineyvita);
		System.out.println("Es dietético: "+(esDietetico() ? "Si" : "No"));//si cumple me muestra si, en caso contrario muestra no
		System.out.println("Recomentable para deportistas: "+ (paradeportista() ? "Si" : "No"));
		System.out.println("Contenido energético (kcal/g): "+contenergetico());
		
	}
	//Recordar poner los metodos a publico
	public double contenergetico() {//Recordar pasar este de String a double
		// TODO Esbozo de método generado automáticamente
		double calLipidos = lipidos * 9.4;
		double calProteinas = proteinas * 5.3;
		double calHidratos = hidratos * 4.1;
		
		return calHidratos+calLipidos+calProteinas;
	}

	public boolean paradeportista() {
		// TODO Esbozo de método generado automáticamente
		return (proteinas >= 10 && proteinas <= 15) && (lipidos >=30 && lipidos <=35) && (hidratos >=55 && hidratos <=65);
	}

	public boolean esDietetico() {
		// TODO Esbozo de método generado automáticamente
		return (lipidos < 20) && (Mineyvita !='B' && Mineyvita !='b');
	}
	
	
	
	
	
	
	
}
