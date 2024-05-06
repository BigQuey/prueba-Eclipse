package clasesDAO;

import interfaces.IntProductos;
import interfaces.IntSesion;
import interfaces.IntVenta;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract IntProductos getProductos();
	public abstract IntVenta getVenta();
	public abstract IntSesion getSesion();
	public static DAOFactory getDAOFactory(int tipo) {
		switch (tipo) {
		case MYSQL: return new MysqlDAOFactory();
		case SQLSERVER: return null;
		case ORACLE: return null;
		default:
			return null;
		}
	}
}
