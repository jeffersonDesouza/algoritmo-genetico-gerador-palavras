
public class Consoante extends Letra  {	
	
	private char id;
	private byte cod;
	
	public Consoante(char id) {		
		this.id = id;
		cod = 1;		
	}
		
	public char getId() {
		return id;
	}
	public byte getCod() {
		return cod;
	}
	
	public String toString() {
		return "Vogal [id=" + id + ", cod=" + cod + "]";
	}
	

}
