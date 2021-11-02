package controller;

import exception.DBException;
import service.OrderService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Login Admin controller.
 * This login is used in AdminFilter that goes before showing admin.jsp
 *
 * @author dinht
 */
@WebServlet("/LoginAdminController")
public class LoginAdminController extends HttpServlet {
    private UserService userService;
    private OrderService orderService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            orderService = new OrderService();
            userService = new UserService();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if (userService.isCorrectAdmin(username, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username_admin", username);
                request.getRequestDispatcher("/AdminController").forward(request, response);
            } else {
                request.setAttribute("message", "Account's Invalid");
                request.getRequestDispatcher("login-admin.jsp").forward(request, response);
            }
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}