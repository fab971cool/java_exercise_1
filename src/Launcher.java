import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println(" Bienvenue ! Votre commande :");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        do
        {
            System.out.println(" Unknown Command ");
            line = scanner.nextLine();

        }while (!line.equals("quit"));
    }
}
