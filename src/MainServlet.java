import interactor.Interactor;
import localdb.model.Tool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private final Interactor interactor = Interactor.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getServletPath();
        switch (action) {
            case "/edit": {
                showEditTool(req, resp);
                break;
            }
            case "/new": {
                showAddTool(req, resp);
                break;
            }
            case "/delete": {
                showDeleteTool(req, resp);
                break;
            }
            case "/insert": {

                break;
            }
            default: {
                showTools(req, resp);
            }
        }
    }

    private void showDeleteTool(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("delete.jsp").forward(req, resp);
    }

    private void showEditTool(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Tool tool = (Tool) req.getAttribute("tool");
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    private void showAddTool(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("enchants", interactor.getEnchants());
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    private void showTools(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tools", interactor.getTools());
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }
}
