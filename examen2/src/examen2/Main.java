package examen2;

import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Esbozo de constructor generado automáticamente
	}

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		Scanner sc = new Scanner (System.in);
		Alimento alimento = new Alimento();
		
		System.out.println("Introdusca los datos del alimento");
		
		while (alimento.nombre == null || alimento.nombre.isEmpty()) {
			System.out.println("Introduzca el nombre del alimento");
			alimento.nombre = sc.nextLine();
		}
		
		while (true) {
			try {
				System.out.println("Cantidad de lipidos: ");
				alimento.lipidos = Double.parseDouble(sc.nextLine());
				
				System.out.println("Cantidad de hidratos: ");
				alimento.hidratos = Double.parseDouble(sc.nextLine());
				
				System.out.println("Cantidad de proteinas: ");
				alimento.proteinas = Double.parseDouble(sc.nextLine());
				
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Introduzca bien los datos");
			}
			
			
		}
		
		System.out.println("Es de origen animal?(Si/No):");
		String origen = sc.nextLine().trim().toLowerCase();
		
		alimento.animal = origen.equals("si");
		
		while (true) {
			
			System.out.println("Contenido en minerales y vitaminas (A/M/B): ");
			String contenido = sc.nextLine().trim().toUpperCase();
			if (contenido.equals("A") || contenido.equals("B") || contenido.equals("B")) {
				alimento.mineyvita = contenido.charAt(0);
				break;
				
			}else {
				System.out.println("Introduzca los datos bien");
			}
			
		}
		
		alimento.monstrarinfo();
		
	}

}
