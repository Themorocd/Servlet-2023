/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class ServletFormulario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String nombre = request.getParameter("nombre");
        String nss = request.getParameter("nss");
        String fecha1 = request.getParameter("fecha1");
        String fecha2 = request.getParameter("fecha2");
        String cif = request.getParameter("cif");
        String razon = request.getParameter("razon");
        String ccc = request.getParameter("ccc");
        String texto = request.getParameter("texto");

        boolean compruebanss = compruebo(nss);
        boolean compruebacif = compruebo2(cif);
        boolean compruebaccc = compruebo3(ccc);
        boolean compruebafecha = compruebo4(fecha1, fecha2);

        ArrayList<String> errores = new ArrayList<>();

        if (compruebaccc && compruebacif && compruebanss && compruebafecha) {

            Partes partes = new Partes(nss, apellido1, apellido2, nombre, cif, razon, ccc, texto, fecha1, fecha2);

            ArrayList<Partes> parte = (ArrayList<Partes>) contexto.getAttribute("parte");

            if (parte == null) {
                parte = new ArrayList<>();
            }

            parte.add(partes);
            Collections.sort(parte);
            contexto.setAttribute("parte", parte);
            
            contexto.setAttribute("apellido1", apellido1);
            contexto.setAttribute("apellido2", apellido2);
            contexto.setAttribute("nombre", nombre);
            contexto.setAttribute("nss", nss);
            contexto.setAttribute("fecha1", fecha1);
            contexto.setAttribute("fecha2", fecha2);
            contexto.setAttribute("cif", cif);
            contexto.setAttribute("razon", razon);
            contexto.setAttribute("ccc", ccc);
            contexto.setAttribute("texto", texto);

            rd = request.getRequestDispatcher("Formulario.jsp");
            rd.forward(request, response);

        } else {

            if (compruebaccc != true) {
                errores.add("El ccc es erroneo");
            }
            if (compruebacif != true) {
                errores.add("El cif es erroneo");

            }
            if (compruebanss != true) {
                errores.add("El nss es erroneo");
            }
            if (compruebafecha != true) {
                errores.add("Eres menor de edad");
            }

            if (!errores.isEmpty()) {
                contexto.setAttribute("tipoerror", errores);
                rd = request.getRequestDispatcher("Errores.jsp");
                rd.forward(request, response);
            }

        }
    }

    private boolean compruebo(String nss) {
        String codigoProvincia[] = {"01", "17", "26", "02", "18", "37", "03", "19", "38", "04", "20", "40", "33",
            "21", "41", "05", "22", "42", "06", "23", "43", "07", "07", "24", "44", "08",
            "25", "45", "09", "27", "46", "10", "28", "47", "11", "29", "48", "39", "30",
            "49", "12", "31", "50", "13", "32", "53", "14", "34", "66", "15", "35", "16", "36"};

        if (nss != null && nss.length() == 11) {
            String numSegSinEspacios = nss.replace(" ", "");
            long numeros = Long.parseLong(numSegSinEspacios.substring(0, 10).trim());

            String interior = "";
            long resto = numeros % 97;
            if (resto < 10) {
                interior = "0" + resto;
            } else {
                interior = Long.toString(resto);
            }
            for (int x = 0; x < codigoProvincia.length; x++) {
                if (codigoProvincia[x].equals(interior)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean compruebo2(String cif) {

        String sinespacios = cif.replace(" ", "");
        if (sinespacios != null && sinespacios.length() == 9) {
            String organizacion[] = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "U", "V", "W"};
            String codigoprovincia[] = {"01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09",
                "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23",
                "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31",
                "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44",
                "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51", "52"};

            String tipoorganizacion = sinespacios.substring(0, 1);
            String digitoprovincia = sinespacios.substring(1, 3);
            String numerocorrelativo = sinespacios.substring(3, 8);
            String numerocontrol = sinespacios.substring(8);

            if (!Arrays.asList(organizacion).contains(tipoorganizacion)) {
                return false;
            }
            if (!Arrays.asList(codigoprovincia).contains(digitoprovincia)) {
                return false;
            }
            if (!numerocorrelativo.matches("[0-9]+")) {
                return false;
            }
            if (tipoorganizacion.matches("[ABEH]") && !numerocontrol.matches("[0-9]")) {
                return false;
            }
            if (("K".equals(tipoorganizacion) || "P".equals(tipoorganizacion) || "Q".equals(tipoorganizacion) || "S".equals(tipoorganizacion) && !numerocontrol.matches("[A-Z]"))) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

    private boolean compruebo3(String ccc) {

        String codigoProvincia[] = {"01", "17", "26", "02", "18", "37", "03", "19", "38", "04", "20", "40", "33",
            "21", "41", "05", "22", "42", "06", "23", "43", "07", "07", "24", "44", "08",
            "25", "45", "09", "27", "46", "10", "28", "47", "11", "29", "48", "39", "30",
            "49", "12", "31", "50", "13", "32", "53", "14", "34", "66", "15", "35", "16", "36"};

        if (ccc != null && ccc.length() == 11) {
            String numSegSinEspacios = ccc.replace(" ", "");
            long numeros = Long.parseLong(numSegSinEspacios.substring(0, 9).trim());

            String interior = "";
            long resto = numeros % 97;
            if (resto < 10) {
                interior = "0" + resto;
            } else {
                interior = Long.toString(resto);
            }
            for (int x = 0; x < codigoProvincia.length; x++) {
                if (codigoProvincia[x].equals(interior)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean compruebo4(String fecha1, String fecha2) {

        LocalDate fechaingre = LocalDate.parse(fecha1);
        LocalDate fechanaci = LocalDate.parse(fecha2);

        Period periodo = Period.between(fechanaci, fechaingre);
        int edad = periodo.getYears();

        if (edad >= 18) {
            return true;
        } else {
            return false;
        }

    }

}
