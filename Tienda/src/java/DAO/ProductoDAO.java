
package DAO;
import Model.Categoria;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Producto;
import Model.Ubicacion;

public class ProductoDAO {

    Conexion cn;

    public ProductoDAO(Conexion c) {
        this.cn = c;
    }

    public void Actualizar(Producto p) {
        String query = "Update dbo_Productos set Nombre  =?, Cantidad  =?,idCategoria =?, idUbicacion =?   where idProducto =?";
         try {
            PreparedStatement st = cn.Conectar().prepareStatement(query);
            st.setString(1, p.getNombre());
            st.setInt(2, p.getCantidad());
            st.setInt(3, p.getIdCategoria());
            st.setInt(4, p.getIdUbicacion());
            st.setInt(5, p.getId());
            st.execute();
        } catch (SQLException e) {
        e.printStackTrace();
        }
                    
    }
    public ArrayList<Producto> llenarTabla() throws SQLException {
        String query = "select "
                + "p.idProducto id,"
                + "p.Nombre nombre, "
                + "p.Cantidad cantidad,"
                + "c.nombre categoria, u.Descripcion ubicacion from dbo_productos p "
                + "inner join dbo_categoria c on c.idCategoria = p.idCategoria "
                + "inner join dbo_Ubicacion u on u.idUbicacion = p.idUbicacion order by id";
                
        ArrayList<Producto> base = new ArrayList<>();
        Statement st = cn.Conectar().createStatement();
        ResultSet rt = st.executeQuery(query);
        while (rt.next()) {
            Producto p = new Producto();
            p.setId(rt.getInt("id"));
            p.setNombre(rt.getString("nombre"));
            p.setCantidad(rt.getInt("cantidad"));
            p.setCategoria(rt.getString("categoria"));
            p.setUbicacion(rt.getString("ubicacion"));
            base.add(p);
        }
            return base;
                    
    }
    public ArrayList<Ubicacion> llenarSelectUbicacion() throws SQLException {
        String query = "SELECT * FROM dbo_ubicacion";
        ArrayList<Ubicacion> base = new ArrayList<Ubicacion>();
        Statement st = cn.Conectar().createStatement();
        ResultSet rt = st.executeQuery(query);
        while (rt.next()) {
            Ubicacion u = new Ubicacion();
            u.setIdUbicacion(rt.getInt("idUbicacion"));
            u.setDescripcion(rt.getString("descripcion"));
            base.add(u);
        }

        return base;
    }
    
    public ArrayList<Categoria> llenarSelectCategoria() throws SQLException {
        String query = "SELECT * FROM dbo_categoria";
        ArrayList<Categoria> base = new ArrayList<Categoria>();
        Statement st = cn.Conectar().createStatement();
        ResultSet rt = st.executeQuery(query);
        while (rt.next()) {
            Categoria c = new Categoria();
            c.setIdCategoria(rt.getInt("idCategoria"));
            c.setNombre(rt.getString("nombre"));
            base.add(c);
        }

        return base;
    }
    public Model.Producto llenarId(int id) throws SQLException{
       String query = "SELECT * FROM dbo_productos where idProducto='"+id+"'";
        
        Statement st = cn.Conectar().createStatement();
        ResultSet rt = st.executeQuery(query);
        
            Producto p = new Producto();
            while (rt.next()) {
           p.setIdProducto(rt.getInt("idProducto"));
           p.setNombre(rt.getString("nombre"));
           p.setCantidad(rt.getInt("cantidad"));
           p.setIdCategoria(rt.getInt("idCategoria"));
           p.setIdUbicacion(rt.getInt("idUbicacion"));

            
        }
            
        

        return p;
        
    }
    public void insertar(Producto p){
        String query ="insert into dbo_productos(nombre, cantidad,idCategoria,idUbicacion) values (?,?,?,?)";
    
        try {
            PreparedStatement st = cn.Conectar().prepareStatement(query);
            st.setString(1, p.getNombre());
            st.setInt(2, p.getCantidad());
            st.setInt(3, p.getIdCategoria());
            st.setInt(4, p.getIdUbicacion());
            st.execute();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    public void eliminar(int id){
        String query ="Delete from dbo_productos where idProducto =?";
    
        try {
            PreparedStatement st = cn.Conectar().prepareStatement(query);
            st.setInt(1,id);
            st.execute();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
   
    
    
    
}
