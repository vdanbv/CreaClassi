package it.TetrisReich.creaClassi;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Utils {
	public static int lLenght = 0;
	public static int lCalc(int n){
		return String.valueOf(n).length();
	}
	public static void finder(int comp, char sex, int nRet){
		int i = 0;
		int nRetM = nRet;
		while(nRetM!=0){
			if(i>=App.competenze.length||i>=App.sesso.length)return;
			if(App.competenze[i]==comp&&App.sesso[i]==sex){operation(i);nRetM--;}
			i++;
			lLenght = String.valueOf(i).length();
			lLenght = lLenght + 7;
			backer(lLenght);
		}
	}
	public static void operation(int data){
		classApplier(data);
	}
	public static Boolean haveAClass(int i){
		int test = 7;
		if(test==8)System.out.println("solo per togliermi in warning");
	    try{ test = App.SNclasse[i]; }
	    catch(java.lang.NullPointerException e){ return false; }
		return true;
	}
	public static Boolean classType; //true: SN, flase: C
	public static byte classBank;	
	public static void classApplier(int i){
		System.out.println("appling for " + classBank);
		if(classType==true){
			App.SNclasse[i] = classBank;
			System.out.println(App.SNclasse[i]);
			System.out.println(Arrays.toString(App.SNclasse));
		} else {App.Cclasse[i] = classBank;}
	}
	public static boolean isNumber(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	public static void fileCostructor() throws IOException{
		System.out.print(" Preparing file...");
		File fout = new File("OutPut.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		wait(670);
		System.out.println(" Done!");
		System.out.println("Output:\n\n");
		wait(613);
		for(byte in=1;in<=5;in++){
			System.out.println("Classe numero: "+in+"\n");
			bw.write("Classe numero: "+in+"\n");
			bw.newLine();
			for(int intg=0;intg<App.SNclasse.length;intg++){
				wait(8);
				if(App.Cclasse[intg]==(byte)in){
					wait(17);
					System.out.println(App.nome[intg]+" ("+App.sesso[intg]+"; "+ App.competenze[intg] +")");
					bw.write(App.nome[intg]+" ("+App.sesso[intg]+"; "+ App.competenze[intg] +")");
					bw.newLine();
				}
			}
			wait(132);
			System.out.println("\n\n---");
			bw.write("\n\n---");
			bw.newLine();
		}
		wait(44);
		System.out.println("Alunni da inserire a mano:\n");
		bw.write("Alunni da inserire a mano:\n");
		bw.newLine();
		int count = 0;
		for(int i=0;i<App.SNclasse.length;i++){
			wait(8);
			if(App.Cclasse[i]==(byte)0){
				wait(21);
				count++;
				System.out.println(App.nome[i]+" ("+App.sesso[i]+"; "+App.competenze[i]+")");
				bw.write(App.nome[i]+" ("+App.sesso[i]+"; "+App.competenze[i]+")");
				bw.newLine();
			}
		}
		System.out.println("("+count+")");
		bw.write("("+count+")");
		bw.newLine();
		if(count==0){
			System.out.println("//");
			bw.write("//");
			bw.newLine();
		}
		bw.close();
		wait(381);
		System.out.println("\n\nOutput... Done!\nLe classi sono state salvate in\"Output.txt\".");
	}
	public static Boolean inArray() throws IOException{
		if(FileO.data()==false){
			System.out.println("Prego inserire in \"data.txt\" i dati degli alunni in questo modo:\n"
					+ "[Nome e cognome alunno] [livello d'apprendimento(0-5)] [Sesso(m/f)]");
			return false;
		}
		wait(324);
		System.out.print("Leggendo il numerdo di studenti...");
		int ln = countLines("data.txt");
		wait(437);
		ln++;
		System.out.println(ln);wait(173);
		App.nome = new String[ln];
		App.competenze = new int[ln];
		App.sesso = new char[ln];
		App.Cclasse = new byte[ln];
		App.SNclasse = new byte[ln];
		return true;
	}
	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	public static void wait(int time){
		try{
		    Thread.sleep(time);
		} catch(InterruptedException ex){
		    Thread.currentThread().interrupt();
		}
	}
	public static void backer(int n){
		for(int i=0;i<=n;i++){
			System.out.print("\b");
		}
	}
}
