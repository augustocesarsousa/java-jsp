package factories;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public abstract class UsuarioFactory {
	
	public static List<Usuario> getUsuarioList(){
		List<Usuario> list = new ArrayList<Usuario>();
		
		list.add(new Usuario("Sylvaro", "Latrial", "11112222", "sylvaro@email.com"));
		list.add(new Usuario("Nemesys", "Jozeiros", "22223333", "nemesys@email.com"));
		list.add(new Usuario("Sebethera", "Cairis", "33334444", "sebethera@email.com"));
		list.add(new Usuario("Timitrion", "Darri", "44445555", "timitrion@email.com"));
		list.add(new Usuario("Natifer", "Matnu", "55556666", "natifer@email.com"));
		list.add(new Usuario("Rymona", "Crale", "66667777", "rymona@email.com"));
		list.add(new Usuario("Demetrio", "Adyarus", "77778888", "demetrio@email.com"));
		list.add(new Usuario("Dromeda", "Yindan", "88889999", "dromeda@email.com"));
		list.add(new Usuario("Bershan", "Yladi", "99990000", "bershan@email.com"));
		list.add(new Usuario("Akra", "Vaer", "00009999", "akra@email.com"));
		list.add(new Usuario("Rhenibelle", "Dithas", "99998888", "rhenibelle@email.com"));
		list.add(new Usuario("Sorina", "Saadin", "88887777", "sorina@email.com"));
		list.add(new Usuario("Aslaois", "Druddeon", "77776666", "aslaois@email.com"));
		list.add(new Usuario("Vania", "Quimmer", "66665555", "vania@email.com.com"));
		list.add(new Usuario("Callister", "Tayne", "55554444", "callister@email.com"));
		
		return list;
	}
}
