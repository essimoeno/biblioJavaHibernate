package bibliotecaHBT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class grabaDatos {
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	
	public static void abrirConexion(){
		
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}
	
	public static void grabarLibro(Libro lib){
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		
		sesion.save(lib);
		t.commit();
		sesion.close();
		
	}
	
	public static List<Libro> recuperarLibros(){
		abrirConexion();
	
		Session sesion=sf.openSession();
		String hql = "FROM Libro"; //nombre de LA CLASE, NO DE LA TABLA
		Query q=sesion.createQuery(hql);//SQL: Select... from TABLA
												//JPQL: form Entidad
		List<Libro> libros=(List<Libro>)q.getResultList();
		sesion.close();
		return libros;
		
	}
	
	public static void delLibro(String id) {
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t= sesion.beginTransaction();
		Libro li = cogerLibro(id);
		sesion.delete(li);
		t.commit();
		sesion.close();
	}
	
	public static Libro cogerLibro(String id) {
		abrirConexion();
		
		Session sesion=sf.openSession();
		String hql = "FROM Libro WHERE id="+id; //nombre de LA CLASE, NO DE LA TABLA
		Query q=sesion.createQuery(hql);//SQL: Select... from TABLA
												//JPQL: form Entidad
		Libro libros=(Libro) q.getSingleResult();
		sesion.close();
		return libros;
	}
	
	
	public static Genero cogerGenero(String id) {
		abrirConexion();
		
		Session sesion=sf.openSession();
		String hql = "FROM Genero WHERE id_genero="+id; //nombre de LA CLASE, NO DE LA TABLA
		Query q=sesion.createQuery(hql);//SQL: Select... from TABLA
												//JPQL: form Entidad
		Genero gen=(Genero) q.getSingleResult();
		sesion.close();
		return gen;
	}
	public static Genero cogerGeneroNom(String nom) {
		abrirConexion();
		
		Session sesion=sf.openSession();
		String hql = "FROM Genero WHERE nombre='"+nom+"'"; //nombre de LA CLASE, NO DE LA TABLA
		Query q=sesion.createQuery(hql);//SQL: Select... from TABLA
												//JPQL: form Entidad
		Genero gen=(Genero) q.getSingleResult();
		sesion.close();
		return gen;
	}
	
	public static void updateEstado(String estado, Libro lib) {
		
		if(estado.equals("disponible")) {
			estado="prestado";
		}else {
			estado="disponible";
		}
		lib.setEstado(estado);
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		sesion.update(lib);
		t.commit();
		sesion.close();
		
	}
	
	
	public static void insertLibro(String titulo,String id_genero) {
		abrirConexion();
		Libro lib = new Libro();
		lib.setId_genero(id_genero);
		lib.setTitulo(titulo);
		lib.setEstado("disponible");
		 Session sesion=sf.openSession();
    	 Transaction t=sesion.beginTransaction();
    	 sesion.save(lib);
    	 t.commit();
    	 sesion.close();
	}
	
	public static void insertGenero(String genero) {
		abrirConexion();
		Genero gen = new Genero();
		gen.setNombre(genero);
		 Session sesion=sf.openSession();
    	 Transaction t=sesion.beginTransaction();
    	 sesion.save(gen);
    	 t.commit();
    	 sesion.close();
		
	}
	
	public static List<Genero> generosSQL(){
		abrirConexion();
		
		Session sesion=sf.openSession();
		String hql = "FROM Genero"; //nombre de LA CLASE, NO DE LA TABLA
		Query q=sesion.createQuery(hql);//SQL: Select... from TABLA
												//JPQL: form Entidad
		List<Genero> generos=q.getResultList();
		sesion.close();
		return generos;
		
	}
	
	
	
	
}
