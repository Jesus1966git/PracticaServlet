/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jesus.controlador;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import jesus.modelo.Elemento;

@WebServlet("/resultado")
public class Resultado extends HttpServlet {

    //PROPIEDADES
    @Inject
    private Elemento elemento;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            /* TODO output your page here. You may use following sample code. */
            out.println("");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8\">");
            out.println("<link rel='stylesheet' type='text/css' href='css/pauta.css'>");
            out.println("</head>");
            out.println("<body style='background-image: url(imagenes/"+ elemento.getUso().toLowerCase()+".png)'>");
            out.println("<table  style='background-image:  url(imagenes/texture.jpg); color:white'>");
            out.println("<tr><td >La cuota descrita es: </td><td><h2>"+ elemento.getCuota()+ "</h2></td></tr>");
            out.println("<tr><td>El porcentaje resultante es: </td><td><strong>"+ elemento.getPorcentaje()+ "%</strong></td></tr>");
            out.println("<tr><td><label>ADVERTENCIA:</label></td><td><textarea name='textarea' cols='50' rows='2'>"+ elemento.getTexto()+ "</textarea></td><tr>");
            out.println(" </table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
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
     * Handles the HTTP <code>POST</code> method.
     * Procesos de calculo y encadenado
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        elemento.setUso(request.getParameter("uso"));
        elemento.setCuota(request.getParameter("cuota"));
        elemento.setCuota(elemento.getCuota().replace(",", "."));
        elemento.setFinca(request.getParameter("finca"));
        elemento.setNumero(request.getParameter("numero"));

        String resultado = elemento.getCuota();
        DecimalFormat df = new DecimalFormat("#.00000");
        if (resultado.contains("/")) {
            String dividendo = resultado.substring(0, resultado.indexOf("/"));
            String divisor = resultado.substring(resultado.indexOf("/") + 1);
            Double division = (Double.valueOf(dividendo) / Double.valueOf(divisor)) * 100;
            elemento.setPorcentaje(df.format(division));
            elemento.setCuota(elemento.getCuota().replace(".", ","));
           
            elemento.setTexto("El elemento valorado destinado a " + elemento.getUso().toLowerCase()
                    + " corresponde con una cuota indivisa de " + elemento.getCuota()
                    + " partes del total de la finca registral " + elemento.getFinca() + ".");
        } else {
            elemento.setPorcentaje(df.format(Double.valueOf(resultado)));
            elemento.setTexto("El elemento valorado destinado a " + elemento.getUso().toLowerCase()
                    + " corresponde con una cuota indivisa de " + elemento.getCuota()
                    + "% del total de la finca registral " + elemento.getFinca() + ".");
        }
//        elemento.setFondo(elemento.getUso().toLowerCase());

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
