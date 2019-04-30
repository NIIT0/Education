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
public class Org_Club extends HttpServlet {

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
            out.println("<title>Servlet Org_Club</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Org_Club at " + request.getContextPath() + "</h1>");
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
        
//Saving Club Details 
        String Clb=request.getParameter("ClbName");
        String Own=request.getParameter("OwnerName");
        String Dir=request.getParameter("DirName");
        String Ad=request.getParameter("Add");
        String em=request.getParameter("Email");
        String Us=request.getParameter("User");
        String pwd=request.getParameter("Pass");
        String we=request.getParameter("web");
        String Co=request.getParameter("Con");
        String Spc=request.getParameter("SprtCl");
        String Dr=request.getParameter("Drama");
        String Ar=request.getParameter("Art");
        String Da=request.getParameter("Dance");
        String Tr=request.getParameter("Training");
        String Fa=request.getParameter("Fash");
//Saving Member Details
        String n1=request.getParameter("n1");
        String w1=request.getParameter("w1");
        String p1=request.getParameter("pro1");
        String n2=request.getParameter("n2");
        String w2=request.getParameter("w2");
        String p2=request.getParameter("pro2");
        String n3=request.getParameter("n3");
        String w3=request.getParameter("w3");
        String p3=request.getParameter("pro3");
        String n4=request.getParameter("n4");
        String w4=request.getParameter("w4");
        String p4=request.getParameter("pro4");

        try {
            
            int x=DBManagement.executeUpdate("insert into Club_info(Club_Name, Club_Owner, Director_Name, Address, Email,"
                    + "Username, Password, Club_Website, Contact_No, Sports_Club, Drama_Center, Art_Club, Dance_Club, "
                    + "Training_Center, Fashion_Club) values('"+Clb+"', '"+Own+"', '"+Dir+"', '"+Ad+"', '"+em+"', '"+Us+"',"
                            + "'"+pwd+"', '"+we+"', '"+Co+"', '"+Spc+"', '"+Dr+"', '"+Ar+"', '"+Da+"', '"+Tr+"', '"+Fa+"')");
        
            int y=DBManagement.executeUpdate("insert into club_memberdetail(First_Member, Second_Member, Third_Member,"
              + " Fourth_Member, First_MemberWork, Second_MemberWork, Third_MemberWork, Four_MemberWork, First_MemberProfession,"
               + " Second_MemberProfession, Third_MemberProfession, Four_MemberProfession)"
                 + " values('"+n1+"', '"+w1+"', '"+p1+"', '"+n2+"', '"+w2+"', '"+p2+"', '"+n3+"', '"+w3+"', '"+p3+"',"
                         + "'"+n4+"', '"+w4+"', '"+p4+"')");
            if(x==1 && y==1){
                
            System.out.println("Registered");
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Org_Club.class.getName()).log(Level.SEVERE, null, ex);
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
