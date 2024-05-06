package modelo;

public class Cliente extends Usuario {
	private int idCliente;
	
	
	public Cliente(String nombre, String apellido, String dni, int idCliente) {
		super(nombre, apellido, dni);
		this.idCliente = idCliente;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	
}
