package clasesDAO;

import interfaces.IntProductos;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public IntProductos getProductos() {
		return new DAOProductos();
	}

}
