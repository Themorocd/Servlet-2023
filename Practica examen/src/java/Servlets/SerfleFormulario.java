/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
public class SerfleFormulario extends HttpServlet {

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
        String social = request.getParameter("social");
        String ccc = request.getParameter("ccc");
        String texto = request.getParameter("texto");

        boolean compruebocif = comprueboc(cif);
        boolean compruebonss = compruebons(nss);
        boolean comprueboccc = compruebocc(ccc);

        ArrayList<String> errores = new ArrayList<>();

        if (compruebocif && comprueboccc && compruebonss) {

            datosempresa empre = new datosempresa(apellido1, apellido2, nombre, nss, fecha1, fecha2, cif, social, ccc, texto);

            ArrayList<datosempresa> emp = (ArrayList<datosempresa>) contexto.getAttribute("emp");

            if (emp == null) {
                emp = new ArrayList<>();
            }
            
            
            emp.add(empre);
            contexto.setAttribute("emp", emp);
            contexto.setAttribute("apellido1", apellido1);
            contexto.setAttribute("apellido2", apellido2);
            contexto.setAttribute("nombre", nombre);
            contexto.setAttribute("nss", nss);
            contexto.setAttribute("fecha1", fecha1);
            contexto.setAttribute("fecha2", fecha2);
            contexto.setAttribute("cif", cif);
            contexto.setAttribute("social", social);
            contexto.setAttribute("ccc", ccc);
            contexto.setAttribute("texto", texto);

            rd = request.getRequestDispatcher("Formulario.jsp");
            rd.forward(request, response);
        } else {

            if (!comprueboccc) {
                errores.add("Error en el ccc");

            }
            if (!compruebocif) {
                errores.add("Error en el cif");

            }
            if (!compruebonss) {
                errores.add("Error en el nss");

            }

            if (!errores.isEmpty()) {
                contexto.setAttribute("errores", errores);
                rd = request.getRequestDispatcher("Errores.jsp");
                rd.forward(request, response);
            }
        }

    }

    private boolean comprueboc(String cif) {

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

    private boolean compruebons(String nss) {

        if (!nss.isEmpty() && nss != null) {

            String[] control = {"01", "17", "26", "02", "18", "37", "03", "19", "38", "04", "20", "40", "33", "21", "41", "05", "22", "42", "06",
                "23", "43", "07", "24", "44", "08", "25", "45", "09", "27", "46", "10", "28", "47", "11", "29", "48", "39", "30",
                "49", "12", "31", "50", "13", "32", "53", "14", "34", "66", "15", "35", "16", "36"};

            String nsssinespacios = nss.replace(" ", "");
            long numero = Long.parseLong(nsssinespacios.substring(0, 10).trim());
            String interior;
            long resto = numero % 97;

            if (resto < 10) {
                interior = "0" + resto;
            } else {
                interior = Long.toString(resto);
            }
            for (int x = 0; x < control.length; x++) {
                if (control[x].equals(interior)) {
                    return true;
                }
            }

        }

        return false;

    }

    private boolean compruebocc(String ccc) {

        if (!ccc.isEmpty() && ccc != null) {
            String[] control = {"01", "17", "26", "02", "18", "37", "03", "19", "38", "04", "20", "40", "33", "21", "41", "05", "22", "42", "06",
                "23", "43", "07", "24", "44", "08", "25", "45", "09", "27", "46", "10", "28", "47", "11", "29", "48", "39", "30",
                "49", "12", "31", "50", "13", "32", "53", "14", "34", "66", "15", "35", "16", "36"};

            String cccsinespacios = ccc.replace(" ", "");

            cccsinespacios = cccsinespacios.substring(0, 2);

            for (int x = 0; x < control.length; x++) {
                if (control[x].equals(cccsinespacios)) {
                    return true;
                }
            }

        }

        return false;

    }

}
