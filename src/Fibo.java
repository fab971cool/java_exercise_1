import java.util.Scanner;

public class Fibo implements Command
{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public Boolean run(Scanner scan) {

        System.out.print(" Choisissez le nombre pour la suite de Fibonacci : ");
        int n = scan.nextInt();
        scan.nextLine();
        int f0 = 0, f1 = 1, fn = -1;
        if (n == 0) {
            System.out.println(f0);
            return false;
        }
        if (n == 1){
            System.out.println(f1);
            return false;
        }

        int i = 2;
        for (; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        System.out.println("fibo(" + n + ") = " + fn);
        return false;
    }
}
