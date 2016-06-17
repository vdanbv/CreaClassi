package it.TetrisReich.creaClassi;

import java.util.Arrays;

public class Cc {
	public static int[] m = new int[6];
	public static int[] f = new int[6];
	public static int p = 0;
	public static void divisor(){
    	System.out.println("Dividendo le competenze:  ");
		for(int i=0;i<=5;i++){
			m[i] = counter('m',(byte)i) / 5;
			f[i] = counter('f',(byte)i) / 5;
		}
		Utils.wait(32);
		System.out.println(Arrays.toString(m));
		System.out.println(Arrays.toString(f));
		Utils.wait(491);
    	System.out.print("Dividendo gli studenti nelle classi:  ");
		App.Cclasse[0] = 6;
		for(int i=0;i<=5;i++){//intelligienza
			for(byte c=1;c<=5;c++){//classe
				p = 0;
				for(int s=0;s<App.nome.length;s++){//cerca nella lista i maschi con tot intelligienza
					System.out.print("C"+App.competenze[s]+"S"+App.sesso[s]+"A"+App.Cclasse[s]+"i"+i+"p"+p+"c"+c+"s"+s);
					Utils.backer(13+Utils.lCalc(s)-1);
					apply(s, i, 'm', c);
				}
				p = 0;
				for(int s=0;s<App.nome.length;s++){//cerca nella lista le femmine con tot intelligienza
					System.out.print("C"+App.competenze[s]+"S"+App.sesso[s]+"A"+App.Cclasse[s]+"i"+i+"p"+p+"c"+c+"s"+s);
					Utils.backer(13+Utils.lCalc(s)-1);
					apply(s, i, 'f', c);
				}
			}
		}
		System.out.println("");
		Utils.wait(245);
		System.out.println(Arrays.toString(App.Cclasse));
		Utils.wait(36);
		System.out.print("Disponendo nelle classi gli alunni che avanzano... ");
		byte c = 1;
		int total = 0;
		for(int s=0;s<App.nome.length;s++){
			Utils.wait(23);
			if(App.Cclasse[s]==(byte)0){
				App.Cclasse[s] = c;
				c++;
				total++;
				if(c>5) c = 1;
			}
			System.out.print(total+" ("+s+"::"+c+")");
			Utils.backer(Utils.lCalc(total)+6+Utils.lCalc(s)-1);
		}
		System.out.println("");
	}
	public static int counter(char c, byte b){
		int ret = 0;
		for(int i=0;i<App.nome.length;i++){
			if(App.sesso[i]==c&&App.competenze[i]==b) ret++;
		}
		return ret;
	}
	public static void apply(int s, int i, char d, byte c){
		if(d=='m'&&p>=m[i])return;
		if(d=='f'&&p>=f[i])return;
		if(App.competenze[s]==i&&App.sesso[s]==d&&App.Cclasse[s]==0){
			App.Cclasse[s]=c;
			p++;
		}
	}
}
