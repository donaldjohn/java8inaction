package part2;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo
{
    public static void main(String[] args)
    {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", false, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

//        long  count = menu.stream().collect(Collectors.counting());

//        Optional<Dish> lowestCaloryDish = menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));
//        Optional<Dish> lowestCaloryDish2 = menu.stream().collect(Collectors.reducing((d1, d2)-> d1.getCalories() < d2.getCalories()?d1:d2));


//        int totalcalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
//        int totalcalories2 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (cal1, cal2) -> cal1 + cal2));


//        double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));


//        String simpleMenu = menu.stream().map(m->m.getName()).collect(Collectors.joining(","));


//        Long countMenu = menu.stream().collect(Collectors.counting());


        Map<Dish.Type, List<Dish>> groupResult =  menu.stream().collect(Collectors.groupingBy(Dish::getType));

        Map<Dish.Type, Long> groupResult1 =  menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));

        Map<Dish.Type, Optional<Dish>> result =  menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        Map<Dish.Type, Dish> result2 =  menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));

        System.out.println(groupResult1);
    }
}
