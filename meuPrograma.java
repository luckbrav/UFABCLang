import java.util.Scanner;
public class meuPrograma { 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		String x;
		String y;
		a = 0;
		b = 2;
		x = "ola";
		y = "tchau";
		System.out.println(x);
		System.out.println(y);
		a = sc.nextInt(); sc.nextLine();
		b = sc.nextInt(); sc.nextLine();
		System.out.println(a);
		if (a>5) {System.out.println("maior que 5");a = a+1;}else {System.out.println("menor que 5");}
		do {
b = b+1;
}while (a<5);

		while (a<10) {
b = b+1;
}

		System.out.println("oi agora vamos testar outro");
		if (b>=0) {System.out.println("b positivo");}else {System.out.println("b negativo");}

	}
}
