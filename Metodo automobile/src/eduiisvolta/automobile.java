package eduiisvolta;

import java.util.Random;

import it.edu.iisvolta.Console;
import it.edu.iisvolta.ConsoleColor;

public class automobile {
		private int kmPercorsi; // memorizzata nella classe
		private float litricarburante; //attributo
		private float consumomedio;
		private int capacit�serbatoio;
		private boolean spiaOlio;
		private boolean spiaMotore;
		Boolean contr = false;
		Random r = new Random();
		
		/*public automobile() {
			capacit�serbatoio= r.nextInt(80);
			kmPercorsi=0;
			litricarburante = r.nextFloat(capacit�serbatoio);
		}
		*/
		public automobile(float consumomedio, int capacit�serbatoio) {
			super();
			//imposto gli attributi parametrici (forniti dall'utilizzatore della classe in fase di costruzione dell'oggetto)
			if (consumomedio <= 0) {
				System.out.println("Consumo medio non valido");
				this.consumomedio = 0.5f; //valore predefinito
			}
			else
				this.consumomedio = consumomedio;
			if (capacit�serbatoio<= 0) {
				System.out.println("Capacit� serbatoio non valida");
				this.capacit�serbatoio = 50;
			}
			else
				this.capacit�serbatoio = capacit�serbatoio;
			
			kmPercorsi = 0;
			litricarburante = 0;
			spiaOlio = false;
			spiaMotore = false;
		}
		
		public void percorri(int km) { //metodo parametrico
			float consumo = km * consumomedio;
			if (contr == false){
				if (consumo>litricarburante)
					System.out.println("Carburante insufficente per percorrere " +km+ "km");
				else { 
					if(spiaOlio == true || spiaMotore == true) {
						Console.setForegroundColor(ConsoleColor.RED);
						System.out.println("Errore! Manutenzione necessaria!");
						Console.resetText();
					}
					else {
				kmPercorsi= kmPercorsi + km;
				litricarburante -= consumo;			
				int test = r.nextInt(10);	
				if (test == 8)
					spiaOlio = true;
				else if (test == 9)
					spiaMotore = true;
					}
			} 
			}else {
				Console.setForegroundColor(ConsoleColor.RED);
				System.out.println("Errore! Consumo medio non valido.");
				Console.resetText();
			}
		}		
		
		public void visualizzadati() { //metodo non parametrico
			System.out.println("kmPercorsi: "+kmPercorsi);
			System.out.println("Litri carburante residui: " + litricarburante + "litri");
			System.out.println("Capacit� serbatoio: " + capacit�serbatoio);
			System.out.println("Consumo medio: "+ consumomedio);
			if(spiaMotore == true) {
				Console.setForegroundColor(ConsoleColor.RED);
			System.out.println("Spia motore accesa!");
				Console.resetText();
			}else
				{Console.setForegroundColor(ConsoleColor.GREEN);
				System.out.println("Spia motore spenta");
				Console.resetText();
				}
			if(spiaOlio == true) {
				Console.setForegroundColor(ConsoleColor.RED);
				System.out.println("Spia olio accesa!");
				Console.resetText();
			}else {
				Console.setForegroundColor(ConsoleColor.GREEN);
				System.out.println("Spia olio spenta");
				Console.resetText();
				}
		}
		public void rifornimento (float carburante) { // l'int � una variabile temporanea		
			if (litricarburante + carburante> capacit�serbatoio) {
				Console.setForegroundColor(ConsoleColor.RED);
				System.out.println("Errore! Soglia massima superata");
				Console.resetText();
			}else 
				litricarburante += carburante;
				Console.setForegroundColor(ConsoleColor.GREEN);
				System.out.println("Rifornimento effettuato.");
				Console.resetText();
		}
		public void manutenzione () {
		spiaMotore = false;
		System.out.println("Manutenzione effettuata.");
		}
		public void rabbocco () {
		spiaOlio = false;
		System.out.println("Rabbocco effettuato.");
		}
		public void setconsumomedio(float consumomedio) {
			if (consumomedio <= 0 || consumomedio > 2) {
				Console.setForegroundColor(ConsoleColor.RED);
				System.out.println("Valore non valido!");
				Console.resetText();
				contr = true;
			}else {
			 this.consumomedio = consumomedio;
			contr = false;
			}
		}
		public float getConsumomedio() {
			return consumomedio;
		}
		public int getCapacit�serbatoio() {
			return capacit�serbatoio;
		}
		public float getLitricarburante() {
			return litricarburante;
		}
	}
	

