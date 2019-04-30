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
public class Org_Coach extends HttpServlet {

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
            out.println("<title>Servlet Org_Coach</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Org_Coach at " + request.getContextPath() + "</h1>");
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
        int x=0;
        
        String IT=request.getParameter("ITname");
        String It=request.getParameter("IT");
        String Co=request.getParameter("CO");
        String Tu=request.getParameter("TU");
        String Jb=request.getParameter("JB");
        String Tc=request.getParameter("TC");
        String Na=request.getParameter("Name");
        String Em=request.getParameter("Email");
        String Us=request.getParameter("User");
        String pwd=request.getParameter("Pass");
        String con=request.getParameter("Contact");
        String Br=request.getParameter("Br_Office");
        String Cr=request.getParameter("Corp_Office");
        String pin=request.getParameter("Pin");
        
        try {
          x= DBManagement.executeUpdate("insert into Coaching_info(Institute_name, Institute, Coaching, Tution, Job_Cell,"
                    + "Training_Center, Owner_Name, Email, UserName, Password, Contact, Branch_office, Corp_office, Pincode)"
                    + " values('"+IT+"','"+It+"','"+Co+"','"+Tu+"','"+Jb+"','"+Tc+"','"+Na+"','"+Em+"','"+Us+"','"+pwd+"',"
                            + "'"+con+"','"+Br+"','"+Cr+"','"+pin+"')");
            
            if(x==1){
                System.out.println("Registered Successfully");
            }
        }
         catch (Exception ex) {
             if(x!=1){
            Logger.getLogger(Org_Coach.class.getName()).log(Level.SEVERE, null, ex);

             }
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
