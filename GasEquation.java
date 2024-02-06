import java.util.Scanner;

public class GasEquation {

	public static float v;
	public static float n;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int agar;
		float T, Vi, Tc, P, v, a, b, R, pc, Vn, z;

		System.out.println("pressure : ");
		P = scanner.nextFloat();

		System.out.println("volume : ");
		v = scanner.nextFloat();
		
		System.out.println("Enter 1 for first case or 2 for second case : ");
		agar = scanner.nextInt();


		if (agar == 1) {
			System.out.println("\n hajm_ ");
			v = scanner.nextFloat();
			System.out.println("  n dama_  ");
			T = scanner.nextFloat();
			System.out.println("\n Tc_"); // jadval
			Tc = scanner.nextFloat();
			System.out.println("\n Pc_"); // jadval
			pc = scanner.nextFloat();

			R = (float) 8.314;
			a = (float) (0.42748 * Math.pow(R, 2) * Math.pow(Tc, 2.5) / pc);
			System.out.println("\n a=" + a);
			b = (float) (0.08664 * R * Tc / pc);
			System.out.println("\n b=" + b);

			P = (float) ((R * T) / (v - b) - a / (Math.pow(T, 0.5) * v * (v + b)));
			System.out.println("\n pressure: " + P);
		}

		if (agar == 2) {
			System.out.println("volume saturated");
			v = scanner.nextFloat();
			System.out.println(" \n pressure_");
			P = scanner.nextFloat();
			System.out.println("\n dama_");
			T = scanner.nextFloat();
			System.out.println("\n Tc_"); // jsdval
			Tc = scanner.nextFloat();
			System.out.println("\n Pc_"); // jadval
			pc = scanner.nextFloat();

			R = (float) 8.314;
			a = (float) (0.42748 * R * R * Math.pow(Tc, 2.5) / pc);
			b = (float) (0.08664 * R * Tc / pc);
			Vi = R * T / P;
			Vn = (float) ((R * T / P) + b - (a * (Vi - b)) / (Math.pow(T, 0.5) * P * (Vi + b)));
			System.out.println("\n volume: " + Vn);

			z = Vn - Vi;
			while (z > 0.001) {
				Vi = Vn;
				Vn = (float) ((R * T) / P + b - (a * (Vi - b)) / (Math.pow(T, 0.5) * P * (Vi + b)));
				System.out.println("\n volume: " + Vn);
				z = Vn - Vi;
			}
		}
		scanner.close();
	}
}
