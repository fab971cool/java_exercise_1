
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// import java.nio.file.*;

public class Launcher
{

    public static void main(String[] args)
    {
        List<Command> commandes = Arrays.asList(new Quit(), new Fibo(), new Freq());

        Scanner scan = new Scanner(System.in);
        String line = "";
        Boolean faux = false;
        int tmp = 0;
        while(true)
        {
            System.out.println(" Write a command :  ");
            line = scan.nextLine();
            for ( Command commande : commandes )
            {
                if (commande.name().equals(line))
                {
                    faux = commande.run(scan);
                    if (faux) // si faux est vraie, on arrete le programme
                        System.exit(0);
                    tmp = 0;
                    break;
                }
                tmp = 1;

            }
            if (tmp == 1) {
                System.out.println(" Unknown Command ");
            }
        }
    }
}
