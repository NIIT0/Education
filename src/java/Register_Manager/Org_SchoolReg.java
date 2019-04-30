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

public class Org_SchoolReg extends HttpServlet {

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
            out.println("<title>Servlet Org_SchoolReg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Org_SchoolReg at " + request.getContextPath() + "</h1>");
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
        
//Saving Information about School Address in Database
        String Hi=request.getParameter("High-School");
        String In=request.getParameter("Intermediete");
        String con=request.getParameter("Country");
        String St=request.getParameter("State");
        String Dis=request.getParameter("District");
        String Ci=request.getParameter("City");
        String Pl=request.getParameter("Place");
        String Pi=request.getParameter("PinCode");
        
//Saving Application Of School in database
        String Tr=request.getParameter("Trust");
        String Soc=request.getParameter("Society");
        String StBo=request.getParameter("State_Board");
        String Cb=request.getParameter("Central_Board");
        String Nap=request.getParameter("Applicator");
        String Gap=request.getParameter("Govt_Applicator");
        
        try {
        int x=DBManagement.executeUpdate("Insert into Schools_info(High-School,Intermediete,Country,State,District,City,Place,Pincode,Trust,"
           + "Society,State_Board,Central_Board,Applicator,Govt_Applicator,Email,UserName,Password) values('"+Hi+"','"+In+"','"+con+"', "
                + "'"+St+"', '"+Dis+"', '"+Ci+"','"+Pl+"', '"+Pi+"', '"+Tr+"', '"+Soc+"', '"+StBo+"', '"+Cb+"', '"+Nap+"',"
                        + " '"+Gap+"','"+em+"','"+us+"','"+pwd+"')");
           if(x==1){
            System.out.println("Registered Succesfully");
        } }catch (Exception ex) {
            Logger.getLogger(Org_SchoolReg.class.getName()).log(Level.SEVERE, null, ex);
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
