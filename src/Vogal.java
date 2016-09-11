public class Vogal extends Letra {

	private char id;
	private byte cod;
		
	public Vogal(char id) {
		
		this.id = id;
		cod = 0;		
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
