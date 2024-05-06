package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.IntSesion;
import modelo.Vendedor;
import util.MysqlConexion;

public class DAOSesion implements IntSesion{
	Vendedor vendedor = null;
	PreparedStatement psm = null;
	Connection cn = null;
	ResultSet rs = null;
	@Override
	public Vendedor verificarInicioSesion(String correo, String clave) {
		try {
			cn = MysqlConexion.getConexion();
			String sql = "select v.idVendedor,v.nomVendedor,v.apeVendedor,v.dniVendedor,v.codVendedor,v.dirVendedor,v.correoVendedor,v.contrVendedor"
					+ " from vendedor as v "
					+ " where v.correoVendedor=? and v.contrVendedor=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, correo);
			psm.setString(2, clave);
			rs = psm.executeQuery();
			if(rs.next())
				vendedor = new Vendedor(rs.getString("nomVendedor"),rs.getString("apeVendedor"),
						rs.getString("dniVendedor"),rs.getInt("idvendedor"),rs.getString("codVendedor"),rs.getString("dirVendedor"),rs.getString("correoVendedor"),rs.getString("contrVendedor"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(psm != null) psm.close();
				if(cn != null) MysqlConexion.closeConnection(cn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vendedor;
	}
}
