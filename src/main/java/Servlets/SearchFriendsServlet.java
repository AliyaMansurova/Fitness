package Servlets;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchFriendsServlet")
public class SearchFriendsServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> friends =(List<User>) request.getSession().getAttribute("friends");
        System.out.println(friends+"frr");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender=request.getParameter("gender");
        User searchType = new User();
        searchType.setFirstName(firstName);
        searchType.setLastName(lastName);
        searchType.setGender_code(gender);
        List<User> founded = userDao.searchUsers(searchType);
        List<User> foundUsers=new ArrayList<>();
        for(User u:founded)
            if(!friends.contains(u))
                foundUsers.add(u);
        System.out.print(foundUsers);
        request.getSession().setAttribute("foundedUsers",foundUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/searchFriends.jsp");
        dispatcher.forward(request,response);

    }
}
