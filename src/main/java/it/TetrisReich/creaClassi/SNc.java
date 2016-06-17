package it.TetrisReich.creaClassi;

public class SNc {
	public static void divisor(){
		Utils.classType = true;
		for(byte i=0;i<=5;i++){
			
			Utils.classBank = i;
			int c = 0;
			for(int in=0;in<=6;in++){
				//System.out.print(i+"::"+in+"::m");
				classSercher(in,'m');
				c = 7 + Utils.lLenght;
				Utils.backer(c);
			}
			for(int in=0;in<=6;in++){
				//System.out.print(i+"::"+in+"::f");
				classSercher(in,'f');
				c = 7 + Utils.lLenght;
				Utils.backer(c);
			}
		}
		System.out.println("");
	}
	public static void classSercher(int in, char sex){
		Utils.finder(in, sex, 2/*, (byte)0*/);
	}
}
