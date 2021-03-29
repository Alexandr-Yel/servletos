package Actions;

import implementation.operationDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static Constants.Constants_JSP.*;

public class Action_Del implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstname = request.getParameter(FIRSTNAME);
        String lastname = request.getParameter(LASTNAME);
        System.out.println(firstname + "+" + lastname);
        try {
            new operationDB().delete(firstname, lastname);
//            request.setAttribute("users", dataAction.findAllUsers());
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }
}
