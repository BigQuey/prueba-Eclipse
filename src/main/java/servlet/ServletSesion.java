package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clasesDAO.DAOFactory;
import interfaces.IntSesion;
import modelo.Vendedor;
import util.Constantes;
import util.SessionProject;


@WebServlet("/ServletSesion")
public class ServletSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletSesion() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type.equals("login")) {
			String correo = request.getParameter("txtCorreo");
			String clave = request.getParameter("txtPassword");
			
			DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			IntSesion dao = daoFactory.getSesion();
			
			Vendedor usuario = dao.verificarInicioSesion(correo, clave);
			if(usuario !=null) {
				SessionProject sessionProject = new SessionProject();
				sessionProject.saveSessionTimeout(request, 30);
				sessionProject.saveSessionString(request, Constantes.NAME, usuario.getNombre());
				sessionProject.saveSessionString(request, Constantes.LASTNAME, usuario.getApellido());
				sessionProject.saveSessionString(request, Constantes.EMAIL, usuario.getCorreo());
				
				HttpSession session = request.getSession();
				session.setAttribute("correo", correo);
				
				response.sendRedirect("inicio.jsp");
			}else {
				request.setAttribute("mensaje", "No existe Usuario y/o clave");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if(type.equals("logout")) {
			SessionProject sessionProject = new SessionProject();
			sessionProject.invalidateSession(request);
			response.sendRedirect("login.jsp");
		}

	}

}
