
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
        System.out.println(" Bienvenue ! Que souhaitez-vous faire ? :");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String tmp;
        while (!line.equals("quit"))
        {


            if (line.equals("fibo")) {
                System.out.println(" Choisissez le nombre pour la suite de Fibonacci : ");
                int n = scanner.nextInt();
                tmp = scanner.nextLine();
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
            else if (line.equals("freq")){
                System.out.println(" Ecrivez le chemin de votre fichier : ");
                String fichier = scanner.next();
                tmp = scanner.nextLine();

                Path chemin = Paths.get(fichier);
                try
                {
                    String content = Files.readString(chemin);
                    content = content.toLowerCase();
                    content = content.replaceAll("[^a-z]+", " ");
                    String[] words = content.split(" ");

                    var count = Arrays.stream(words)
                            .collect(Collectors.groupingBy(s->s, Collectors.counting())
                    );

                    Map<String, Long> finalMap = new LinkedHashMap<>();
                    count.entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue()
                            .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

                    // le keySet() ou ".map(Entry::getkey)", permettent de garder seulement les keys de finalMap sans leurs values
                    var fin = finalMap.keySet().stream().limit(3);
                    System.out.println(Arrays.toString(fin.toArray()));

                }
                catch (IOException e)
                {
                    System.out.println("Unreadable file: " +
                            e.getClass().getSimpleName()+ " "+  e.getMessage());

                    break;
                }
                break;
            }
            else {
                System.out.println(" Unknown Command ");
                line = scanner.nextLine();
            }


        }
    }
}
