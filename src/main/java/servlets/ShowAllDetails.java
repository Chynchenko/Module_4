package servlets;

import DTO.StatisticsDTO;
import model.Detail;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ShowAllDetails", value = "/statistics")
public class ShowAllDetails extends HttpServlet {
    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Service service;
        try {
            service = Service.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        final String id = request.getParameter("id");
        if (id != null) {
            Optional<Detail> detailById = service.getById(id);
            if (detailById.isPresent()) {
                Detail detail = detailById.get();
                request.setAttribute("detail", detail);
            }
            request.getRequestDispatcher("/showStatisticsById.jsp").forward(request, response);
        } else {
            List<String> allId = service.getAllId();
            request.setAttribute("allId", allId);
            StatisticsDTO stats = service.getStatistics();
            request.setAttribute("producedFuel", stats.getProducedFuel());
            request.setAttribute("usedFuel", stats.getUsedFuel());
            request.setAttribute("brokenMicrocircuits", stats.getBrokenMicrocircuits());
            request.setAttribute("countDetails", stats.getCountDetails());
            request.getRequestDispatcher("/showAllStatistics.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}