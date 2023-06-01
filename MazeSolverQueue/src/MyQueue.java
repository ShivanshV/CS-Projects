
public class MyQueue<T> implements QueueADT<T>{
	
	private MyLinkedList<T> queue;
	
	public MyQueue()
	{
		queue = new MyLinkedList();
	}
	
	public MyQueue(T... val)
	{
		queue = new MyLinkedList(val);
	}
	
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	public void offer(T item)
	{
		queue.add(item);
	}
	
	public T poll()
	{
		return queue.remove(0);
	}
	
	public int size()
	{
		return queue.size();
	}
	
	public void clear()
	{
		while(!isEmpty())
		{
			poll();
		}
	}
	
	public T peek()
	{
		return queue.get(0);
	}
	
	

}
