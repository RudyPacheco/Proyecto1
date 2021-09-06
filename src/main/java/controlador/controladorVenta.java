/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cliente;
import modelo.clienteDAO;
import modelo.detalle;
import modelo.detalleDAO;
import modelo.factura;
import modelo.facturaDAO;
import modelo.muebleDAO;
import modelo.muebleRegistrado;
import modelo.piezaDAO;
import modelo.ventaDAO;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "controladorVenta", urlPatterns = {"/fronted/controladorVenta"})
public class controladorVenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    clienteDAO clienteDAO = new clienteDAO();
    piezaDAO piezaDAO = new piezaDAO();
    muebleDAO muebleDAO = new muebleDAO();
    ventaDAO ventaDAO = new ventaDAO();
    facturaDAO facturaDAO = new facturaDAO();
    detalleDAO detalleDAO = new detalleDAO();
    List muebles;
    List piezasN;
    List mueblesRegistrados;
    List piezasUsadas;
    List detalles;
    List facturasList;
    List<muebleRegistrado> mueblesSelect = new ArrayList<>();
    muebleRegistrado muebleBuscado;
    cliente clienteBuscado = new cliente();
    double totalPagar;
    String numSerie;
    String nombreUser;
    factura facturaTEMP = new factura();
    detalle detalleTEMP = new detalle();
    validarDatos validar = new validarDatos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("inicio")) {
            
            request.getRequestDispatcher("/fronted/areaVenta/inicio.jsp").forward(request, response);
        }
        
        if (menu.equals("mueblesVenta")) {

            switch (accion) {
                case "listarMuebles":
                    mueblesRegistrados = muebleDAO.listarMueblesEnsamblados();
                    request.setAttribute("mueblesE", mueblesRegistrados);

                    break;
                case "describirMueble":
                    String idMueble = request.getParameter("idMueble");
                    piezasUsadas = piezaDAO.listarPiezasUsadas(idMueble);
                    request.setAttribute("descripcion", piezasUsadas);
                    request.setAttribute("mueblesE", mueblesRegistrados);
                    break;

            }

            request.getRequestDispatcher("/fronted/areaVenta/mueblesVenta.jsp").forward(request, response);
        }
        if (menu.equals("devolucion")) {
            request.getRequestDispatcher("/fronted/areaVenta/devolucion.jsp").forward(request, response);
        }
        if (menu.equals("consultas")) {

            switch (accion) {
                case "ventaDia":
                    LocalDateTime localDate = LocalDateTime.now();
                    DateTimeFormatter ad = DateTimeFormatter.ofPattern("dd/MM/YYYY");
                    ad.format(localDate);
                    LocalDate fecha = ventaDAO.darFormatoFecha(ad.format(localDate));
                    facturasList = facturaDAO.listarFactura(fecha);
                    request.setAttribute("ventas", facturasList);
                    request.getRequestDispatcher("/fronted/areaVenta/ventasDia.jsp").forward(request, response);
                    break;

                case "compraCliente":
                    request.getRequestDispatcher("/fronted/areaVenta/compraCliente.jsp").forward(request, response);
                    break;

                case "buscarCompra":
                    String nitR = request.getParameter("nitCliente");
                    LocalDate fechaI = LocalDate.parse(request.getParameter("fechaInicial"));
                    LocalDate fechaF = LocalDate.parse(request.getParameter("fechaFinal"));
                    detalles = null;
                    System.out.println(nitR);
                    facturasList = facturaDAO.listarFacturaNitFecha(nitR, fechaI, fechaF);
                    for (int i = 0; i < facturasList.size(); i++) {
                        factura temp = (factura) facturasList.get(i);
                        List detallestmp = detalleDAO.buscarFactura(temp.getId());
                        if (detalles == null) {
                            detalles = detallestmp;
                        } else {
                            detalles.addAll(detallestmp);
                        }
                    }
                    request.setAttribute("facturas", facturasList);
                    request.setAttribute("detalle", detalles);
                    request.getRequestDispatcher("/fronted/areaVenta/compraCliente.jsp").forward(request, response);
                    break;

                case "detalleFactura":
                    String codigoFactura = request.getParameter("codigoFactura");
                    facturaTEMP = facturaDAO.buscarFactura(codigoFactura);
                    clienteBuscado = clienteDAO.validarCliente(facturaTEMP.getNit());
                    detalles = detalleDAO.buscarFactura(facturaTEMP.getId());
                    request.setAttribute("factura", facturaTEMP);
                    request.setAttribute("cliente", clienteBuscado);
                    request.setAttribute("detalle", detalles);
                    request.getRequestDispatcher("/fronted/areaVenta/detallesFactura.jsp").forward(request, response);
                    break;
                case "mostrarFactura":
                    String codigoFactura1 = request.getParameter("codigoFactura");
                    facturaTEMP = facturaDAO.buscarFactura(codigoFactura1);
                    clienteBuscado = clienteDAO.validarCliente(facturaTEMP.getNit());
                    detalles = detalleDAO.buscarFactura(facturaTEMP.getId());
                    request.setAttribute("factura", facturaTEMP);
                    request.setAttribute("cliente", clienteBuscado);
                    request.setAttribute("detalle", detalles);
                    request.getRequestDispatcher("/fronted/areaVenta/factura.jsp").forward(request, response);
                    break;

                default:
            }

            request.getRequestDispatcher("/fronted/areaVenta/consultas.jsp").forward(request, response);
        }
        if (menu.equals("venta")) {

            switch (accion) {
                case "buscarCliente":
                    String nit = request.getParameter("nitCliente");

                    clienteBuscado = clienteDAO.validarCliente(nit);
                    request.setAttribute("numSerie", numSerie);
//                    if (temp.getNombreCliente() != null) {
//                        System.out.println(temp.getNombreCliente());
//                        request.setAttribute("cliente", temp);
//                    }
                    System.out.println(clienteBuscado.getNombreCliente());
                    request.setAttribute("cliente", clienteBuscado);
                    break;

                case "buscarMueble":
                    String id = request.getParameter("codigoProducto");
                    muebleBuscado = muebleDAO.buscarPorId(id);
                    request.setAttribute("mueble", muebleBuscado);
                    request.setAttribute("numSerie", numSerie);
                    request.setAttribute("cliente", clienteBuscado);
                    break;

                case "Agregar":
                    totalPagar = 0.0;
                    String id2 = request.getParameter("codigoProducto");
                    muebleBuscado = muebleDAO.buscarPorId(id2);
                    mueblesSelect.add(muebleBuscado);
                    for (int i = 0; i < mueblesSelect.size(); i++) {
                        totalPagar = totalPagar + mueblesSelect.get(i).getPrecio();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    System.out.println("mueble xddxd" + muebleBuscado.getId_mueble());
                    request.setAttribute("lista", mueblesSelect);
                    //request.setAttribute("mueble", muebleBuscado);
                    request.setAttribute("cliente", clienteBuscado);
                    request.setAttribute("numSerie", numSerie);
                    break;

                case "limpiar":
                    mueblesSelect.clear();
                    break;

                case "Registrar":
                    String NIT = request.getParameter("nitCliente");
                    String nombre = request.getParameter("nombreCliente");
                    String direccion = request.getParameter("direccion");
                    String departamento = request.getParameter("departamento");
                    String municipio = request.getParameter("municipio");
                    ArrayList<String> campos = new ArrayList<>();
                    campos.add(nombre);
                    campos.add(NIT);
                    campos.add(direccion);
                    campos.add(municipio);
                    campos.add(departamento);
                    validar.validarCLIENTE(campos, 0);
                    request.setAttribute("numSerie", numSerie);

                    break;

                case "generarVenta":
                    detalles = null;
                    System.out.println(nombreUser);
                    LocalDateTime localDate = LocalDateTime.now();
                    DateTimeFormatter ad = DateTimeFormatter.ofPattern("dd/MM/YYYY");
                    ad.format(localDate);
                    LocalDate fecha = ventaDAO.darFormatoFecha(ad.format(localDate));
                    ventaDAO.guardarFactura(numSerie, fecha, clienteBuscado.getNit(), nombreUser, totalPagar);

                    for (int i = 0; i < mueblesSelect.size(); i++) {
                        muebleRegistrado temp = mueblesSelect.get(i);
                        ventaDAO.guardarDetalle(numSerie, temp.getId_mueble(), temp.getNombreMueble(), temp.getPrecio());
                        ventaDAO.venderMueble(temp.getId_mueble(), temp.getNombreMueble(), temp.getFechaEnsamble(), fecha, temp.getNombreUsuario(), nombreUser, temp.getCosto(), temp.getPrecio());
                        facturaTEMP = facturaDAO.buscarFactura(numSerie);
                        List detallestmp = detalleDAO.buscarFactura(numSerie);
//                        if (detalles == null) {
//                            detalles = detallestmp;
//                        } else {
//                            detalles.addAll(detallestmp);
//                        }

                    }
                    detalles = detalleDAO.buscarFactura(numSerie);
                    request.setAttribute("factura", facturaTEMP);
                    request.setAttribute("cliente", clienteBuscado);
                    request.setAttribute("detalle", detalles);

                    request.getRequestDispatcher("/fronted/areaVenta/factura.jsp").forward(request, response);

                    break;

                default:
                    nombreUser = request.getParameter("nombreUser");
                    validarDatos valida = new validarDatos();
                    numSerie = ventaDAO.genearSerie();
                    if (numSerie == null) {
                        numSerie = "00000001";
                        request.setAttribute("numSerie", numSerie);
                    } else {
                        int incrementar = Integer.parseInt(numSerie);
                        numSerie = valida.numeroID(incrementar);
                        request.setAttribute("numSerie", numSerie);
                    }

            }

            request.getRequestDispatcher("/fronted/areaVenta/venta.jsp").forward(request, response);
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
