/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad20;

/**
 *
 * @author Andres
 */
class Informe {

    String nombre;
    double dinero;
    String metalico;
    int dias;
    int dado;
    double pregali;
    double prepais;
    double prealme;
    double presanlu;
    double totalGastos;
    double dinerototal;

    public Informe() {
    }

    public Informe(String nombre, double dinero, String metalico, int dias, int dado, double pregali, double prepais, double prealme, double presanlu, double totalGastos, double dinerototal) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.metalico = metalico;
        this.dias = dias;
        this.dado = dado;
        this.pregali = pregali;
        this.prepais = prepais;
        this.prealme = prealme;
        this.presanlu = presanlu;
        this.totalGastos = totalGastos;
        this.dinerototal = dinerototal;
    }

    public void mostrarInforme() {

        System.out.println("Nombre: " + nombre);
        System.out.println("Esta dispuesto a pagar " + dinero + " millones");
        System.out.println("Nuestra compra nos costo " + preciocasas() + " millones");
        System.out.println("Hemos gastado un total de " + pregali + " millones en galicia," + prepais + " millones en Pais Vasco, " + prealme + " millones en Almeria y " + presanlu + " millones en Sanlucar");
        System.out.println("Esta dispuesto a pagar con " + metalico + " por lo tanto realizaremos la venta en " + dias + " dias");
        System.out.println("Ganaremos " + ganancias() + " millones al restarle los impuestos");
        System.out.println(tipoventa());

    }

    public double preciocasas() {
        double precioGalicia = 3.5;
        double precioPaisVasco = 5;
        double precioAlmeria = 2.5;
        double precioSanlucar = 3;

        for (int i = 0; i < 4; i++) {
            dado = (int) (Math.random() * 6) + 1;

            switch (i) {
                case 0:
                    totalGastos += dado * precioGalicia;
                    pregali = dado * precioGalicia;
                    break;
                case 1:
                    totalGastos += dado * precioPaisVasco;
                    prepais = dado * precioPaisVasco;
                    break;
                case 2:
                    totalGastos += dado * precioAlmeria;
                    prealme = dado * precioAlmeria;
                    break;
                case 3:
                    totalGastos += dado * precioSanlucar;
                    presanlu = dado * precioSanlucar;
                    break;
            }
        }
        return totalGastos;
    }

    public double ganancias() {

        double dineroganado = dinero - totalGastos;
        double dinerototal = 0;

        int contador = 0;
        if (pregali >= 12) {
            contador++;
        }
        if (prealme >= 12) {
            contador++;
        }
        if (prepais >= 12) {
            contador++;
        }
        if (presanlu >= 12) {
            contador++;
        }

        dinerototal = dineroganado - (contador + (0.1 * dias));

        return dinerototal;
    }

    public String tipoventa() {

        double porcentaje = 0.10; // 10% expresado como decimal
        double rentable = totalGastos + (totalGastos * porcentaje);

          if (dinero < totalGastos || metalico.equalsIgnoreCase("si")) {
        return "No hay acuerdo";
    } else {
        if (rentable > dinerototal) {
            if (dinerototal >= 0 && dias <= 7) {
                return "Muy buena venta";
            } else {
                return "No es buena venta";
            }
        } else {
            return "No es buena venta";
        }
    }

    }

}
