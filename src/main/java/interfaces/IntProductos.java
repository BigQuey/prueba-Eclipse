package interfaces;

import java.util.List;

import modelo.Producto;

public interface IntProductos {
	public int crearProducto(Producto producto);
	public List<Producto> listarProducto();
	public Producto obtenerProducto(int id);
	public Producto eliminarProducto(int id);
	public int editarProducto(Producto producto);
	public List<Producto> bucarProducto(String cod);	
}
