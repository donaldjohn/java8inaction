package part2.traderExecuteTransactions;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionDemo
{
    public static void main(String[] args)
    {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),

                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        //1
        List<Transaction> transIn2011 = transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println("Trans in 2011: " + transIn2011);

        //2
        List<String> cities = transactions.stream().map(t -> t.getTrader().getCity()).distinct().sorted().collect(Collectors.toList());
        System.out.println("All unique city: " + cities);

        //3
        List<Trader> tradersFromCambridge = transactions.stream().map(Transaction::getTrader).filter(trader -> "Cambridge".equals(trader.getCity())).distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println("Tranders from Cambridge: " + tradersFromCambridge);


        //4
        List<String> traderNames = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(Collectors.toList());

        String tradeStr0 = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
        String tradeStr1 = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("", String::concat);
        System.out.println("All sorted trader names: " + traderNames);

        //5
        boolean anyTraderBasedInMilan = transactions.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("Any trader based in Milan: " + anyTraderBasedInMilan);

        //6
        System.out.println("All trans values from traders live in Cambridge");
        transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);

        //7
        Integer maxValue = transactions.stream().map(Transaction::getValue).max(Integer::compareTo).get();
        System.out.println("The highest value : " + maxValue);

        //8
        Transaction transactionWithSmallestValue0 = transactions.stream().sorted(Comparator.comparing(Transaction::getValue)).findFirst().get();
        Transaction transactionWithSmallestValue1 = transactions.stream().min(Comparator.comparing(Transaction::getValue)).get();
        System.out.println("The transaction with smallest value: " + transactionWithSmallestValue0);

    }
}
