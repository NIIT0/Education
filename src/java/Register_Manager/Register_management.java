/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register_Manager;

import DBPack.DBManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */

public class Register_management extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register_management</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register_management at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("index.jsp");
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
        response.sendRedirect("index.jsp");
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
        String Sd=request.getParameter("SdName");
        String Fn=request.getParameter("FName");
        String No=request.getParameter("MobN");
        String Fmn=request.getParameter("FMN");
        String Em=request.getParameter("Email");
        String Ag=request.getParameter("Age");
        String Co=request.getParameter("Courses");
        String Cl=request.getParameter("Classes");
        String Lq=request.getParameter("Last");
        String Us=request.getParameter("User");
        String pass=request.getParameter("Pass");
        try {
            
           int x= DBManagement.executeUpdate("insert into Student_Info(Student_Name, Father_Name, Mobile_no, Father_MobNo, Email, Age,Username, Password, Courses_Applied, Class, Last_Qualification)"
                    + "values('"+Sd+"','"+Fn+"','"+No+"','"+Fmn+"','"+Em+"','"+Ag+"','"+Us+"','"+pass+"','"+Co+"','"+Cl+"','"+Lq+"')");
            if(x==1){
                System.out.println("Registered Successfully");
            }
        } catch (Exception ex) {
            Logger.getLogger(Register_management.class.getName()).log(Level.SEVERE, null, ex);
            
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
