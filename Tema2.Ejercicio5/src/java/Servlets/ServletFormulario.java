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
public class ServletFormulario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String nombre = request.getParameter("nombre");
        String cif = request.getParameter("cif");
        String representante = request.getParameter("representante");
        String nif = request.getParameter("nif");
        String sector = request.getParameter("sector");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String ventas = request.getParameter("ventas");
        String texto = request.getParameter("texto");

        compruenoCIF(cif);
        compruebonif(nif);
        compruebotelefono(telefono);

        if (compruebonif(nif) == true && compruebotelefono(telefono) == true && compruenoCIF(cif) == true) {
            Empresa empresa = new Empresa(nombre, cif, representante, nif, sector, telefono, email, ventas, texto);

            ArrayList<Empresa> emp = (ArrayList<Empresa>) contexto.getAttribute("emp");

            if (emp == null) {

                emp = new ArrayList<>();

            }

            emp.add(empresa);

            contexto.setAttribute("emp", emp);

            contexto.setAttribute("nombre", nombre);
            contexto.setAttribute("cif", cif);
            contexto.setAttribute("representante", representante);
            contexto.setAttribute("nif", nif);
            contexto.setAttribute("sector", sector);
            contexto.setAttribute("telefono", telefono);
            contexto.setAttribute("email", email);
            contexto.setAttribute("ventas", ventas);
            contexto.setAttribute("texto", texto);

            rd = request.getRequestDispatcher("/Formulario.jsp");
            rd.forward(request, response);
        } else if (compruenoCIF(cif) != true) {
            String errorcif = "errorcif";
            contexto.setAttribute("tipoerror", errorcif);
            rd = request.getRequestDispatcher("/Errores.jsp");
            rd.forward(request, response);
        } else if (compruebonif(nif) != true) {
            String errornif = "errornif";
            contexto.setAttribute("tipoerror", errornif);
            rd = request.getRequestDispatcher("/Errores.jsp");
            rd.forward(request, response);
        } else if (compruebotelefono(telefono) != true) {
            String errortef = "errortef";
            contexto.setAttribute("tipoerror", errortef);
            rd = request.getRequestDispatcher("/Errores.jsp");
            rd.forward(request, response);
        } else if (compruenoCIF(cif) != true && compruebonif(nif) != true) {
            String errorcifynif = "errorcifynif";
            contexto.setAttribute("tipoerror", errorcifynif);
            rd = request.getRequestDispatcher("/Errores.jsp");
            rd.forward(request, response);
        } else if (compruebonif(nif) != true && compruebotelefono(telefono) != true) {
            String errortefynif = "errortefynif";
            contexto.setAttribute("tipoerror", errortefynif);
            rd = request.getRequestDispatcher("/Errores.jsp");
            rd.forward(request, response);
        } else if (compruebotelefono(telefono) != true && compruenoCIF(cif) != true) {
            String errortefycif = "errortefycif";
            contexto.setAttribute("tipoerror", errortefycif);
            rd = request.getRequestDispatcher("/Errores.jsp");
            rd.forward(request, response);
        } else if(compruebonif(nif) != true && compruebotelefono(telefono) != true && compruenoCIF(cif) != true){
            String errortefynifycif = "errortefynifycif";
            contexto.setAttribute("tipoerror", errortefynifycif);
            rd = request.getRequestDispatcher("/Errores.jsp");
            rd.forward(request, response);
        }

    }

    private boolean compruenoCIF(String cif) {
        String sinespacios = cif.replace(" ", "");
        if (sinespacios != null && sinespacios.length() == 9) {
            
            String organizacion[] = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "U", "V", "W"};
            String codigoprovincia[] = {"01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09",
                "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23",
                "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31",
                "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44",
                "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51", "52"};

            String tiporganizacion = sinespacios.substring(0, 1);
            String digitoprovincia = sinespacios.substring(1, 3);
            String numerocorrelativo = sinespacios.substring(3, 8);
            String numerocontrol = sinespacios.substring(8);

            if (!Arrays.asList(organizacion).contains(tiporganizacion)) {
                return false;
            }
            if (!Arrays.asList(codigoprovincia).contains(digitoprovincia)) {
                return false;
            }
            if (!numerocorrelativo.matches("[0-9]+")) {
                return false;
            }
            if (tiporganizacion.matches("[ABEH]") && !numerocontrol.matches("[0-9]")) {
                return false;
            }

            if (("K".equals(tiporganizacion) || "P".equals(tiporganizacion) || "Q".equals(tiporganizacion) || "S".equals(tiporganizacion)) && !numerocontrol.matches("[A-Z]")) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

    private boolean compruebonif(String nif) {
        boolean correcto = false;
        if (nif != null) {
            String sinespacios = nif.replace(" ", "");
            char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};

            sinespacios = sinespacios.toUpperCase();

            int num = Integer.parseInt(sinespacios.substring(0, 8));

            char letradni = sinespacios.charAt(8);

            if (letradni == letras[num % 23]) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    private boolean compruebotelefono(String telefono) {
        boolean correcto = false;
        String sinespacios = telefono.replace(" ", "");
        if (sinespacios != null) {
            if (sinespacios.length() != 9) {
                return false;
            }
            if (!sinespacios.matches("[0-9]+")) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

}
