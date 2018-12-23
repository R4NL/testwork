import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Servise {
    private String in;
    private String what;
    private String forWhat;
    private String out;

    public Servise() {
    }

    public Servise(String in, String what, String forWhat, String out) {
        this.in = in;
        this.what = what;
        this.forWhat = forWhat;
        this.out = out;
    }

    public void begin() {
        try {
            get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void get() throws IOException {
        change(Files.lines(Paths.get("in.txt"), StandardCharsets.UTF_8).
                collect(Collectors.toList()).get(0).split(" "));

    }

    private void change(String[] words) throws IOException {
        andSpace(Arrays.asList(words).stream().map(n -> change(n, what, forWhat)).
                collect(Collectors.toCollection(ArrayList::new)));
    }

    private void andSpace(List<String> words) throws IOException {
        writeResult(words.stream().map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    private void writeResult(String result) throws IOException {
        Files.write(Paths.get("out.txt"), result.getBytes("utf-8"));
    }


    private String change(String a, String what, String forWhat) {
        if (a.contains(what)) {
            return a.substring(0, a.indexOf(what)) + forWhat + a.substring(a.indexOf(what) + what.length());
        } else {
            return a;
        }
    }
}
