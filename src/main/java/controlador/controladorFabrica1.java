/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.muebleDAO;
import modelo.muebleRegistrado;
import modelo.pieza;
import modelo.piezaDAO;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "controladorFabrica1", urlPatterns = {"/fronted/controladorFabrica1"})
public class controladorFabrica1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    piezaDAO piezaDAO = new piezaDAO();
    muebleDAO muebleDAO = new muebleDAO();
    List mueblesRegistrados;
    List lista;
    List muebles;
    List piezasN;
    String nombreUser;
    List piezasUsadas;
    List listaSeleccion;
    validarDatos validar = new validarDatos();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("inicio")) {
            request.getRequestDispatcher("/fronted/areaFabrica/inicio.jsp").forward(request, response);
        }
        if (menu.equals("libro")) {
            switch (accion) {
                case "listarMuebles":
                    muebles = muebleDAO.listarMuebles();
                    request.setAttribute("muebles", muebles);
                    break;
                case "describirMueble":
                    String nombreMueble = request.getParameter("nombreMueble");
                    piezasN = muebleDAO.listarPiezasMueble(nombreMueble);
                    request.setAttribute("piezasN", piezasN);
                    request.setAttribute("muebles", muebles);
                    break;
            }

            request.getRequestDispatcher("/fronted/areaFabrica/libro.jsp").forward(request, response);
        }
        if (menu.equals("piezas")) {
            switch (accion) {
                case "listar":
                    lista = piezaDAO.listarPiezas();
                    request.setAttribute("piezas", lista);
                    System.out.println("listando");
                    break;
                case "seleccionar":
                    String nombrePieza = request.getParameter("nombrePieza");
                    listaSeleccion = piezaDAO.listarPiezaEspecifica(nombrePieza);
                    request.setAttribute("piezasDisponibles", listaSeleccion);
                    request.setAttribute("piezas", lista);
                    break;

                case "registrar":
                    String nombreP = request.getParameter("nombrePieza");
                    String precio = request.getParameter("precio");
                    ArrayList<String> campos = new ArrayList<>();
                    campos.add(nombreP);
                    campos.add(precio);
                    validar.validarPIEZA(campos, 0);
                    request.setAttribute("piezasDisponibles", listaSeleccion);
                    request.setAttribute("piezas", lista);
                    request.getRequestDispatcher("/fronted/areaFabrica/piezas.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("idPieza"));
                    pieza temp = piezaDAO.buscarPieza(id);
                    request.setAttribute("pieza", temp);
                    request.setAttribute("piezas", lista);

                    break;

                case "actualizar":
                    String nombrePi = request.getParameter("nombrePieza");
                    double precio1 = Double.parseDouble(request.getParameter("precio"));
                    piezaDAO.editarPieza(id, nombrePi, precio1);
                    request.setAttribute("piezas", lista);
                    break;

                case "eliminar":
                    id = Integer.parseInt(request.getParameter("idPieza"));
                    pieza piezaTemp = piezaDAO.buscarPieza(id);
                    piezaDAO.actualizarPieza(piezaTemp.getNombre_pieza(), 0);
                    piezaDAO.eliminarPieza(id);

                    request.setAttribute("piezas", lista);
                    break;

            }

            request.getRequestDispatcher("/fronted/areaFabrica/piezas.jsp").forward(request, response);
        }

        if (menu.equals("ensamble")) {
            switch (accion) {
                case "listarMuebles":
                    muebles = muebleDAO.listarMuebles();
                    request.setAttribute("muebles", muebles);
                    nombreUser = request.getParameter("nombreUser");
                    System.out.println(nombreUser);

                    break;

                case "ensamblarMueble":
                    String nombreMueble = request.getParameter("nombreMueble");
                    LocalDateTime localDate = LocalDateTime.now();
                    DateTimeFormatter ad = DateTimeFormatter.ofPattern("dd/MM/YYYY");
                    ad.format(localDate);
                    String fecha = ad.format(localDate);
                    System.out.println("fecha " + fecha);

                    ArrayList<String> campos = new ArrayList<>();
                    campos.add(nombreMueble);
                    campos.add(nombreUser);
                    campos.add(fecha);
                    validar.validarEnsambleMueble(campos, 0);
                    request.setAttribute("muebles", muebles);
                    break;

            }
            request.getRequestDispatcher("/fronted/areaFabrica/ensamble.jsp").forward(request, response);
        }
        if (menu.equals("registrarMueble")) {
            request.getRequestDispatcher("/fronted/areaFabrica/registrarMueble.jsp").forward(request, response);
        }

        if (menu.equals("mueblesEnsamblados")) {

            switch (accion) {
                case "listar":
//                     muebles = muebleDAO.listarMuebles();
//                    request.setAttribute("muebles", muebles);
                    mueblesRegistrados = muebleDAO.listarMueblesEnsamblados();
                    request.setAttribute("mueblesE", mueblesRegistrados);
                    for (int i = 0; i < mueblesRegistrados.size(); i++) {
                        muebleRegistrado temp = new muebleRegistrado();
                        temp = (muebleRegistrado) mueblesRegistrados.get(i);
                        System.out.println("listado xd ");
                        System.out.println(temp.getId_mueble());
                        System.out.println(temp.getFechaEnsamble());
                        System.out.println(temp.getNombreUsuario());
                    }
                    break;

                case "describirMueble":
                    String idMueble = request.getParameter("idMueble");
                    piezasUsadas = piezaDAO.listarPiezasUsadas(idMueble);
                    request.setAttribute("descripcion", piezasUsadas);
                    request.setAttribute("mueblesE", mueblesRegistrados);

                    break;
            }

            request.getRequestDispatcher("/fronted/areaFabrica/mueblesEnsamblados.jsp").forward(request, response);
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
