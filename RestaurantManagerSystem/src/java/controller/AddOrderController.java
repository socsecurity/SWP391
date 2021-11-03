/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TableDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetail;
import model.OrderDetailList;
import model.Table;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddOrderController", urlPatterns = {"/add-order"})
public class AddOrderController extends HttpServlet {

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
        //get table id
        String t = request.getParameter("tid");
        t = t.replace("Table id: ", "");
        int tid = Integer.parseInt(t);
        System.out.println("Table id: " +tid);
        
        //get order id
        int oid = TableDAO.getOrderID(tid);
        System.out.println("Order id: " +oid);

        
        //get input order detail
        int pid = Integer.parseInt(request.getParameter("foodid"));
        
        
        //
//        String addbutton = request.getParameter("add");
//        String deleteButton = request.getParameter("delete");
        String deleteButton = request.getParameter("button");

        
        boolean result;
        if(deleteButton.equals("add")){
            int quantity = Integer.parseInt(request.getParameter("quantityfood"));
            result = TableDAO.AddOrder(oid, pid, quantity);
            if(!result){
                request.setAttribute("error", "Failed to add!");
            }
            String url = "OrderController?tid="+tid;
            request.getRequestDispatcher(url).forward(request, response);
        }
        if(deleteButton.equals("delete")){
            result = TableDAO.deleteOrderDetail(oid, pid);
            if(!result){
                request.setAttribute("error", "Failed to delete!");
            }
            String url = "OrderController?tid="+tid;
            request.getRequestDispatcher(url).forward(request, response);
        }
        
        List<OrderDetail> listO = OrderDetailList.getListO();
        request.setAttribute("listO", listO);
        request.getRequestDispatcher("pixel-html/adddelete.jsp").forward(request, response);
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
