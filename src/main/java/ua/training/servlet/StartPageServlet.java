package ua.training.servlet;

import ua.training.controller.command.*;
import ua.training.controller.command.login.Login;
import ua.training.controller.command.login.Registration;
import ua.training.model.service.DaoService;

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

        String page = command.execute(request);

        if(page.contains("redirect")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    @Override
    public void destroy(){
        DaoService.close();
    }
}
