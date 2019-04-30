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

public class Org_College extends HttpServlet {

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
            out.println("<title>Servlet Org_Collage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Org_Collage at " + request.getContextPath() + "</h1>");
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

//Saving Username of person to show it when they login to see

String em=request.getParameter("Email");
String us=request.getParameter("User");
String pwd=request.getParameter("Pass");

//Saving College details in database
        String Cn=request.getParameter("College_Name");
        String Email=request.getParameter("Email_Id");
        String ChN=request.getParameter("Chairman_N");
        String regD=request.getParameter("Reg_Date");
        String Add=request.getParameter("Address");
        String Bad=request.getParameter("Branch_Address");
        String ctn=request.getParameter("ContactNum");
        
//Saving Vice-Chairman details
        String Na=request.getParameter("VcName");
        String Ex=request.getParameter("Experience");
        String Co=request.getParameter("Contact");
        String Qu=request.getParameter("Qualification");
        String Em=request.getParameter("EmailId");
        
//Saving Courses Details
        String u=request.getParameter("UGC");
        String u1=request.getParameter("UGC1");
       // String u2=request.getParameter("UGC2");
        
        String p=request.getParameter("PGC");
        String p1=request.getParameter("PGC1");
        //String p2=request.getParameter("PGC2");

        try {
           int x=DBManagement.executeUpdate("insert into Colleges_info(Email, Username, Password, College_Name, College_Email,"
              + "Chairman_Name, Registration_Date, Full_Address, BranchOffice_Address, Contact_No) values('"+em+"', '"+us+"',"
                    + "'"+pwd+"','"+Cn+"','"+Email+"','"+ChN+"','"+regD+"','"+Add+"','"+Bad+"','"+ctn+"')");
            
            int y=DBManagement.executeUpdate("insert into VC_Info(VC_Name, VC_Experience, VC_Contact, VC_Qualification, "
                + "VC_Email) values('"+Na+"', '"+Ex+"', '"+Co+"', '"+Qu+"', '"+Em+"')");
            
            int z=DBManagement.executeUpdate("insert into Courses_Info(UG_CourseNo1, UG_CourseNo2, PG_CourseNo1,"
               + "PG_CourseNo2) values('"+u+"', '"+u1+"', '"+p+"', '"+p1+"')");
        
        if(x==1 && y==1 &&z==1){
        System.out.println("Successfully Registered");
        }
        } 
        catch (Exception ex) {
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
