package Hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class hashing {
	public static void main(String args[]) {
		new hashing().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		scanner.nextLine();
		String[] numbers=scanner.nextLine().split("\\s+");
		LinkedList<Integer> positions=new LinkedList<>();
		for (int i = 0; i < numbers.length-1; i++) {
			int position=Integer.parseInt(numbers[i])%N;
			System.out.print(position);
			int direction=0;
			while (positions.contains(position)) {
				if (numbers[i].isEmpty()) {
					if (direction==1) {
						position=(position+1)%N;
					}else {
						if (position-1<0) {
							position=N-1;
						}else {
							position--;
						}
					}
				}else {
					String last;
					int j;
					if (numbers[i].length()==1) {
						last=numbers[i];
						numbers[i]="";
						j=0;
					}else {
						last=numbers[i].substring(numbers[i].length()-1);
						numbers[i]=numbers[i].substring(0,numbers[i].length()-1 );
						j=Integer.parseInt(numbers[i])%N;
					}
					
					if (Integer.parseInt(last)%2==0) {
						if (numbers[i].isEmpty()) {
							direction=0;
						}
						if (j>position) {
							position=7-(j-position);
						}else {
							position=position-j;
						}
					}else {
						if (numbers[i].isEmpty()) {
							direction=1;
						}
						position=(position+j)%7;
					}
				}
				System.out.print(" "+position);
			}
			positions.add(position);
			System.out.println();
		}
	}
}