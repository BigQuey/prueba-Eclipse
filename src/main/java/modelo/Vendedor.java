package modelo;

public class Vendedor extends Usuario {
	private int idVendedor;
	private String codVendedor;
	private String direccion;
	private String correo;
	private String contraseña;
	

	
	public Vendedor(String nombre, String apellido, String dni, int idVendedor, String codVendedor, String direccion,
			String correo, String contraseña) {
		super(nombre, apellido, dni);
		this.idVendedor = idVendedor;
		this.codVendedor = codVendedor;
		this.direccion = direccion;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(String codVendedor) {
		this.codVendedor = codVendedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
