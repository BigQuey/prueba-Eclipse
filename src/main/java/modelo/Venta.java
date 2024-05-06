package modelo;

public class Venta {
	private int idVenta;
	private String codCliente;
	private String codVendedor;
	private int total;
	private int cantProductos;
	private String producto;
	private String fechaCompra;
	private String metodoPago;
	private String codVenta;
	public String getCodVenta() {
		return codVenta;
	}
	public void setCodVenta(String codVenta) {
		this.codVenta = codVenta;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getCodVendedor() {
		return codVendedor;
	}
	public void setCodVendedor(String codVendedor) {
		this.codVendedor = codVendedor;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantProductos() {
		return cantProductos;
	}
	public void setCantProductos(int cantProductos) {
		this.cantProductos = cantProductos;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
}
