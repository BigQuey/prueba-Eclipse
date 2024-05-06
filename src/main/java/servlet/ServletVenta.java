package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletVenta")
public class ServletVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletVenta() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		switch(type) {
			case "listar": listarVenta(request, response); break;
			case "registrar": registrarVenta(request, response); break;
			case "nuevo": nuevoVenta(request, response); break;
			case "info": obtenerVenta(request, response); break;
			case "infoEdit": obtenerVentaEdit(request, response); break;
			case "editar": editarVenta(request, response); break;
			case "eliminar": eliminarVenta(request, response); break;
			case "buscar": buscarVenta(request, response); break;
			default:
				request.setAttribute("mensaje", "Ocurrió un problema");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
		}
	}
	protected void listarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void registrarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void nuevoVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void obtenerVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void obtenerVentaEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void editarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void eliminarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void buscarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
