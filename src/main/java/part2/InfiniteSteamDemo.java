package part2;

import java.util.stream.Stream;

public class InfiniteSteamDemo
{
    public static void main(String[] args)
    {
        //Even number
        //Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        //Fibonacci number
        //Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(20).map(f -> f[0]).limit(10).forEach(System.out::println);


        //Fibonacci number by Generate;
        final int[] leadingEles = new int[2];
        leadingEles[0] = 0;
        leadingEles[1] = 1;
        Stream.generate(()-> {int currentEle = leadingEles[0];  int newEle = leadingEles[0] + leadingEles[1]; leadingEles[0] = leadingEles[1];   leadingEles[1] = newEle; return currentEle;}).limit(10).forEach(System.out::println);
    }
}
