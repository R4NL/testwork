import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Servise {
    public static void start(String what, String forWhat) throws IOException {
        String[] wordsStart = Files.lines(Paths.get("in.txt"), StandardCharsets.UTF_8).
                collect(Collectors.toList()).get(0).split(" ");
        List<String> wordsEnd = Arrays.asList(wordsStart).stream().map(n -> change(n, what, forWhat)).
                collect(Collectors.toCollection(ArrayList::new));
        String a = wordsEnd.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        Files.write(Paths.get("out.txt"), a.getBytes("utf-8"));
    }

    private static String change(String a, String what, String forWhat) {
        if (a.contains(what)) {
            int f = a.indexOf(what);
            int to = f + what.length();
            return a.substring(0, f) + forWhat + a.substring(to);
        } else {
            return a;
        }
    }
}
