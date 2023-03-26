package bibliotecaHBT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	System.out.println("Hola");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String estado = request.getParameter("estado");
		String id = request.getParameter("id");
		String del = request.getParameter("del");
		if(estado!=null && id!=null) {
			Libro lib = grabaDatos.cogerLibro(id);
			grabaDatos.updateEstado(estado, lib);
		}
		if(del!=null&&del.equals("borrar")) {
			String iddel = request.getParameter("iddel");
			grabaDatos.delLibro(iddel);
		}
		List<Genero> generos = grabaDatos.generosSQL();
		request.setAttribute("listag", generos);
		
		String pasar = request.getParameter("otra");
		
		if(pasar!=null&&pasar.equals("holi")) {
			request.getRequestDispatcher("nuevoLibro.jsp").forward(request, response);	
		}else if(pasar!=null&&pasar.equals("atras")) {
			request.getRequestDispatcher("verlibros.jsp").forward(request, response);	
		}else {
			request.getRequestDispatcher("verlibros.jsp").forward(request, response);	
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String add = request.getParameter("accion");
		String titulo = request.getParameter("ntitulo");
		String genero = request.getParameter("ngenero");
		List<Genero> generos = grabaDatos.generosSQL();
		request.setAttribute("listag", generos);
		
		if(add!=null&&add.equals("addlibros")) {
			grabaDatos.insertLibro(titulo, genero);
		}
		if(add!=null&&add.equals("add2libros")) {
			String titulo2 = request.getParameter("n2titulo");
			String genero2 = request.getParameter("n2genero");
			String otrogen = request.getParameter("ngen");
			if(genero2.equals("0")) {
				grabaDatos.insertGenero(otrogen);
				Genero gen = grabaDatos.cogerGeneroNom(otrogen);
				grabaDatos.insertLibro(titulo2,""+gen.getId_genero()+"");
			}else {
				Genero gen = grabaDatos.cogerGenero(genero2);
				grabaDatos.insertLibro(titulo2,""+gen.getId_genero()+"");
			}
			
			
			List<Genero> geneross = grabaDatos.generosSQL();
			request.setAttribute("listag", geneross);
			request.getRequestDispatcher("nuevoLibro.jsp").forward(request, response);
			
		}
		
		doGet(request, response);
	}

}
