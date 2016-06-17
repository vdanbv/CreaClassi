package it.TetrisReich.creaClassi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class NomiACaso {
	public static void caso() throws IOException{
		File fout = new File("data.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		Random generator = new Random();
		String result = "";
		int rand = 0;
		for(int intg=0;intg<117;intg++){
		nome = "";
		for(int in=0;in<2;in++){
			for(int i=0;i<6;i++){
				rand = 97 + generator.nextInt(26);
				add(Character.toString ((char)rand));
			}
			nome = nome + " ";
		}
		result = nome +" "+ generator.nextInt(5);
		String s;
		if(generator.nextBoolean()==true)s="m"; else {s="f";}
		result = result+" "+s;
		System.out.println(result);
		bw.write(result);
		bw.newLine();
		}
		bw.close();
	}
	public static void add(String st){
		nome = nome + st;
	}
	public static String nome = "";
}
