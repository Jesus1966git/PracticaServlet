/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jesus.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



@WebServlet
public class Controlador extends HttpServlet {

    //PROPIEDADES
    private List<String> listaTipos;

    //METODOS PROPIOS
    /*
    * Método de carga del desplegable de opciones de uso de los inmuebles en proindiviso
     */
    public void cargaUsos() {
        listaTipos = new ArrayList<>();
        listaTipos.add("Garaje");
        listaTipos.add("Trastero");
        listaTipos.add("Otro uso");
    }

    //METODOS IMPLICITOS DEL SERVLET
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Se implementa la carga dinamica de navegacion de paginas
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Introduccion de datos: </title>");
            out.println("<link rel='stylesheet' type='text/css' href='css/pauta.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='resultado' name='calcularCuota' method='POST'>");
            out.println("<nueva><strong>Por favor rellene el formulario con los datos de la descripción registral (Nota simple):</strong></nueva>");
            out.println("<table style='background-color: lightblue'>");
            out.println("<tr><td>Tipo de elemento: </td>");
            out.println("<td><select name='uso'>");
            cargaUsos();
            for (String item : listaTipos) {
                out.println("<option>" + item + "</option>");
            }
            out.println("</select></td></tr>");
            out.println("</tr><tr><td>Identificador del elemento: </td><td><input type='text' name='numero' required /></td></tr>");
            out.println("<tr><td>Cuota indivisa según registro: </td><td><input type='text' name='cuota' "
                    + "pattern='[0-9]+\\.*,*[0-9]*/*[0-9]*\\.*,*[0-9]*' required /><limitacion> Solo números, coma, punto o barra '/'"
                    + "</limitacion></td></tr>");
            out.println("<tr><td>Número de finca registral: </td><td><input type='text' name='finca' required /></td></tr>");
            out.println("<tr><td></td><td style='align-content: end'><button type='submit' name='opcion' value='resultados'>Enviar</button></td></tr>");
            out.println("</table>");
            out.println("<br/>");
            out.println("<img src='imagenes/ejemplo.jpg' width='593'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. Se realizan los cálculos del
     * porcentaje de la cuota Se realiza la concatenacion del texto resultante
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
