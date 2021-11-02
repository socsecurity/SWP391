package controller;

/**
 *
 * @author dinht
 */

import database.dao.OrderDAO;
import database.entity.Order;
import database.entity.OrderStatus;
import exception.DBException;
import service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * Admin controller.
 *
 * @author dinht.
 *
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    private OrderDAO orderListDAO;
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            orderService = new OrderService();
            orderListDAO =new OrderDAO();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<OrderStatus> orderStatuses = orderListDAO.getStatuses();
            List<Order> notDoneOrders = orderService.getNotDoneOrdersSortById();
            List<Order> doneOrders = orderService.getDoneOrders();

            request.setAttribute("statusList", orderStatuses);
            request.setAttribute("NOT_DONE_ORDERS_LIST", notDoneOrders);
            request.setAttribute("DONE_ORDERS_LIST", doneOrders);
        } catch (DBException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusName = request.getParameter("status");
        String orderIdString = request.getParameter("orderId");
        Order order;
        try {
            order = orderListDAO.getOrder(orderIdString);
            OrderStatus newStatus = OrderStatus.getOrderStatus(statusName);
            orderListDAO.updateOrder(order.getId(), newStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.doGet(request, response);
    }

    public void setOrderListDAO(OrderDAO orderListDAO) {
        this.orderListDAO = orderListDAO;
    }
}