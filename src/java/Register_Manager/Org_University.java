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
public class Org_University extends HttpServlet {

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
            out.println("<title>Servlet Org_University</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Org_University at " + request.getContextPath() + "</h1>");
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
        
//Saving University details in database
        String Un=request.getParameter("University_Name");
        String Email=request.getParameter("Email_Id");
        String ChN=request.getParameter("Chairman_N");
        String regD=request.getParameter("Reg_No");
        String Add=request.getParameter("Address");
        String Bad=request.getParameter("Branch_Address");
        String ctn=request.getParameter("ContactNum");      
//Saving date of person who fill the form or Enter Details
        String Us=request.getParameter("User");
        String pwd=request.getParameter("Pass");
        
//Saving Vice-Chairman details
        String Na=request.getParameter("VcName");
        String Ex=request.getParameter("Experience");
        String Co=request.getParameter("Contact");
        String Qu=request.getParameter("Qualification");
        String Em=request.getParameter("EmailId");
        
        try {
      int x=DBManagement.executeUpdate("Insert into Universities_info(University_Name, Email, Chairman, Registration_Number,"
           + "Address, BranchOffice_Address, Contact, Username, Password, VC_Name, Experience, VC_Contact, VC_Qualification,"
              + " VC_Email)"
               + " values('"+Un+"','"+Email+"','"+ChN+"','"+regD+"','"+Add+"','"+Bad+"','"+ctn+"','"+Us+"','"+pwd+"',"
                    + "'"+Na+"','"+Ex+"','"+Co+"','"+Qu+"','"+Em+"')");
            if(x==1){
            System.out.println("Registered");
            }
            else{
                System.out.println("Some error Occured");
            }
        } catch (Exception ex) {
            Logger.getLogger(Org_College.class.getName()).log(Level.SEVERE, null, ex);
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
