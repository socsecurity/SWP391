package controller;

/**
 *
 * @author dinht
 */

import database.entity.FoodItem;
import database.entity.Item;
import exception.CannotFetchItemsException;
import exception.DBException;
import service.FoodItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Food Item controller.
 *
 * @author dinht
 */
@WebServlet("/FoodItemController")
public class FoodItemController extends HttpServlet {
    private static final int NUMBER_ITEMS_ON_PAGE = 5;
    public static final String FILTER = "filter";
    private FoodItemService foodItemService;

    public void setFoodItemService(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            foodItemService = new FoodItemService();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String command = request.getParameter("web/command");
            HttpSession session = request.getSession();
            List<Item> cart = getCart(session);
            if ("ORDER".equals(command)) {
                String foodId = request.getParameter("foodId");
                foodItemService.addFoodItemToCart(cart, foodId);
                session.setAttribute("cart", cart);
            }
            listFoodItems(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<Item> getCart(HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    private void listFoodItems(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException, CannotFetchItemsException {
        HttpSession session = request.getSession();

        String filterBy = getFilter(request, session);
        session.setAttribute(FILTER, filterBy);

        String sort = request.getParameter("sort");
        String sessionSort = (String) session.getAttribute("sort");
        String order = (String) session.getAttribute("order");
        order = getOppositeOrder(sort, sessionSort, order);

        if (sort == null && sessionSort != null) {
            sort = sessionSort;
        }
        if (order == null) {
            order = "ASC";
        }
        session.setAttribute("order", order);
        session.setAttribute("sort", sort);

        int page = getPageNumber(request, session);
        List<FoodItem> foodItems = foodItemService.getFoodItems(page, NUMBER_ITEMS_ON_PAGE, sort, order, filterBy);
        int numOfPages = filterBy == null || filterBy.isEmpty() ? getNumOfPages(foodItemService.getFoodItems()) : getNumOfPages(foodItems);

        request.setAttribute("numberOfPages", numOfPages);
        session.setAttribute("page", page);
        request.setAttribute("categories", foodItemService.getCategories());
        request.setAttribute("FOOD_LIST", foodItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-food.jsp");
        dispatcher.forward(request, response);
    }

    private String getOppositeOrder(String sort, String sessionSort, String order) {
        if (sort != null && sort.equals(sessionSort)) {
            if ("ASC".equals(order)) {
                order = "DESC";
            } else {
                order = "ASC";
            }
        }
        return order;
    }

    private String getFilter(HttpServletRequest request, HttpSession session) {
        String filterBy = request.getParameter(FILTER);
        if (filterBy == null) {
            filterBy = (String) session.getAttribute(FILTER);
        }
        if (filterBy != null && filterBy.equals("all_categories")) {
            filterBy = null;
        }
        if (filterBy != null && !filterBy.isEmpty()) {
            session.setAttribute("page", 1);
        }
        return filterBy;
    }

    private int getPageNumber(HttpServletRequest request, HttpSession session) {
        int page;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        } else if (session.getAttribute("page") != null) {
            page = (int) session.getAttribute("page");
        } else {
            page = 1;
        }
        return page;
    }

    private int getNumOfPages(List<FoodItem> foodItems) {
        int modOfTheDivision = foodItems.size() % NUMBER_ITEMS_ON_PAGE;
        int incorrectNumOfPages = foodItems.size() / NUMBER_ITEMS_ON_PAGE;
        return modOfTheDivision == 0 ? incorrectNumOfPages : incorrectNumOfPages + 1;
    }
}