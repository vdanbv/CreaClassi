package it.TetrisReich.creaClassi;

import java.io.FileNotFoundException;
import java.io.IOException;

import it.TetrisReich.creaClassi.FileO;
import it.TetrisReich.creaClassi.Utils;
import it.TetrisReich.creaClassi.Cc;

public class App{
	
	public static String[] nome;
	public static int[] competenze;
	public static char[] sesso;
	public static byte[] Cclasse;
	public static byte[] SNclasse;
	
    public static void main(String[] args) throws FileNotFoundException, IOException{
    	System.out.println("Ciao! Benvenuto nel mio programma! Creato da Luca Sorace Stranck.");
    	Utils.wait(250);
    	System.out.println("Sto inizializzando gli array...");
    	if(Utils.inArray()==false) return;
    	System.out.print("Sto leggendo la lista delle persone: ");
    	Utils.wait(537);
    	FileO.loader();
    	Cc.divisor();
    	Utils.wait(699);
    	System.out.print("Preparing output...");
    	FileO.output();
    	Utils.wait(201);
    	System.out.println("Grazie per aver usato il mio programma! :D");
    	Utils.wait(1100);
    }
}
