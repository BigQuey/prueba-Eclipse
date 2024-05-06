package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletProducto() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		switch(type) {
			case "listar": listarProducto(request, response); break;
			case "registrar": registrarProducto(request, response); break;
			case "nuevo": nuevoProducto(request, response); break;
			case "info": obtenerProducto(request, response); break;
			case "infoEdit": obtenerProductoEdit(request, response); break;
			case "editar": editarProducto(request, response); break;
			case "eliminar": eliminarProducto(request, response); break;
			case "buscar": buscarProducto(request, response); break;
			default:
				request.setAttribute("mensaje", "Ocurrió un problema");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
		}
	}
	
	protected void listarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void nuevoProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void obtenerProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void obtenerProductoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void editarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void buscarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
