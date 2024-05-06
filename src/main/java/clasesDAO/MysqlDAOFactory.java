package clasesDAO;

import interfaces.IntProductos;
import interfaces.IntSesion;
import interfaces.IntVenta;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public IntProductos getProductos() {
		return new DAOProductos();
	}

	@Override
	public IntVenta getVenta() {
		return new DAOVenta();
	}

	@Override
	public IntSesion getSesion() {
		return new DAOSesion();
	}

}
