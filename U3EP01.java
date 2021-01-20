package tema3;
import java.util.Scanner;
				CAMBIO EN EL ARCHIVO
public class U3EP01 {

public static void main(String[] args) {
	Scanner teclado = new Scanner (System.in);
int eleccion;
String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String alfabeto = alfa;
do {	
	System.out.println(" ");
	System.out.println("CRIPTOGRAFIA CESAR ");
	System.out.println(" ");
	System.out.println("1. Configurar.");
	System.out.println("2. Encriptar.");
	System.out.println("3. Desencriptar.");
	System.out.println("4. Salir.");
	System.out.println(" ");
	System.out.println("Escoja una opción");
	
	eleccion = teclado.nextInt();

	//OPCION 1
	if (eleccion == 1) {
		teclado.nextLine();
		boolean centinela = false;
		System.out.println("\nCRIPTOGAFIA CESAR-CONFIGURAR");
		System.out.println(" ");
		while (centinela == false) {
		System.out.print("Alfabeto actual: "+alfabeto);
		System.out.print("\nMódulo actual: "+alfabeto.length());
		System.out.print("\nNuevo alfabeto (enter para no cambiar):" );
		String actual = alfabeto;
		alfabeto = teclado.nextLine();
		if (alfabeto.equals("")) {
			alfabeto = actual;
		}
		for (int i=0; i < alfabeto.length(); i++) {
			for (int j=i+1; j < alfabeto.length(); j++) {
				if (alfabeto.charAt(i) == alfabeto.charAt(j)) {
					centinela = false;
					System.out.printf("%25s","Tiene letras repetidas\n");
					System.out.println("");
				}else {centinela = true;}			
			}
		}

		}
		
		
		System.out.println("Módulo actual: "+alfabeto.length());
		System.out.printf("%36s","Pulsa ENTER para volver al menú.");
		try{System.in.read();}catch(Exception e){e.printStackTrace();}
		
	}

	//OPCION 2
	if (eleccion == 2) {
		teclado.nextLine();
		String res = "";
		System.out.println("\nCRIPTOGAFIA CESAR-ENCRIPTAR");
		System.out.println(" ");
		int clave = 0;
			do {
			System.out.print("Clave (1-36): ");
			clave = teclado.nextInt();
			}while (clave < 1 || clave > 36);
			teclado.nextLine();
		System.out.print("Texto en claro: ");
		String texto = teclado.nextLine();
		
		//ELIMINAR LETRAS REPETIDAS
		for (int i=0; i < texto.length(); i++) {
			for (int j=0; j < alfabeto.length(); j++) {
				if (texto.charAt(i) == alfabeto.charAt(j) ) {
					res = res+texto.charAt(i);
				}

			}
		}
		String encriptada ="";
		String resultado="";	
		System.out.printf("%29s","Texto Filtrado: "+res);
		for (int i=0; i< res.length(); i++) {
			char pos = res.charAt(i);
			//CONSEGUIR QUE DESPUES DE LA Z VUELVA A LA A
			if (alfabeto.indexOf(pos) + clave >= alfabeto.length() ) {
				encriptada = encriptada + alfabeto.charAt(alfabeto.indexOf((pos-alfabeto.length())+clave));
			}else {
			encriptada = encriptada + alfabeto.charAt(alfabeto.indexOf(pos)+clave);
		}}
		System.out.printf("\n%29s","Texto cifrado: "+encriptada+"\n");
		System.out.printf("%36s","Pulsa ENTER para volver al menú.");
		try{System.in.read();}catch(Exception e){e.printStackTrace();}
		}

	//OPCION 3
	if (eleccion == 3) {
		teclado.nextLine();
		String res = "";
		System.out.println("\nCRIPTOGAFIA CESAR-DESENCRIPTAR");
		System.out.println(" ");
		int clave = 0;
			do {
			System.out.print("Clave (1-36): ");
			clave = teclado.nextInt();
			}while (clave < 1 || clave > 36);
			teclado.nextLine();
		System.out.print("Texto Cifrado:");
		String texto = teclado.nextLine();
		
		for (int i=0; i < texto.length(); i++) {
			for (int j=0; j < alfabeto.length(); j++) {
				if (texto.charAt(i) == alfabeto.charAt(j) ) {
					res = res+texto.charAt(i);
				}

			}
		}
		String encriptada ="";
		String resultado="";	
		System.out.printf("%29s","Texto Filtrado: "+res);
		for (int i=0; i< res.length(); i++) {
			char pos = res.charAt(i);
			//CONSEGUIR QUE DESPUES DE LA A VUELVA A LA Z
			if (alfabeto.indexOf(pos) - clave < 0 ) {
				encriptada = encriptada + alfabeto.charAt(alfabeto.indexOf((pos+alfabeto.length())-clave));
			}else {
			encriptada = encriptada + alfabeto.charAt(alfabeto.indexOf(pos)-clave);
		}		}
		System.out.printf("\n%30s","Texto en claro: "+encriptada+"\n");
		System.out.printf("%36s","Pulsa ENTER para volver al menú.");
		try{System.in.read();}catch(Exception e){e.printStackTrace();}
		}
	

}while (eleccion != 4);
	}

}
