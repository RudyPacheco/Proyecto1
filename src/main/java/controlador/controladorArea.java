/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.asignar_pieza;
import modelo.mueble;
import modelo.muebleDAO;
import modelo.pieza;
import modelo.piezaDAO;
import modelo.usuario;
import modelo.usuarioDAO;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "controladorArea", urlPatterns = {"/fronted/controladorArea"})
public class controladorArea extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    usuarioDAO usuarioDAO = new usuarioDAO();
    usuario userTEMP = new usuario();
    muebleDAO muebleDAO = new muebleDAO();
    mueble muebleCreado = new mueble();
    List<asignar_pieza> piezasAgregadas = new ArrayList<>();
    pieza piezaTEMP = new pieza();
    piezaDAO piezaDAO = new piezaDAO();
    asignar_pieza asignarPieza = new asignar_pieza();
    asignar_pieza asignarTEMP;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("inicio")) {
            request.getRequestDispatcher("/fronted/areaAdmin/inicio.jsp").forward(request, response);
        }
        if (menu.equals("reportes")) {
            request.getRequestDispatcher("/fronted/areaAdmin/reportes.jsp").forward(request, response);
        }
        if (menu.equals("creacion")) {

            switch (accion) {
                case "validarNombre":
                    muebleCreado = new mueble();
                    String nombreMueble = request.getParameter("nombreMueble");
                    double precioMueble = Double.parseDouble(request.getParameter("precioMueble"));
                    mueble temp = muebleDAO.validarMueble(nombreMueble, 0);
                    if (temp.getNombre_mueble() == null) {
                        muebleCreado.setNombre_mueble(nombreMueble);
                        muebleCreado.setPrecio(precioMueble);
                        request.setAttribute("mueble", muebleCreado);
                    }
                    break;

                case "Agregar":
                    //  String nombreMueble=request.getParameter("nombreMueble");
                    String nombrePieza = request.getParameter("nombrePieza");
                    int cantidad = Integer.parseInt(request.getParameter("cantidadPieza"));
                    piezaTEMP = piezaDAO.validarPieza(nombrePieza, cantidad);
                    if (piezaTEMP.getNombre_pieza() != null) {
                        asignarPieza = new asignar_pieza();
                        asignarPieza.setNombrePieza(nombrePieza);
                        asignarPieza.setCantidad(cantidad);
                        piezasAgregadas.add(asignarPieza);
                        request.setAttribute("lista", piezasAgregadas);
                        request.setAttribute("mueble", muebleCreado);
                    }
                    if (piezasAgregadas.size() > 0) {
                        request.setAttribute("lista", piezasAgregadas);
                        request.setAttribute("mueble", muebleCreado);
                    }
                    break;

                case "limpiar":
                    piezasAgregadas.clear();
                    break;

                case "CrearMueble":

//                           String nombreMueble=request.getParameter("nombreMueble");
//                    mueble temp = muebleDAO.validarMueble(nombreMueble, 0);
//                    if (temp.getNombre_mueble()==null) {
//                        double precioMueble =Double.parseDouble(request.getParameter("precioMueble"));
//                        muebleDAO.registrarMueble(nombreMueble, precioMueble);
//                        for (int i = 0; i < piezasAgregadas.size(); i++) {
//              
//                            asignarTEMP=piezasAgregadas.get(i);
//                                muebleDAO.agregarPiezaMueble(nombreMueble,asignarTEMP.getNombrePieza() , asignarTEMP.getCantidad());
//                            
//                        }
//                    
//                    }
                    if (muebleCreado.getNombre_mueble() != null) {
                        muebleDAO.registrarMueble(muebleCreado.getNombre_mueble(), muebleCreado.isPrecio());
                        for (int i = 0; i < piezasAgregadas.size(); i++) {

                            asignarTEMP = piezasAgregadas.get(i);
                            muebleDAO.agregarPiezaMueble(muebleCreado.getNombre_mueble(), asignarTEMP.getNombrePieza(), asignarTEMP.getCantidad());

                        }
                        piezasAgregadas.clear();
                    }
                    break;

                default:
                //      throw new AssertionError();
            }
            request.getRequestDispatcher("/fronted/areaAdmin/creacion.jsp").forward(request, response);

        }
        if (menu.equals("controlUsuario")) {
            switch (accion) {
                case "listar":
                    List lista = usuarioDAO.listar();
                    request.setAttribute("usuarios", lista);
                    System.out.println("listando");
                    break;
                case "Registrar":
                    String user = request.getParameter("usertxt");
                    String password = request.getParameter("passwordtxt");
                    String categoria = request.getParameter("areatxt");
                    System.out.println("llega aqui?");
                    int categoriaA = Integer.valueOf(categoria);
                    usuarioDAO.agregar(user, password, categoriaA);

                    request.getRequestDispatcher("controladorArea?menu=controlUsuario&accion=listar").forward(request, response);
                    break;
                case "bloquear":

                    String nombre = request.getParameter("id");
                    usuario usrTEMP;
                    usrTEMP = usuarioDAO.buscar(nombre);
                    if (usrTEMP.isBloqueado() == true) {
                        usuarioDAO.desbloquear(nombre);
                        request.getRequestDispatcher("controladorArea?menu=controlUsuario&accion=listar").forward(request, response);

                    } else {
                        usuarioDAO.bloquear(nombre);
                        request.getRequestDispatcher("controladorArea?menu=controlUsuario&accion=listar").forward(request, response);

                    }

                    break;

                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("/fronted/areaAdmin/controlUsuario.jsp").forward(request, response);
        }
        if (menu.equals("cargaDatos")) {
            request.getRequestDispatcher("/fronted/areaAdmin/cargaDatos.jsp").forward(request, response);
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
