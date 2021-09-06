/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.detalle;
import modelo.muebleMasVendido;
import modelo.muebleVendido;
import modelo.reportesDAO;
import modelo.usuarioGanancia;
import modelo.usuarioMasVenta;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "ServletDescarga", urlPatterns = {"/fronted/ServletDescarga"})
public class ServletDescarga extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    reportesDAO reportesDAO = new reportesDAO();
    validarDatos validarDatos = new validarDatos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        String reporte = request.getParameter("reporte");

        switch (reporte) {
            case "ventas":
                this.reporteVenta(request, response);
                break;

            case "ganancias":
                this.reporteGanancia(request, response);
                break;

            case "usuarioMasVentas":
                this.reporteUsuarioMasVenta(request, response);
                break;
                
                case "usuarioMasGanancia":
                    this.reporteUsuarioMasGanancia(request, response);
                    break;
            case "muebleMasVendido":
                this.reporteMuebleMasVendido(request, response);
                break;

            case "muebleMenosVendido":
                this.reporteMuebleMenosVendido(request, response);
                break;

        }

    }

    public void reporteVenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fechaInicial = request.getParameter("fechaInicial");
        String fechafinal = request.getParameter("fechaFinal");
        LocalDate fechaI = LocalDate.parse(request.getParameter("fechaInicial"));
        LocalDate fechaF = LocalDate.parse(request.getParameter("fechaFinal"));
        System.out.println(fechaInicial);
        System.out.println(fechafinal);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=ReporteVentas" + fechaInicial + "a" + fechafinal + ".csv");
        //   response.setHeader("Content-Disposition", "attachment;filename=ReporteVentas.csv");
        response.setDateHeader("Expires", -1);

        PrintWriter out = response.getWriter();
//        LocalDate fechaI = validarDatos.darFormatoFecha(fechaInicial);
//        LocalDate fechaF = validarDatos.darFormatoFecha(fechafinal);

        List<muebleVendido> registros = new ArrayList<>();
        registros = reportesDAO.listarMueblesVendidosFecha(fechaI, fechaF);
//registros = reportesDAO.listarMueblesVendidos();
        double totalCosto = 0;
        double totalPrecio = 0;

        for (muebleVendido r : registros) {
            totalCosto += r.getCosto();
            totalPrecio += r.getPrecio();
        }

        //Inicializas un String con el encabezado de tu tabla.
        String contenido = "CANTIDAD DE VENTAS," + registros.size()
                + "\nTOTAL VENDIDO," + totalPrecio + "\nFECHA DE VENTA,VENDEDOR,PRODUCTO,COSTO,PRECIO DE VENTA\n";

        for (muebleVendido registro : registros) {
            contenido += registro.getFechaVenta() + ",";
            contenido += registro.getUsuarioVenta() + ",";
            contenido += registro.getNombreMueble() + ",";
            contenido += registro.getPrecio() + "\n";
        }

        out.println(contenido);

    }

    public void reporteGanancia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fechaInicial = request.getParameter("fechaInicial");
        String fechafinal = request.getParameter("fechaFinal");
        LocalDate fechaI = LocalDate.parse(request.getParameter("fechaInicial"));
        LocalDate fechaF = LocalDate.parse(request.getParameter("fechaFinal"));

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=ReporteGanancia" + fechaInicial + "a" + fechafinal + ".csv");
        response.setDateHeader("Expires", -1);

        PrintWriter out = response.getWriter();

        List<muebleVendido> registros = new ArrayList<>();
        registros = reportesDAO.listarMueblesVendidosFecha(fechaI, fechaF);

        double totalCosto = 0;
        double totalPrecio = 0;

        for (muebleVendido r : registros) {
            totalCosto += r.getCosto();
            totalPrecio += r.getPrecio();
        }
        double Gananciatotal = Math.round((totalPrecio - totalCosto) * 100.0) / 100.0;
        //Inicializas un String con el encabezado de tu tabla.
        String contenido = "CANTIDAD DE VENTAS," + registros.size()
                + "\nGanancia," + (Gananciatotal) + "\nFECHA DE VENTA,PRODUCTO,PRECIO DE VENTA,COSTO,GANANCIA\n";

        for (muebleVendido registro : registros) {
            contenido += registro.getFechaVenta() + ",";
            contenido += registro.getNombreMueble() + ",";
            contenido += registro.getPrecio() + ",";
            contenido += registro.getCosto() + ",";
            contenido += Math.round((registro.getPrecio() - registro.getCosto()) * 100.0) / 100.0 + "\n";
        }

        out.println(contenido);
    }

    public void reporteUsuarioMasVenta(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String fechaInicial = request.getParameter("fechaInicial");
        String fechafinal = request.getParameter("fechaFinal");
        LocalDate fechaI = LocalDate.parse(request.getParameter("fechaInicial"));
        LocalDate fechaF = LocalDate.parse(request.getParameter("fechaFinal"));

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=ReporteUsuarioMasVenta" + fechaInicial + "a" + fechafinal + ".csv");
        response.setDateHeader("Expires", -1);

        PrintWriter out = response.getWriter();

        List<usuarioMasVenta> usuarios = new ArrayList<>();
        usuarios = reportesDAO.listarUsuarioMasVentas(fechaI, fechaF);
        usuarioMasVenta temp = usuarios.get(0);
        List<muebleVendido> registros = reportesDAO.listarMueblesVendidosUsuario(temp.getNombreUsuario());

        String contenido = "USUARIO :," + temp.getNombreUsuario()
                + "\nCANTIDAD DE VENTAS," + temp.getTotal() + "\nFECHA DE VENTA,VENDEDOR,CODIGO PRODUCTO,PRODUCTO,PRECIO DE VENTA\n";

        for (muebleVendido registro : registros) {
            contenido += registro.getFechaVenta() + ",";
            contenido += registro.getUsuarioVenta() + ",";
            contenido += registro.getIdMueble() + ",";
            contenido += registro.getNombreMueble() + ",";
            contenido += registro.getPrecio() + "\n";
        }

        out.println(contenido);

    }

    public void reporteUsuarioMasGanancia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fechaInicial = request.getParameter("fechaInicial");
        String fechafinal = request.getParameter("fechaFinal");
        LocalDate fechaI = LocalDate.parse(request.getParameter("fechaInicial"));
        LocalDate fechaF = LocalDate.parse(request.getParameter("fechaFinal"));

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=ReporteUsuarioMasGanancia" + fechaInicial + "a" + fechafinal + ".csv");
        response.setDateHeader("Expires", -1);

        PrintWriter out = response.getWriter();

        List<usuarioGanancia> usuarios = new ArrayList<>();
        usuarios = reportesDAO.listarUsuaiosGanancia(fechaI, fechaF);
        usuarioGanancia temp = usuarios.get(0);
        List<muebleVendido> registros = reportesDAO.listarMueblesVendidosUsuario(temp.getNombreUsuario());

        String contenido = "USUARIO :," + temp.getNombreUsuario()
                + "\nGANANCIAS TOTALES," + temp.getGanancia() + "\nFECHA DE VENTA,VENDEDOR,CODIGO PRODUCTO,PRODUCTO,COSTO PRODUCTO,PRECIO DE VENTA\n";

        for (muebleVendido registro : registros) {
            contenido += registro.getFechaVenta() + ",";
            contenido += registro.getUsuarioVenta() + ",";
            contenido += registro.getIdMueble() + ",";
            contenido += registro.getNombreMueble() + ",";
            contenido += registro.getCosto()+",";
            contenido += registro.getPrecio() + "\n";
        }

        out.println(contenido);

    }

    public void reporteMuebleMasVendido(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fechaInicial = request.getParameter("fechaInicial");
        String fechafinal = request.getParameter("fechaFinal");
        LocalDate fechaI = LocalDate.parse(request.getParameter("fechaInicial"));
        LocalDate fechaF = LocalDate.parse(request.getParameter("fechaFinal"));

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=ReporteMuebleMasVendido" + fechaInicial + "a" + fechafinal + ".csv");
        response.setDateHeader("Expires", -1);

        PrintWriter out = response.getWriter();

        List<muebleMasVendido> muebles = new ArrayList<>();
        muebles = reportesDAO.listarMuebleMasVentas(fechaI, fechaF);
        muebleMasVendido temp = muebles.get(0);
        List<muebleVendido> registros = reportesDAO.listarMueblesVendidosNombre(temp.getNombreMueble());

        String contenido = "MUEBLE MAS VENDIDO :," + temp.getNombreMueble()
                + "\nCANTIDAD DE VENTAS," + temp.getTotal() + "\nFECHA DE VENTA,VENDEDOR,CODIGO PRODUCTO,PRODUCTO,PRECIO DE VENTA\n";

        for (muebleVendido registro : registros) {
            contenido += registro.getFechaVenta() + ",";
            contenido += registro.getUsuarioVenta() + ",";
            contenido += registro.getIdMueble() + ",";
            contenido += registro.getNombreMueble() + ",";
            contenido += registro.getPrecio() + "\n";
        }

        out.println(contenido);

    }

    public void reporteMuebleMenosVendido(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fechaInicial = request.getParameter("fechaInicial");
        String fechafinal = request.getParameter("fechaFinal");
        LocalDate fechaI = LocalDate.parse(request.getParameter("fechaInicial"));
        LocalDate fechaF = LocalDate.parse(request.getParameter("fechaFinal"));

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=ReporteMuebleMasVendido" + fechaInicial + "a" + fechafinal + ".csv");
        response.setDateHeader("Expires", -1);

        PrintWriter out = response.getWriter();

        List<muebleMasVendido> muebles = new ArrayList<>();
        muebles = reportesDAO.listarMuebleMasVentas(fechaI, fechaF);
        muebleMasVendido temp = muebles.get(muebles.size() - 1);
        List<muebleVendido> registros = reportesDAO.listarMueblesVendidosNombre(temp.getNombreMueble());

        String contenido = "MUEBLE MENOS VENDIDO :," + temp.getNombreMueble()
                + "\nCANTIDAD DE VENTAS," + temp.getTotal() + "\nFECHA DE VENTA,VENDEDOR,CODIGO PRODUCTO,PRODUCTO,PRECIO DE VENTA\n";

        for (muebleVendido registro : registros) {
            contenido += registro.getFechaVenta() + ",";
            contenido += registro.getUsuarioVenta() + ",";
            contenido += registro.getIdMueble() + ",";
            contenido += registro.getNombreMueble() + ",";
            contenido += registro.getPrecio() + "\n";
        }

        out.println(contenido);

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
