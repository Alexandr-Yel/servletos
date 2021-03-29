package Actions;

import implementation.operationDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static Constants.Constants_JSP.*;

public class Action_Add implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstname = request.getParameter(FIRSTNAME);
        String lastname = request.getParameter(LASTNAME);
        try {
            new operationDB().addUser(firstname, lastname);
//            request.setAttribute("users", dataAction.findAllUsers());
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }
}
