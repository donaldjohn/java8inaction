package part3;

public class RefacterDemo
{
    public static void doSomething(Runnable r1)
    {
        r1.run();
    }

    public static void doSomething(Task task)
    {
        task.execute();
    }


    public static void main(String[] args)
    {
        //doSomething(()-> System.out.println("Hello"));
        doSomething((Runnable) ()-> System.out.println("Hello"));//造成类型歧义, 需要强转
    }

}

interface Task
{
    void execute();
}
