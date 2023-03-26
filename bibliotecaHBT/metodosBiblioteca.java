package bibliotecaHBT;

import java.util.List;

public class metodosBiblioteca {

	public metodosBiblioteca() {
		// TODO Auto-generated constructor stub
	}
	
	public static String pintarTabla() {
		List<Libro> libros = grabaDatos.recuperarLibros();
		String tabla="";
			if(libros!=null){
			
				for(int i=0;i<libros.size();i++){
					Genero gen = grabaDatos.cogerGenero(libros.get(i).getId_genero());
					
					String estado = libros.get(i).getEstado();
					
					tabla+="<tr><td>"+libros.get(i).getTitulo()+"</td>";
					tabla+="<td>"+gen.getNombre()+"</td>";
					
					//Se puede hacer el input tipo hidden
					//<input type='hidden' name='estado' value='disponible'>
					// y esos valores se envían con un submit
					if(estado.equals("disponible")){
						tabla+="<td><a href='MiServlet?estado=disponible&id="+libros.get(i).getId()+"' style='color:lightgreen'>Prestar</a></td>";
					}else{
						tabla+="<td><a href='MiServlet?estado=prestado&id="+libros.get(i).getId()+"' style='color:salmon'>Devolver</a></td>";
					}
					tabla+="<td><a href='MiServlet?del=borrar&iddel="+libros.get(i).getId()+"'><img src='basura.png' width=30px></a></td></tr>";
				}
		}
		return tabla;
	}
	
	public static String pintarGeneros(List<Genero> generos) {
		String tabla="";
			if(generos!=null){
				for (int i = 0; i < generos.size(); i++) {
					tabla+="<option value=" + generos.get(i).getId_genero() + " id=" + generos.get(i).getId_genero() + ">" + generos.get(i).getNombre() + "</option>";
				}
				
		}
		return tabla;
	}

}
