package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.IntProductos;
import modelo.Producto;
import util.MysqlConexion;

public class DAOProductos implements IntProductos {

	Connection cn = null;
	PreparedStatement psm = null;
	ResultSet rs = null;
	

	@Override
	public int crearProducto(Producto prod) {
		int value = 0;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "INSERT into Producto (codProducto,nomProducto,precProducto,stockProducto) VALUES (?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, prod.getCodProd());
			psm.setString(2, prod.getNombre());
			psm.setDouble(3, prod.getPrecio());
			psm.setInt(4, prod.getStock());

			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public List<Producto> listarProducto() {
		List<Producto> listProducto = new ArrayList<Producto>();
		try {
			cn = MysqlConexion.getConexion();
			String sql = "Select * from Producto";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Producto prod = new Producto();
				prod.setIdProducto(rs.getInt("idProducto"));
				prod.setCodProd(rs.getString("codProducto"));
				prod.setNombre(rs.getString("nomProducto"));
				prod.setPrecio(rs.getDouble("precProducto"));
				prod.setStock(rs.getInt("stockProducto"));	
				listProducto.add(prod);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Producto obtenerProducto(int id) {
		Producto prod = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT * Producto where idProducto=?";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				prod = new Producto();
				prod.setIdProducto(rs.getInt("idProducto"));
				prod.setCodProd(rs.getString("codProducto"));
				prod.setNombre(rs.getString("nomProducto"));
				prod.setPrecio(rs.getDouble("precProducto"));
				prod.setStock(rs.getInt("stockProducto"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prod;
	}

	@Override
	public Producto eliminarProducto(int id) {
		Producto producto = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "Delete from Producto WHERE idProducto=?";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, id);
			psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return producto;
	}

	@Override
	public int editarProducto(Producto prod) {
		int value = 0;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "UPDATE Producto SET codProducto=?, nomProducto=?, precProducto=?, stockProducto=? WHERE idProducto=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, prod.getCodProd());
			psm.setString(2, prod.getNombre());
			psm.setDouble(3, prod.getPrecio());
			psm.setInt(4, prod.getStock());
			psm.setInt(5, prod.getIdProducto());

			value = psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public List<Producto> bucarProducto(String cod) {
		List<Producto> prodList = new ArrayList<Producto>();
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT * from Producto WHERE idProducto=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, cod);
			rs = psm.executeQuery();
			while(rs.next()) {
				Producto prod = new Producto();
				prod.setIdProducto(rs.getInt("idProducto"));
				prod.setCodProd(rs.getString("codProducto"));
				prod.setNombre(rs.getString("nomProducto"));
				prod.setPrecio(rs.getDouble("precProducto"));
				prod.setStock(rs.getInt("stockProducto"));
				prodList.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prodList;
	}

}
