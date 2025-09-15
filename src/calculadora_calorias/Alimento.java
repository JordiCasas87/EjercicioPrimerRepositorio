package calculadora_calorias;

public class Alimento {
	
	private int calorias;
	private int proteinas;
	private String nombre;
	
	
	
	public Alimento(int calorias, int proteinas, String nombre) {
		super();
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.nombre = nombre;
	}



	public int getCalorias() {
		return calorias;
	}



	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}



	public int getProteinas() {
		return proteinas;
	}



	public void setProteinas(int proteinas) {
		this.proteinas = proteinas;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return "Alimento [Nombre=" + nombre + " Calorias=" + calorias + ", Proteinas=" + proteinas + ".";
	}
	
	
	
	

}
