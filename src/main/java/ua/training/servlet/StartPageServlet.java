package ua.training.servlet;

import ua.training.controller.command.*;
import ua.training.controller.command.admin.AddCoffee;
import ua.training.controller.command.admin.EditCoffee;
import ua.training.controller.command.admin.RemoveCoffee;
import ua.training.controller.command.login.Login;
import ua.training.controller.command.login.Logout;
import ua.training.controller.command.login.Registration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class StartPageServlet extends HttpServlet {
    private Map<String, Command> commands = new ConcurrentHashMap<>();

    @Override
    public void init() throws ServletException{
        commands.put("show-coffees", new ShowCoffees());
        commands.put("show-coffee-van", new ShowCoffeeVan());
        commands.put("sort-coffees", new SortCoffees());
        commands.put("search-coffees", new SearchCoffees());
        commands.put("delete-coffee", new DeleteCoffee());
        commands.put("login", new Login());
        commands.put("registration", new Registration());
        commands.put("logout", new Logout());
        commands.put("admin-addCoffee", new AddCoffee());
        commands.put("admin-removeCoffee", new RemoveCoffee());
        commands.put("admin-editCoffee", new EditCoffee());
    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        path = path.replaceAll(".*/" , "");

        Command command = commands.getOrDefault(path,
                (r)->"index.jsp");
        System.out.println(path);
        String page = command.execute(request);
        System.out.println(page);
        if(page.contains("redirect")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    @Override
    public void destroy(){
    }
}
