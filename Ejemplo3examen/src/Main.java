import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Esbozo de constructor generado automáticamente
	}

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		Scanner sc = new Scanner (System.in);
		Alimento alimento = new Alimento();
		
		
		System.out.println("Ingrese los datos del alimento");
		
		while (alimento.nombre == null || alimento.nombre.isEmpty()) {
			
			System.out.println("Ingrese el nombre del alimento:");
			alimento.nombre = sc.nextLine();
			
		}
		
		while (true) {
			try {
				
				System.out.println("Contenido en lipidos:");
				alimento.lipidos = Double.parseDouble(sc.nextLine());
				
				System.out.println("Contenido en hidratos de carbono:");
				alimento.hidratos = Double.parseDouble(sc.nextLine());
				
				System.out.println("Contenido en proteinas:");
				alimento.protenina = Double.parseDouble(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Ingrese los valores correctamente");
			}
		}
		
		System.out.println("Es de origen animal? (Si/No): ");
		String animal = sc.nextLine().trim().toLowerCase();
		alimento.animal = animal.equals("si") || animal.equals("si");
		
		
		while (true) {
			System.out.println("Contenido en minerales y vitaminas (A/M/B): ");
			String contenido = sc.nextLine().trim().toUpperCase();
			if (contenido.equals("A") || contenido.equals("M") || contenido.equals("B")) {
				alimento.mineyvita = contenido.charAt(0);
				break;
			}else {
				System.out.println("Ingrese un valor valido");
			}
		}
		
		alimento.mostrarAlimento();
	}

}
