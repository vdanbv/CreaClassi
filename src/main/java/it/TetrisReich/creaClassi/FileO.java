package it.TetrisReich.creaClassi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class FileO {

	
	public static void loader() throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
		    String line;
		    int st = 0;
		    while ((line = br.readLine()) != null) {
		    	Utils.wait(6);
		    	System.out.print(st);
		    	Utils.backer(Utils.lCalc(st)-1);
		    	processor(line, st);
		    	st++;
		    }
		    System.out.println("");
		    br.close();
		}
	}
	public static void processor(String line, int st){
		StringTokenizer str = new StringTokenizer(line);
		String actual = "";
		//Boolean sesso = false;
        Boolean first = true;
		while (str.hasMoreTokens()) {
	         actual = str.nextToken();
	         if(Utils.isNumber(actual)){
	        	 App.competenze[st] = Integer.parseInt(actual);
	        	 App.sesso[st] = str.nextToken().charAt(0);
	         } else {
	        	 //System.out.println(first);
	        	 //System.out.println(st);
	        	 if(first==true){App.nome[st] = actual;first=false;} else {App.nome[st] =App.nome[st]+" "+ actual;}
	        	 //System.out.println(App.nome[st]);
	        	 }
	     }
		//System.out.println(App.nome[st]);
	}
	public static Boolean data(){
		System.out.print(" Testing if \"data.txt\" esist... ");
		File f = new File("data.txt");
    	if(f.exists()&&!f.isDirectory()){System.out.print("");}else{
    		System.out.print("Not found! ");
    		newFile("data.txt");
    		return false;
    	}
    	Utils.wait(763);
    	System.out.println(" Done!");
    	return true;
	}
	public static void output() throws IOException{
		System.out.print(" Testing if \"Output.txt\" esist...");
		File f = new File("Output.txt");
    	if(f.exists()&&!f.isDirectory()){System.out.print("");}else{newFile("Output.txt");}
    	Utils.wait(763);
    	System.out.print(" Done!");
    	Utils.wait(349);
    	Utils.backer(38);
    	System.out.print(" Costruzione dell'output. Please wait...");
    	Utils.fileCostructor();
	}
	public static Boolean newFile(String path){
    	File file = new File(path);
    	boolean blnCreated = false;
        try{
          blnCreated = file.createNewFile();
        } catch(IOException ioe) {
        	System.out.println("Error while creating a new empty file :" + ioe);
        }
        //System.out.println(blnCreated);
        return blnCreated;
    }
	public static void writer(String text, String path){
    	
    }
}