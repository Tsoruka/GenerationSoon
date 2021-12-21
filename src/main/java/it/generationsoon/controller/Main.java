package it.generationsoon.controller;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//squadra, campionato; 
		//metodo che dopo aver generato un numero con Math.Random()  
		//deve recuperarmi l'elemento nell'arrayList in  posizione che corrisponde al numero generato
		double random = Math.random();
		//System.out.print(random);
		
		
        
        Negozio negozio = new Negozio();
        Prodotto p1 = new Prodotto();
        p1.setCodice(23);
        Prodotto p2 = new Prodotto();
        p2.setCodice(2);
        Prodotto p3 = new Prodotto();
        p3.setCodice(7);
        Prodotto p4 = new Prodotto();
        p4.setCodice(9);
        Prodotto p5 = new Prodotto();
        p5.setCodice(45);
        List<Prodotto> lista = new ArrayList<Prodotto>();
        lista.add(p5);
        lista.add(p3);
        lista.add(p1);
        lista.add(p4);
        lista.add(p2);
        negozio.setProdotti(lista);
        
        
        List<Integer> numeri = new ArrayList<Integer>();
        numeri.add(23);
        numeri.add(137);
        numeri.add(90);
        numeri.add(45);
        numeri.add(3);
        
        int massi = numeri.size();
        int min = 0; 
        int range = massi - min;
        
        int rand = (int)(Math.random() * range) + min;
        
        for(int i = 0; i < massi; i++) {
        	if(i == rand) {
        		System.out.println("Posizione array:" + i);
        		System.out.println("Random generato:" + rand);
        		System.out.println(numeri.get(i));
        	}
        }
        //int rand = getPosix();

	}
	
	public static int getPosix() {
		// define the range
		int rand = 0;
        int max = 5;
        int min = 1;
        int range = max - min + 1;
  
        // generate random numbers within 1 to 10
        //for (int i = 0; i < max; i++) {
            rand = (int)(Math.random() * range) + min;
  
            // Output is different everytime this code is executed
            //System.out.println(rand);
        //}
        return rand;
	}

}
