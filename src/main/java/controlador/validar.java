/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuario;
import modelo.usuarioDAO;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "validar", urlPatterns = {"/fronted/validar"})
public class validar extends HttpServlet {

    usuarioDAO usrDAO = new usuarioDAO();
    usuario usr = new usuario();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            System.out.println(user + " " + password);
            usr = usrDAO.validar(user, password);
            if (usr.getUsuario() != null) {
                int categoria=usr.getCategoria();
                //request.setAttribute("usuario", usr);
                switch(categoria){
                    case 1:
                          request.setAttribute("usuario", usr);
                         request.getRequestDispatcher("controlador?accion=areaFabrica").forward(request, response);
                       
                     break;
                    case 2:
                          request.setAttribute("usuario", usr);
                         request.getRequestDispatcher("controlador?accion=areaVenta").forward(request, response);
         
                    break;
                    case 3:
                          request.setAttribute("usuario", usr);
                         request.getRequestDispatcher("controlador?accion=areaAdmin").forward(request, response);

                    break;
                    
                    default:
                        
                }
//                if (usr.getCategoria() == 1) {
//                    request.getRequestDispatcher("controlador?accion=areaFabrica").forward(request, response);
//                }
//                if (usr.getCategoria() == 2) {
//                    request.getRequestDispatcher("controlador?accion=areaVenta").forward(request, response);
//                }
//                if (usr.getCategoria() == 3) {
//                    request.getRequestDispatcher("controlador?accion=areaAdmin").forward(request, response);
//                }

            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

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
