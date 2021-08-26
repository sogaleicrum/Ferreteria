package Controller;

import DAO.Conexion;
import DAO.ProductoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import Model.*;

@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    ProductoDAO Prd;

    public Control() throws ClassNotFoundException {
        super();
        Conexion con = new Conexion();
        Prd = new ProductoDAO(con);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("inicio")) {
            ruta = "inicio.jsp";
            try {
                request.setAttribute("Producto", Prd.llenarTabla());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("actualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ruta = "agregar.jsp";
            try {
                request.setAttribute("listaUbicacion", Prd.llenarSelectUbicacion());
                request.setAttribute("listaCategoria", Prd.llenarSelectCategoria());

                request.setAttribute("ret", Prd.llenarId(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equalsIgnoreCase("save")) {
            ruta = "agregar.jsp";
            try {
                request.setAttribute("listaUbicacion", Prd.llenarSelectUbicacion());
                request.setAttribute("listaCategoria", Prd.llenarSelectCategoria());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("eliminar")) {
            ruta = "index.jsp";
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Prd.eliminar(id);
                request.setAttribute("Producto", Prd.llenarTabla());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 

        RequestDispatcher dis = request.getRequestDispatcher(ruta);
        dis.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "";
        Producto p = new Producto();
        p.setNombre(request.getParameter("nombre"));
        p.setCantidad(Integer.parseInt((request.getParameter("cantidad"))));
        p.setIdCategoria(Integer.parseInt((request.getParameter("idCategoria"))));
        p.setIdUbicacion(Integer.parseInt((request.getParameter("idUbicacion"))));

        String id = request.getParameter("id");

        if ((id == null || id.isEmpty())) {
            ruta = "/index.jsp";
            Prd.insertar(p);
        }else{
        p.setId(Integer.parseInt(id));
        Prd.Actualizar(p);
        }
        response.sendRedirect(request.getContextPath() + ruta);

    }

}
