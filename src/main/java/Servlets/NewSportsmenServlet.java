package Servlets;

import listeners.dbIniter;
import model.User;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewSportsmenServlet")
public class NewSportsmenServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> friends = (List<User>) request.getSession().getAttribute("friends");
        List<User> sportsman = (List<User>) request.getSession().getAttribute("mySportsmans");
        List<User> sp=new ArrayList<>();
        for (User u:sportsman)
            if (!friends.contains(u))
                sp.add(u);

        System.out.print(sp+"1111111111");
        request.getSession().setAttribute("newSportsmans",sp);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/newSportsman.jsp");
        requestDispatcher.forward(request, response);
    }
}
