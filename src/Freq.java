import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Freq implements Command
{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public Boolean run(Scanner scan) {

        System.out.print(" Ecrivez le chemin de votre fichier : ");
        String fichier = scan.next();
        scan.nextLine();

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

            return false;
        }

        return false;
    }
}
