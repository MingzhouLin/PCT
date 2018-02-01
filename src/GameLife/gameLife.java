package GameLife;

import java.util.Scanner;

public class gameLife {
	public static void main(String args[]) {
		new gameLife().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int R=scanner.nextInt();
		int C=scanner.nextInt();
		scanner.nextLine();
		char[][] matrix=new char[R][C];
		for (int i = 0; i <R; i++) {
			String line=scanner.nextLine();
			for (int j = 0; j <C; j++) {
				matrix[i][j]=line.charAt(j);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		int N=scanner.nextInt();
		int[][] judge=new int[R][C];
		int status=0;
		for (int i = 0; i < N; i++) {
			status=0;
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					judge[j][j2]=0;
				}
			}
			for (int j = 0; j <R; j++) {
				for (int k = 0; k < C; k++) {
					if (matrix[j][k]=='#') {
						if (j==0) {
							if (k==0) {
								int num=0;
								if (matrix[j][k+1]=='@') num++;
								if (matrix[j+1][k+1]=='@') num++;
								if (matrix[j+1][k]=='@') num++;
								if (num==3) judge[j][k]=1;
							}else {
								if (k==C-1) {
									int num=0;
									if (matrix[j][k-1]=='@') num++;
									if (matrix[j+1][k-1]=='@') num++;
									if (matrix[j+1][k]=='@') num++;
									if (num==3) judge[j][k]=1;
								}else {
									int num=0;
									if (matrix[j][k-1]=='@') num++;
									if (matrix[j][k+1]=='@') num++;
									if (matrix[j+1][k-1]=='@') num++;
									if (matrix[j+1][k+1]=='@') num++;
									if (matrix[j+1][k]=='@') num++;
									if (num==3) judge[j][k]=1;
								}
							}
						}else {
							if (j==R-1) {
								if (k==0) {
									int num=0;
									if (matrix[j][k+1]=='@') num++;
									if (matrix[j-1][k+1]=='@') num++;
									if (matrix[j-1][k]=='@') num++;
									if (num==3) judge[j][k]=1;
								}else {
									if (k==C-1) {
										int num=0;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if (num==3) judge[j][k]=1;
									}else {
										int num=0;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j][k+1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if (matrix[j-1][k+1]=='@') num++;
										if (num==3) judge[j][k]=1;
									}
								}
							}else {
								if (k==0) {
									int num=0;
									if (matrix[j][k+1]=='@') num++;
									if (matrix[j-1][k+1]=='@') num++;
									if (matrix[j+1][k+1]=='@') num++;
									if (matrix[j+1][k]=='@') num++;
									if (matrix[j-1][k]=='@') num++;
									if (num==3) judge[j][k]=1;
								}else {
									if (k==C-1) {
										int num=0;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j+1][k-1]=='@') num++;
										if (matrix[j+1][k]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if (num==3) judge[j][k]=1;
									}else {
										int num=0;
										if (matrix[j][k+1]=='@') num++;
										if (matrix[j-1][k+1]=='@') num++;
										if (matrix[j+1][k+1]=='@') num++;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j+1][k-1]=='@') num++;
										if (matrix[j+1][k]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if (num==3) judge[j][k]=1;
									}
								}
							}
						}
					}else {	
						if (j==0) {
							if (k==0) {
								int num=0;
								if (matrix[j][k+1]=='@') num++;
								if (matrix[j+1][k+1]=='@') num++;
								if (matrix[j+1][k]=='@') num++;
								if ((num!=2)&&(num!=3)) judge[j][k]=1;
							}else {
								if (k==C-1) {
									int num=0;
									if (matrix[j][k-1]=='@') num++;
									if (matrix[j+1][k-1]=='@') num++;
									if (matrix[j+1][k]=='@') num++;
									if ((num!=2)&&(num!=3)) judge[j][k]=1;
								}else {
									int num=0;
									if (matrix[j][k-1]=='@') num++;
									if (matrix[j][k+1]=='@') num++;
									if (matrix[j+1][k-1]=='@') num++;
									if (matrix[j+1][k+1]=='@') num++;
									if (matrix[j+1][k]=='@') num++;
									if ((num!=2)&&(num!=3)) judge[j][k]=1;
								}
							}
						}else {
							if (j==R-1) {
								if (k==0) {
									int num=0;
									if (matrix[j][k+1]=='@') num++;
									if (matrix[j-1][k+1]=='@') num++;
									if (matrix[j-1][k]=='@') num++;
									if ((num!=2)&&(num!=3)) judge[j][k]=1;
								}else {
									if (k==C-1) {
										int num=0;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if ((num!=2)&&(num!=3)) judge[j][k]=1;
									}else {
										int num=0;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j][k+1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if (matrix[j-1][k+1]=='@') num++;
										if ((num!=2)&&(num!=3)) judge[j][k]=1;
									}
								}
							}else {
								if (k==0) {
									int num=0;
									if (matrix[j][k+1]=='@') num++;
									if (matrix[j-1][k+1]=='@') num++;
									if (matrix[j+1][k+1]=='@') num++;
									if (matrix[j+1][k]=='@') num++;
									if (matrix[j-1][k]=='@') num++;
									if ((num!=2)&&(num!=3)) judge[j][k]=1;
								}else {
									if (k==C-1) {
										int num=0;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j+1][k-1]=='@') num++;
										if (matrix[j+1][k]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if ((num!=2)&&(num!=3)) judge[j][k]=1;
									}else {
										int num=0;
										if (matrix[j][k+1]=='@') num++;
										if (matrix[j-1][k+1]=='@') num++;
										if (matrix[j+1][k+1]=='@') num++;
										if (matrix[j][k-1]=='@') num++;
										if (matrix[j-1][k-1]=='@') num++;
										if (matrix[j+1][k-1]=='@') num++;
										if (matrix[j+1][k]=='@') num++;
										if (matrix[j-1][k]=='@') num++;
										if ((num!=2)&&(num!=3)) judge[j][k]=1;
									}
								}
							}
						}
					}
				}
			}
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					if (judge[j][j2]==1) {
						if (matrix[j][j2]=='@') {
							matrix[j][j2]='#';
						}else {
							matrix[j][j2]='@';
						}
					}
					if (matrix[j][j2]=='@') {
						status++;
					}
					System.out.print(matrix[j][j2]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(status);
	}
}
