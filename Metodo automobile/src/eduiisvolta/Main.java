package eduiisvolta;


import java.util.Scanner;

import it.edu.iisvolta.Console;
import it.edu.iisvolta.ConsoleColor;

public class Main {

	public static void main(String[] args) {
		automobile a1= new automobile(0.6f , 60); //consumo medio e capacità serbatoio
		automobile a2= new automobile(0.55f, 55);
		Scanner s= new Scanner(System.in);
		Boolean auto = false;
		int na = 1;
		int km;
		int menù;
			
		do {
			Console.clear();			
			System.out.println("Scegli un opzione dal menù: ");
			System.out.println("1- Cambia automobile,\n2- Effettuare rifornimento,\n3-Percorri km, \n4- Rabbocco Olio, \n5- Manutenzione, \n6-Visualizza Dati,\n9-Esci");
			System.out.println();
			menù = s.nextInt();
			switch(menù) {
			case 1:
				if (auto == false)
					auto = true;
				else
					auto = false;
				if (auto == false) 
					na = 1;
				else
					na = 2;
				break;
			case 2:
				System.out.println("Quanti litri di rifornimento desideri effettuare? ");
				float carburante = s.nextFloat();
				if (na == 1)
					a1.rifornimento(carburante);
				else if (na == 2)
					a2.rifornimento(carburante);
			 break;
			case 3:
			 System.out.println("Quanti km vuoi percorrere?");
				km=s.nextInt();
			if (na == 1)
				a1.percorri(km);
			else if (na == 2)
				a2.percorri(km);
			break;
			case 4:
				if(na == 1)
				a1.rabbocco();
				else
				a2.rabbocco();
				break;
			case 5:
				if(na == 1)
					a1.manutenzione();
					else
					a2.manutenzione();
				break;
			case 6:
				if(na==1) {
					Console.setForegroundColor(ConsoleColor.GREEN);
					System.out.println("Auto 1 in utilizzo: ");
					Console.resetText();
					a1.visualizzadati();
				}else {
					Console.setForegroundColor(ConsoleColor.GREEN);
					System.out.println("Auto 2 in utilizzo: ");
					Console.resetText();
					a2.visualizzadati();
				}
			case 9:
				System.out.println("Arrivederci!");
				break;
			
			default:			
				System.out.println("Errore di digitazione. Perfavore, immettere un valore valido.");
			break;
			}
			System.out.println();
			System.out.println();
		System.out.println("Attendere prego...");	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}while(menù != 9);		
		
		s.close();
	}
}


