package interfaces;

import java.util.List;

import modelo.Venta;

public interface IntVenta {
	public int crearVenta(Venta venta);
	public List<Venta> listarventa();
	public Venta obtenerVenta(int id);
	public Venta eliminarVenta(int id);
	public int editarVenta(Venta venta);
	public List<Venta> buscarVenta(String cod);
}
