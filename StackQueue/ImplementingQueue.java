import java.util.Stack;

public class ImplementingQueue 
{
    static Stack<Integer> stack = new Stack<>();
    static int count = 0;

    public void enqueue(int num)
    {
        count++;
        stack.push(num);
        if (count > 1) 
	{
            int[] arr = new int[count];
            int pos = 0;
            while (!stack.isEmpty())
	    {
                arr[pos++] = stack.pop();
            }
            for (int i = 1; i < arr.length; i++)
	    {
                int number = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = number;
            }
            for (int i = arr.length - 1; i >= 0; i--)
	    {
                stack.push(arr[i]);
            }
        }
    }

    public void displayElements()
    {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> printStack = new Stack<>();

        while (!stack.isEmpty()) 
	{
            int element = stack.pop();
            tempStack.push(element);

        }

        while (!tempStack.isEmpty()) 
	{
	    int element = tempStack.pop();
            stack.push(element);
	    printStack.push(element);
        }

        while (!printStack.isEmpty()) 
	{
            System.out.println(printStack.pop());
        }
    }

    public void dequeue()
    {
        if (!stack.isEmpty()) 
	{
            stack.pop();
            count--;
        } 
	else 
	{
            System.out.println("Queue is empty.");
        }
    }

    public static void main(String... args)
    {
        ImplementingQueue implement = new ImplementingQueue();

        // Enqueue Operation
        implement.enqueue(2);
        implement.enqueue(6);
        implement.enqueue(5);
        implement.enqueue(4);
        implement.enqueue(3);
        implement.enqueue(1);

        // Original stack
        System.out.println("Original Queue:");
        implement.displayElements();

        // Dequeue Operation
        implement.dequeue();
        implement.dequeue();

        // New stack
        System.out.println("Queue After Dequeue:");
        implement.displayElements();
    }
}
