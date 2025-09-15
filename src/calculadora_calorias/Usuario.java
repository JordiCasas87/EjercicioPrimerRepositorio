package calculadora_calorias;

import java.util.ArrayList;

public class Usuario {

	/*
	 *  Datos básicos necesarios
Sexo (hombre o mujer) → influye en la fórmula.
Edad → el metabolismo disminuye con la edad.
Peso (en kg) → más masa corporal = mayor gasto.
Altura (en cm) → más altura = mayor gasto energético.
	 * 
	 */
	
	//atributos
	
	private String nombre;
	private String sex;
	private int edad;
	private int peso;
	private int altura;
	private float metabolismoBasal =0;
	private float caloriasMantenimiento =0;
	private String objetivo = "No definido.";
	private float caloriasObjetivo;
	private ArrayList <Alimento> listaAlimentos;
	
	//constructor
	
	public Usuario (String nombre, String sex,int edad,int peso, int altura) {
		this.nombre = nombre;
		this.sex = sex;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.listaAlimentos = new ArrayList <Alimento>();
	}

	//getter y setter
	
	
public ArrayList<Alimento> getListaAlimentos() {
		return listaAlimentos;
	}

	public void setListaAlimentos(Alimento alimento) {
		this.listaAlimentos.add(alimento);
	}
	
	
	
	public String getSex() {
		return this.sex;
	}

	

	public float getCaloriasObjetivo() {
		return caloriasObjetivo;
	}

	public void setCaloriasObjetivo(float total) {
		this.caloriasObjetivo = total;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public float getCaloriasMantenimiento() {
		return this.caloriasMantenimiento;
	}

	public void setCaloriasMantenimiento(float caloriasMantenimiento) {
		this.caloriasMantenimiento = caloriasMantenimiento;
	}

	public float getMetabolismoBasal() {
		return this.metabolismoBasal;
	}

	public void setMetabolismoBasal(float metabolismoBasal) {
		this.metabolismoBasal = metabolismoBasal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return this.altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Usuario= "+this.nombre+ " Sex=" + this.sex + "\nEdad=" + this.edad + 
				", Peso=" + this.peso + "\nAltura=" + this.altura + " Metabolismo Basal = "+this.metabolismoBasal+ ".\n"
						+ "Tus calorias de mantenimiento son: "+String.format("%.2f",this.caloriasMantenimiento)+".\n"
								+ "Objetivo = "+this.objetivo+" con un máximo de: "+String.format("%.2f",this.caloriasObjetivo)+" calorias.\n";
	}
	
	
	
	
	
	
}
