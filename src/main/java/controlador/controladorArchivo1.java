/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "controladorArchivo1", urlPatterns = {"/fronted/controladorArchivo1"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

public class controladorArchivo1 extends HttpServlet {
       ArrayList<String> Lista = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        //Recibe el archivo
    
        Part filePart = request.getPart("file");

        //Almacenamiento del archivo
        String nombreArchivo = filePart.getSubmittedFileName();
        String path = this.getServletConfig().getServletContext().getRealPath("/archivo");
        File directorio = new File(path);
        System.out.println(path);
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        filePart.write(path + "/" + nombreArchivo);
        System.out.println("guardo?");
        //Procesamiento del archivo
        File archivo = new File(path + "/" + nombreArchivo);
        CargaDatos cargaDatos = new CargaDatos(archivo);
        cargaDatos.CargaDatos();

        Lista=cargaDatos.getErrores();
        
        
//        String mensaje = "Archivo cargado con exxito";
//        String mensaje2= "perueba 2 ";
//        String mnsaje3 = " prueba 3";
//        Lista.add(mensaje);
//        Lista.add(mensaje2);
//        Lista.add(mnsaje3);
       // response.getWriter().print("<html><head></head><body><h1>Archivo subido correctamente</h1></body><html>");
        request.setAttribute("Lista", Lista);
        request.getRequestDispatcher("/fronted/areaAdmin/mensajeCargaArchivo.jsp").forward(request, response);
        
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
