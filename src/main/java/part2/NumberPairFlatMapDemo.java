package part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberPairFlatMapDemo
{
    public static void main(String[] args)
    {
        //Number Pairs
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);


        List<int[]> numPairs = numbers1.stream().flatMap(integer1 -> numbers2.stream().map(integer2 -> new int[]{integer1, integer2})).collect(Collectors.toList());

        if (true)
        {

        }

    }
}
