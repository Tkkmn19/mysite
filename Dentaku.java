package test;
	
import java.util.Scanner;

public class Dentaku2 {
	
	public static int Num1 = 0;
	public static int Num2 = 0;
	public static int Ope = 0;
	public static int Kotae = 0;
	public static int Amari = 0;
	public static String[] Operator = {"+","-","*","/"};
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] arms) {
		
		//数値 入力　演算子 入力 交互に入力する。
		//入力数値が1~99の四則演算の電卓
		Num1 = NumInput();
		
		Ope = OpeJudge();

		Num2 = NumInput();
		
		Kotae = Answer();

			
		
		
		if(Ope == 3) {//除算の場合、余りも表示
			System.out.printf("答えは %d 余り %d です。",Kotae,Amari);
		}else {
		System.out.printf("答えは %d です。",Kotae);
		}
		scanner.close();
	}
	
	public static int OpeJudge() {//演算子の入力
		
		String str;
		int judge = 0;

		while(true) {	
			System.out.printf("演算子(+ - * /)を入力してください。%n");
			
		 	str  = scanner.next();
		 	
		 	for(int i = 0; i < 4; i++) { //演算子を数値に代入
		 		if(str.equals(Operator[i])) {
		 			judge = i;
				 break;
		 		}
		 		judge = 10;
			}
		 	if(judge != 10) 
		 		break;
		} 
		return judge;
	}
	public static int NumInput() {//値の入力

		String check; 
		int num = 0;  
		boolean numcheck = false;
		
		do{
			System.out.printf("整数を入力してください。%n");//数値１の取得	
			
			check  = scanner.next();
			
			for(int i = 0; i < check.length(); i++) {//入力された文字の整数の判定に使用
				
				if(Character.isDigit(check.charAt(i))) {//値を１文字ずつ数字か判定
					
					if(i + 1 == check.length()) {
						numcheck = true;
						num = Integer.parseInt(check);
					}
				continue;
				
				}else {
					
					numcheck = false;
					break;
					
				}
			}	
		}while(!numcheck);
		return num;
	}
	public static int Answer(){//計算式

		int kota = 0;
		
		switch(Ope) {
		case 0:
			kota = Num1 + Num2;
		break;
		case 1:
			kota = Num1 - Num2;
		break;
		case 2:
			kota = Num1 * Num2;
		break;
		case 3:
			kota = Num1 / Num2;
			Amari = Ama();
		}
		return kota;
	}
	public static int Ama(){//余りの計算
		int ama = 0;
		ama = Num1 % Num2;
		return  ama;
	}
	
}
	