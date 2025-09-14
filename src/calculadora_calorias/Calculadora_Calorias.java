package calculadora_calorias;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora_Calorias {

	static Scanner sc = new Scanner (System.in);
	static ArrayList <Usuario> listaUsuarios = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//calculadora basal, datos necesarios	

		Usuario Jordi = new Usuario ("Jordi","Hombre",38,74,177);
		Usuario Berta = new Usuario ("Berta","Mujer",38,74,177);
		//System.out.println(Jordi.toString());
		Alimento alimento1 = new Alimento (300,23,"Pollo");
		Alimento alimento2 = new Alimento (234,40,"Salmon");
		Alimento alimento3 = new Alimento (139,4,"Melon");
		Alimento alimento4 = new Alimento (190,3,"Tostada");
		Alimento alimento5 = new Alimento (111,22,"Batido");
		Jordi.setListaAlimentos(alimento1);
		Jordi.setListaAlimentos(alimento2);
		Jordi.setListaAlimentos(alimento3);
		Jordi.setListaAlimentos(alimento4);
		Jordi.setListaAlimentos(alimento5);
	
		
		listaUsuarios.add(Jordi);
		listaUsuarios.add(Berta);

		//System.out.println();

		int opcion =0;
		//Usuario usuario = null;

		do {

			System.out.println("\n"
					+ "  \u001B[4m ***- CALCULADORA DE METABOLISMO -***\u001B[0m\n\n"
					+ "1.- Salir \n\n"
					+ "   \u001B[4m Menú Usuarios \u001B[0m \n\n"
					+ "2.- Crear Usuario.\n"
					+ "3.- Mostrar Usuarios. \n\n"
					+ "   \u001B[4m Menú Calculos y objetivos \u001B[0m\n\n"
					+ "4.- Calcular metabolismo Basal.\n"
					+ "5.- Calcular Calorias de mantenimiento.\n"
					+ "6.- Definir objetivo.\n\n"
					+ "    \u001B[4mMenú gestión dieta\u001B[0m\n\n"
					+ "7.- Añadir alimento a lista Usuario. \n"
					+ "8.- Mostrar alimentos diarios de un Usuario.\n"
					+ "9.- Sumar calorias y proteinas de un Usuario.\n ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			
			case 1:
				System.out.println("Adios!");
				break;
				
			case 4:
				System.out.println("Nombre del usuario al que quieres calcular?: ");
				String nombreUsuario =sc.next();
				calcular (nombreUsuario);
				break;
				
			case 2:
				//(String nombre, String sex,int edad,int peso, int altura)
				System.out.println("Introduce el nombre del nuevo Usuario: ");
				String nombre = sc.nextLine();
				System.out.println("Introduce el sexo del nuevo Usuario: ");
				String sexo = sc.nextLine();
				System.out.println("Introduce la edad: ");
				int edad = sc.nextInt();
				System.out.println("Introduce el peso: ");
				int peso = sc.nextInt();
				System.out.println("Introduce la altura: ");
				int altura = sc.nextInt();
				String nuevoUsuario = crearUsuario(nombre,sexo,edad,peso,altura);
				System.out.println(nuevoUsuario);
				break;
				
			case 3:
				System.out.println("---LISTA DE USUARIOS REGITRADOS----\n");
				for (Usuario usuario : listaUsuarios) {
					System.out.println(usuario.toString());
				}
				break;
				
			case 5:
				System.out.println("Introduce nombre usuario para calcular Mantenimiento: ");
				nombre = sc.nextLine();
				calcularMantenimiento(nombre);
				break;
				
			case 6:
				System.out.println("Introduce nombre usuario para definir objetivo: ");
				nombre = sc.nextLine();
				defObjetivo(nombre);
				break;
				
			case 7:
				System.out.println("Introduce nombre usuario para añadir alimento: ");
				nombre = sc.nextLine();
				añadirAlimento(nombre);
				break;
				
			case 8:
				System.out.println("Introduce nombre usuario para ver sus Alimentos: ");
				nombre = sc.nextLine();
				alimentosUsuario(nombre);
				break;
			
			case 9:
				System.out.println("Introduce nombre usuario para ver sus totales: ");
				nombre = sc.nextLine();
				totalUsuario(nombre);
				break;
				
			default:
				System.out.println("Opción incorrecta. Escoge entre el 1 y el 9.");
				
			}
				
		}while (opcion !=1);

	}
	
	//TOTAL USUARIO

	public static void totalUsuario(String nombreUsuario) {
		int posicionUsuario = buscarUsuario(nombreUsuario);
		int totalCalorias=0;
		int totalProteinas=0;

		if (posicionUsuario == -1) {
			System.out.println("Usuario no encontrado!");
		}else {


			Usuario usuarioDef = listaUsuarios.get(posicionUsuario);

			ArrayList <Alimento> listaAlimentos = usuarioDef.getListaAlimentos();

			for (Alimento alimento : listaAlimentos) {
				totalCalorias += alimento.getCalorias();
			}
			for (Alimento alimento : listaAlimentos) {
				totalProteinas += alimento.getProteinas();
			}

			System.out.println("Llevas consumidas: "+totalCalorias+" calorias y: "+totalProteinas+" gr. de proteinas");
			int margenCalorias = (int) (usuarioDef.getCaloriasObjetivo()-totalCalorias);
			System.out.println("Todavia puedes consumir: "+margenCalorias+" calorias hasta el final del día.");
		}
	}



	//MOSTRAR ALIMENTOS USUARIO

	public static void alimentosUsuario (String nombreUsuario) {
		int posicionUsuario = buscarUsuario(nombreUsuario);
		if (posicionUsuario == -1) {
			System.out.println("Usuario no encontrado!");
		}else {
			Usuario usuarioDef = listaUsuarios.get(posicionUsuario);
			if (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()==0.0) {
				System.out.println("Primero debes calcular tu metabolismo basal.");
			}else {
				ArrayList <Alimento> alimentosUsuario = usuarioDef.getListaAlimentos();
				for (Alimento alimento : alimentosUsuario ) {
					System.out.println(alimento.toString());
				}
			}
		}
	}


	//AÑADIR ALIMENTO
	
	public static void añadirAlimento (String nombreUsuario) {
		int posicionUsuario = buscarUsuario(nombreUsuario);
		
		if (posicionUsuario == -1) {
			System.out.println("Usuario no encontrado.");
			
		}else {
			
		Usuario usuarioDef = listaUsuarios.get(posicionUsuario);
		if (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()==0.0) {
			System.out.println("Primero debes calcular tu metabolismo basal.");
			}else {
			System.out.println("Añade el nombre de tu alimento: ");
			String nombre1 = sc.next();
			System.out.println("Añade las calorias de tu alimento: ");
			int calorias = sc.nextInt();
			System.out.println("Añade las proteinas de tu alimento: ");
			int proteinas = sc.nextInt();
			Alimento alimentoAñadido = new Alimento (calorias,proteinas,nombre1);
			usuarioDef.setListaAlimentos(alimentoAñadido);
			}
		}
		
	}

	//DEFINIR OBJETIVO

	public static void defObjetivo (String nombreUsuario) {
		int opcion=0;
		int posicionUsuario = buscarUsuario(nombreUsuario);

		if (posicionUsuario == -1) {
			System.out.println("Usuario no encontrado!");
		}else {


			Usuario usuarioDef = listaUsuarios.get(posicionUsuario);
			if (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()==0.0) {
				System.out.println("Primero debes calcular tu metabolismo basal.");
			}else {
				System.out.println("Escoge tu objetivo:\n"
						+ "1.- Deficit (Adelgazar).\n"
						+ "2.- Mantenimiento. \n"
						+ "3.- Superávit calórico ");

				opcion = sc.nextInt();

				switch (opcion) {

				case 1:
					String deficit = "Deficit";
					float porcentaje = (float) (usuarioDef.getCaloriasMantenimiento()*0.15);
					float total =  usuarioDef.getCaloriasMantenimiento()-porcentaje;
					usuarioDef.setObjetivo(deficit);
					usuarioDef.setCaloriasObjetivo(total);
					System.out.println("Tu objetivo en calorias es: "+String.format("%.2f",total)+".\n");
					break;

				case 2:
					String mantenimiento = "Mantenimiento";
					usuarioDef.setObjetivo(mantenimiento);
					usuarioDef.setCaloriasObjetivo(usuarioDef.getCaloriasMantenimiento());
					System.out.println("Tus calorias para el objetivo de mantenimiento son: "+usuarioDef.getCaloriasMantenimiento()+".\n");
					break;

				case 3:
					String superavit = "Superavit";
					float porcentaje1 = (float) (usuarioDef.getCaloriasMantenimiento()*0.125);
					float total1=  usuarioDef.getCaloriasMantenimiento()+porcentaje1;
					usuarioDef.setObjetivo(superavit);
					usuarioDef.setCaloriasObjetivo(total1);
					System.out.println("Tu objetivo en calorias es: "+String.format("%.2f",total1)+".\n");
					break;

				}	
			}	
		}
	}


	//CALCULAR CALORIAS MANTENIMIENTO
	public static void calcularMantenimiento(String nombreUsuario) {
		int posicionUsuario = buscarUsuario(nombreUsuario);

		if (posicionUsuario == -1) {
			System.out.println("Usuario no encontrado!");
		}else {

			if (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()==0.0) {
				System.out.println("Primero debes calcular tu metabolismo basal.");
			}else {
				System.out.println("Tu metabolismo basal es: " +listaUsuarios.get(posicionUsuario).getMetabolismoBasal()+"\n"
						+ "\n**Indica tu tipo de actividad:**\n\n"
						+ "1.-Sedentario (poco o nada de ejercicio).\n"
						+ "2.-Ligera actividad (ejercicio ligero 1-3 días/semana.\n"
						+ "3.-Actividad moderada (ejercicio moderado 3-5 días/semana).\n"
						+ "4.-Muy activo (ejercicio intenso 6-7 días/semana).\n"
						+ "5.-Extremadamente activo (entrenamientos muy intensos o trabajo físico).\n");

				int opcion = sc.nextInt();

				switch (opcion) {
				case 1: 
					float calculoTotal = (float) (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()*1.2);
					System.out.println("Tu calorias para mantenerte en tu peso son: "+String.format("%.2f",calculoTotal)+".\n");
					listaUsuarios.get(posicionUsuario).setCaloriasMantenimiento(calculoTotal);
					break;
				case 2: 
					float calculoTotal1 = (float) (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()*1.375);
					System.out.println("Tu calorias para mantenerte en tu peso son: "+String.format("%.2f",calculoTotal1)+".\n");
					listaUsuarios.get(posicionUsuario).setCaloriasMantenimiento(calculoTotal1);
					break;
				case 3: 
					float calculoTotal2 = (float) (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()*1.55);
					System.out.println("Tu calorias para mantenerte en tu peso son: "+String.format("%.2f",calculoTotal2)+".\n");
					listaUsuarios.get(posicionUsuario).setCaloriasMantenimiento(calculoTotal2);
					break;
				case 4: 
					float calculoTotal3 = (float) (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()*1.725);
					System.out.println("Tu calorias para mantenerte en tu peso son: "+String.format("%.2f",calculoTotal3)+".\n");
					listaUsuarios.get(posicionUsuario).setCaloriasMantenimiento(calculoTotal3);
					break;
				case 5: 
					float calculoTotal4 = (float) (listaUsuarios.get(posicionUsuario).getMetabolismoBasal()*1.9);
					System.out.println("Tu calorias para mantenerte en tu peso son: "+String.format("%.2f",calculoTotal4)+".\n");
					listaUsuarios.get(posicionUsuario).setCaloriasMantenimiento(calculoTotal4);
					break;
				}
			}
		}
	}


	//CREAR USUARIO
	public static String crearUsuario (String nombre,String sexo,int edad,int peso,int altura) {
		Usuario nuevoUsuario = new Usuario (nombre,sexo,edad,peso,altura);
		String respuesta = "Usuario creado con éxito!";
		listaUsuarios.add(nuevoUsuario);

		return respuesta;		

	}


	//BUSCAR USUARIO
	public static int buscarUsuario (String nombreUsuario) {
		int usuario = -1;
		for (int i=0; i<listaUsuarios.size();i++) {
			if (listaUsuarios.get(i).getNombre().equalsIgnoreCase(nombreUsuario)) {
				usuario = i;
			}
		
		}
		return usuario;
	}

	//CALCULAR BASAL
	public static void calcular (String nombreUsuario) {
		int posicionUsuario = buscarUsuario(nombreUsuario);
		if (posicionUsuario == -1) {
			System.out.println("Imposible calcular!\n");
		}else {
			float metabolismo;
			Usuario usuarioCalculado = listaUsuarios.get(posicionUsuario);
			if (usuarioCalculado.getSex().equalsIgnoreCase("Hombre")) {
				metabolismo =(float) ((10*usuarioCalculado.getPeso())+(6.25*usuarioCalculado.getAltura())
						-(5*usuarioCalculado.getEdad())+5);
			}else {
				metabolismo =(float) ((10*usuarioCalculado.getPeso())+(6.25*usuarioCalculado.getAltura())
						-(5*usuarioCalculado.getEdad())-161);	
			}
			usuarioCalculado.setMetabolismoBasal(metabolismo);
			System.out.println("Tu tasa de metabolismo basal es de "+metabolismo+" calorias.\n");
		}
	}


}
