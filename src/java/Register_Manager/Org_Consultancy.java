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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class Org_Consultancy extends HttpServlet {

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
            out.println("<title>Servlet Org_Consultancy</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Org_Consultancy at " + request.getContextPath() + "</h1>");
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
        
        String Tt=request.getParameter("Tutor");
        String St=request.getParameter("Stud");
        String Pw=request.getParameter("ProWorker");
        String Ag=request.getParameter("Agent");
        String N=request.getParameter("Name");
        String On=request.getParameter("OrgName");
        String Mb=request.getParameter("MobNo");
        String Ph=request.getParameter("PhNo");
        String web=request.getParameter("Web");
        String Ad=request.getParameter("Aadhar");
        String Us=request.getParameter("user");
        String pwd=request.getParameter("Pass");
        
        
        
   try {
    int x=DBManagement.executeUpdate("insert into Consultancy_info(Username, Password, Tution_Teacher, Student, Pro_Worker,"
       + " Agent, Name, Organization_Name, Mobile_no, Telephone_no, Website, Aadhar_no) values('"+Tt+"','"+St+"',"
            + "'"+Pw+"','"+Ag+"','"+N+"','"+On+"','"+Mb+"','"+Ph+"','"+web+"','"+Ad+"','"+Us+"','"+pwd+"')");
   if(x==1){
   System.out.println("Registered");
   }                 
   
   } 
        catch (Exception ex) {
            Logger.getLogger(Org_Consultancy.class.getName()).log(Level.SEVERE, null, ex);
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
