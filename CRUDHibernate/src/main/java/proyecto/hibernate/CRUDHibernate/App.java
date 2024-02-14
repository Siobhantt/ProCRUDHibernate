package proyecto.hibernate.CRUDHibernate;

import java.util.Scanner;

public class App {
	public static Scanner lee = new Scanner(System.in);
  public static void main(String[] args) {
    int opcPrincipal = 0;
	Utils.mensajeInicial();
	  
	opcPrincipal = lee.nextInt();
	lee.nextLine();
	
	while (opcPrincipal!=0) {
		switch (opcPrincipal) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
	
			break;
		case 4:
	
			break;
			
			default:
				System.out.println("La opcion introducida no está contemplada.");
		}//Fin del switch
	}
    
  }
}
