package part2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long>
{

    private final int startIndex;
    private final int endIndex;
    private final long[] numbers;

    public final static long THRESHOLD = 10;


    public ForkJoinSumCalculator(long[] numbers)
    {
        this(numbers, 0, numbers.length);
    }


    private ForkJoinSumCalculator(long[] numbers, int startIndex, int endIndex)
    {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }


    @Override
    protected Long compute()
    {
        if (this.endIndex - this.startIndex < ForkJoinSumCalculator.THRESHOLD)
        {
            return sumSequential();
        } else
        {
            ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, startIndex, (startIndex + endIndex) / 2);
            leftTask.fork();


            ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, (startIndex + endIndex) / 2, endIndex);

            return rightTask.compute() + leftTask.join();
        }
    }


    private long sumSequential()
    {
        long sum = 0;
        for (int i = this.startIndex; i < this.endIndex; i++)
        {
            sum += numbers[i];
        }
        return sum;
    }

    public static long  forkJoin(long n)
    {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
