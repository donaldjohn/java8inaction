package part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TraversableOnlyOnce
{
    public static void main(String[] args)
    {
        List<String> title = Arrays.asList("Java8", "In", "Action");

        Stream<String> stringStream = title.stream();

        stringStream.forEach(System.out::println);
        stringStream.forEach(System.out::println);
    }
}
