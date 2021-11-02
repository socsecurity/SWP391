package controller;

import database.entity.Order;
import exception.DBException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * My Orders controller.
 * This controller show to the user his orders
 *
 * @author dinht.
 *
 */
@WebServlet("/MyOrdersController")
public class MyOrdersController extends HttpServlet {
    private UserService userService;
    private static final Logger LOGGER = LogManager.getLogger(MyOrdersController.class);

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userService = new UserService();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("Controller starts");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        LOGGER.trace("Session atribute : username"+ username);

        List<Order> orders = new LinkedList<>();
        if(username!=null) {
            try {
                orders = userService.getUserOrdersSortByOrderDateReversed(username);
            } catch (DBException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("ORDERS_LIST", orders);
        LOGGER.trace("Session atribute : username"+ username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("my-orders.jsp");
        requestDispatcher.forward(request, response);
        LOGGER.debug("Controller finished");
    }

}