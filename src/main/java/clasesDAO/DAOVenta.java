package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.IntVenta;
import modelo.Venta;
import util.MysqlConexion;

public class DAOVenta implements IntVenta {

	Connection cn = null;
	PreparedStatement psm = null;
	ResultSet rs = null;

	@Override
	public int crearVenta(Venta vent) {
		LocalDate fechaActual = LocalDate.now();
		int value = 0;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "Insert into Venta(codVenta,dniCliente,codVendedor,nomProducto,fechaCompra,metodoPago,totalVenta,cantProd) VALUES(?,?,?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, vent.getCodVenta());
			psm.setString(2, vent.getDniCliente());
			psm.setString(3, vent.getCodVendedor());
			psm.setString(4, vent.getProducto());
			psm.setObject(5, fechaActual);
			psm.setString(6, vent.getMetodoPago());
			psm.setDouble(7, vent.getTotal());
			psm.setInt(8, vent.getCantProductos());

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
	public List<Venta> listarventa() {
		List<Venta> ventList = new ArrayList<Venta>();
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT * from Venta";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Venta venta = new Venta();
				venta.setIdVenta(rs.getInt("idVenta"));
				venta.setCodVenta(rs.getString("codVenta"));
				venta.setDniCliente(rs.getString("dniCliente"));
				venta.setCodVendedor(rs.getString("codVendedor"));
				venta.setProducto(rs.getString("nomProducto"));
				venta.setFechaCompra(rs.getString("fechaCompra"));
				venta.setMetodoPago(rs.getString("metodoPago"));
				venta.setTotal(rs.getDouble("totalVenta"));
				venta.setCantProductos(rs.getInt("cantProd"));
				ventList.add(venta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ventList;
	}

	@Override
	public Venta obtenerVenta(int id) {
		Venta venta = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT * from Venta where idVenta=?";
			psm = cn.prepareStatement(sql);
			psm.setInt(1, id);
			rs = psm.executeQuery();
			if (rs.next()) {
				venta = new Venta();
				venta.setIdVenta(rs.getInt("idVenta"));
				venta.setCodVenta(rs.getString("codVenta"));
				venta.setDniCliente(rs.getString("dniCliente"));
				venta.setCodVendedor(rs.getString("codVendedor"));
				venta.setProducto(rs.getString("nomProducto"));
				venta.setFechaCompra(rs.getString("fechaCompra"));
				venta.setMetodoPago(rs.getString("metodoPago"));
				venta.setTotal(rs.getDouble("totalVenta"));
				venta.setCantProductos(rs.getInt("cantProd"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return venta;
	}

	@Override
	public Venta eliminarVenta(int id) {
		Venta venta = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "Delete from Venta where idVenta=?";
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
		return venta;
	}

	@Override
	public int editarVenta(Venta vent) {
		int value = 0;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "Update Venta SET codVenta=?,dniCliente=?,codVendedor=?,nomProducto=?,fechaCompra=?,metodoPago=?,totalVenta=?,cantProd=? where idVenta=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, vent.getCodVenta());
			psm.setString(2, vent.getDniCliente());
			psm.setString(3, vent.getCodVendedor());
			psm.setString(4, vent.getProducto());
			psm.setObject(5, vent.getFechaCompra());
			psm.setString(6, vent.getMetodoPago());
			psm.setDouble(7, vent.getTotal());
			psm.setInt(8, vent.getCantProductos());
			psm.setInt(9, vent.getIdVenta());
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
	public List<Venta> buscarVenta(String cod) {
		List<Venta> ventList = new ArrayList<Venta>();
		try {
			cn = MysqlConexion.getConexion();
			String sql = "Select * from Venta where idVenta=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, cod);
			rs = psm.executeQuery();
			while (rs.next()) {
				Venta venta = new Venta();
				venta.setIdVenta(rs.getInt("idVenta"));
				venta.setCodVenta(rs.getString("codVenta"));
				venta.setDniCliente(rs.getString("dniCliente"));
				venta.setCodVendedor(rs.getString("codVendedor"));
				venta.setProducto(rs.getString("nomProducto"));
				venta.setFechaCompra(rs.getString("fechaCompra"));
				venta.setMetodoPago(rs.getString("metodoPago"));
				venta.setTotal(rs.getDouble("totalVenta"));
				venta.setCantProductos(rs.getInt("cantProd"));
				ventList.add(venta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psm != null)
					psm.close();
				if (cn != null)
					MysqlConexion.closeConnection(cn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ventList;
	}

}
