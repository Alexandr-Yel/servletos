package servlets;

import Actions.Action;
import Actions.Action_Add;
import Actions.Action_Del;
import implementation.operationDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Constants.Constants_JSP.*;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private Map<String, Action> actionMap = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        actionMap.put(PARAM_ADD, new Action_Add());
        actionMap.put(PARAM_DELETE, new Action_Del());

        req.setAttribute(PARAM_USERS, new operationDB().getUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher(USERS_JSP);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Action action = actionMap.get(req.getParameter(PARAM_ACTION));
        try {
            String view = action.execute(req, resp);
            System.out.println(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute(PARAM_USERS, new operationDB().getUsers());

        RequestDispatcher dispatcher = req.getRequestDispatcher(USERS_JSP);
        dispatcher.forward(req, resp);
    }
}