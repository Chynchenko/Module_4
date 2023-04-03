package servlets;

import model.Detail;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "create", value = "/start")
public class DetailServlet extends HttpServlet {
    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Service service;
        Detail detail;
        try {
            service = Service.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            detail = service.createDetail();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("detail", detail);
        request.getRequestDispatcher("showCreatedDetail.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}