import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final String rawString = "Satius est sero te quam numquam, discere";
        stringToList(separator(), rawString).stream().forEach(System.out::println);
    }

    //функции разбиения строки с помощью лямбда-выражения
    private static Function<String, List<String>> separator() {
        return s -> Arrays.asList(s.split("\\s"));
    }

    //функции высшего порядка. Принимает функцию и строку, получаем список с помощью stream API
    private static List<String> stringToList(Function<String, List<String>> function, String string) {
        return function.apply(string).stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}

