package 初级;
import java.util.Scanner;

public class 二十四点游戏算法 {
	public static boolean Calculate(int x, int y, int z, int w) {
		if (x+y+z+w==24) return true;
		else if (x+y+z-w==24) return true;
		else if ((x+y)*(z+w)==24) return true;
		else if ((x-y)*(z+w)==24) return true;
		else if ((x-y)*(z-w)==24) return true;
		else if ((x+y+z)*w==24) return true;
		else if ((x-y-z)*w==24) return true;
		else if ((x+y-z)*w==24) return true;
		else if ((x*y*z)/w==24) return true;
		else if ((x*y)*(z+w)==24) return true;
		else if ((x*y)*(z-w)==24) return true;
		else if ((x*y)*z-w==24) return true;
		else if ((x*y)*z+w==24) return true;
		else if (x*y*z*w==24) return true;
		else if ((x+y)+(z/w)==24) return true;
		else if ((x+y)*(z/w)==24) return true;
		else if ((x*y)+z+w==24) return true;
		else if ((x*y)+z-w==24) return true;
		else if ((x*y)-(z/w)==24) return true;
		else if ((x*y)+(z/w)==24) return true;
		else if ((x*y)-z-w==24) return true;
		else if ((x*y)+(z*w)==24) return true;
		else if ((x*y)-(z*w)==24) return true;
		else if ((x*y)/(z*w)==24) return true;
		else if ((z != w) && (x*y)/(z-w)==24) return true;
		else if ((x*y)/(z+w)==24) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		boolean result = Calculate(a,b,c,d) || Calculate(a,b,d,c) || Calculate(a,c,d,b) ||
				Calculate(a,c,b,d) || Calculate(a,d,b,c) || Calculate(a,d,c,b) ||
				Calculate(b,a,c,d) || Calculate(b,a,d,c) || Calculate(b,c,a,d) ||
				Calculate(b,c,d,a) || Calculate(b,d,c,a) || Calculate(b,d,a,c) ||
				Calculate(c,a,b,d) || Calculate(c,a,d,b) || Calculate(c,b,d,a) ||
				Calculate(c,b,a,d) || Calculate(c,d,a,b) || Calculate(c,d,b,a) ||
				Calculate(d,a,b,c) || Calculate(d,a,c,b) || Calculate(d,b,c,a) ||
				Calculate(d,b,a,c) || Calculate(d,c,a,b) || Calculate(d,c,b,a);
		
		System.out.println(result);
	}
}
