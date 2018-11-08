package part2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo
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

        //List<String> threeHighCaloricDishName = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());

        //System.out.println(threeHighCaloricDishName);


        //List<Dish>  meatDishes = menu.stream().filter(dish -> dish.getType().equals(Dish.Type.MEAT)).limit(2).collect(Collectors.toList());


        //menu.stream().map(dish -> dish.getName()).map(String::length).forEach(System.out::println);


        //
        Optional<Dish> dish = menu.stream().findAny();

    }


}
