package controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Logout controller.
 * This controller simply delete all session data about user and simulate logout from the system.
 *
 * @author dinht
 *
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(LogoutController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("Controller starts");
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        LOGGER.trace("Session atribute was removed : username");
        session.removeAttribute("cart");
        LOGGER.trace("Session atribute was removed : cart");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/FoodItemController");
        requestDispatcher.forward(request, response);
        LOGGER.debug("Controller finished");

    }


}