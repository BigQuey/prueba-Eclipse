package interfaces;

import modelo.Vendedor;

public interface IntSesion {
	public Vendedor verificarInicioSesion(String correo, String clave);
}
