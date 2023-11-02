import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Esbozo de constructor generado automáticamente
	}

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		//Primero inicializamos el metodo Scanner
		Scanner sc = new Scanner (System.in);
		//Luego creamos la clase alimento, donde crearemos los metodos
		Alimento alimento = new Alimento();
		
		//Pedimos que ingrese por teclado los datos del alimento
		System.out.println("Ingrese los datos del alimento");
		//hacemos un bucle while para que se ejecute una vez y hacer las comprobaciones necesarias
		while (alimento.nombre == null || alimento.nombre.isEmpty()) {//aqui me aseguro que nombre no este vacio ni sea null
			
			System.out.println("Ingrese el nombre del alimento");
			alimento.nombre = sc.nextLine();
		}//Con esto me obtengo el nombre del alimento y lo guardo en la clase alimento para su posterior uso
		
		while(true) {//Con true no saldra del bucle hasta que no ingrese valores correctos
			try {
				System.out.println("Contenido en lipidos (%): ");
				alimento.lipidos = Double.parseDouble(sc.nextLine());//No olvidar poner esto sino no lo coge correctamente
				
				System.out.println("Contenido en hidratos de carbono (%): ");
				alimento.hidratos = Double.parseDouble(sc.nextLine());
				
				System.out.println("Contenido en proteinas (%): ");
				alimento.proteinas = Double.parseDouble(sc.nextLine());
				
				break;//si todo esta bien salgo del bucle
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Por favor, ingrese bien los datos");
			}
		}
		
		//Ahora pido si es de origen animal o no 
		
		System.out.println("Es de origen animal? (Si/No): ");
		String animal = sc.nextLine().trim().toLowerCase();
		alimento.animal = animal.equals("si");
		
		//Pedimos el contenido en minerales y vitaminas
		while (true) {
			System.out.println("Contenido en minerales y vitaminas (A/M/B): ");
			String contenido = sc.nextLine().trim().toUpperCase();//Paso a mayusculas lo recodigo por teclado
			if(contenido.equals("A") || contenido.equals("M") || contenido.equals("B")) {
				alimento.Mineyvita = contenido.charAt(0);//no olvidar el charAt(0)
				break;
			}else {
				System.out.println("Ingrese un valor valido (A/M/B)");
			}
			
		}
		//Muestro por consola toda la informacion del alimento
		alimento.mostrarAlimento();
		
	}

}
