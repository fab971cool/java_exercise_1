
import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println(" Bienvenue ! Votre commande :");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("quit"))
        {


            if (line.equals("fibo")) {
                int n = scanner.nextInt();
                String tmp = scanner.nextLine();
                int f0 = 0, f1 = 1, fn = -1;

                int i = 2;
                for (; i <= n; i++) {
                    fn = f0 + f1;
                    f0 = f1;
                    f1 = fn;
                }
                System.out.println(fn);
                break;
            }
            System.out.println(" Unknown Command ");
            line = scanner.nextLine();

        }
    }
}
