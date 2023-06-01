
public class MyLinkedList <T>{
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList(T val)
    {
        head = new ListNode(val);
        tail = head;
        size = 1;
    }
    
    public MyLinkedList(T... val)
    {
    	size = 0;
    	for(T num: val)
    	{
    		add(num);
    	}
    }

  

    public void add(T newVal)
    {
        if(head == null)
        {
        	head = new ListNode(newVal);
        	tail = head;
        	
        }
        else
        {
        	
            tail.next = new ListNode(newVal);
            tail = tail.next;
            
            
        }
        size++;
        
    }

    public boolean contains(T target)
    {
        ListNode current = head;
        while(current != null)
        {
            if(current.val.equals(target))
                return true;
            current = current.next;
        }
        return false;
    }

    public T get(int index)
    {
        if(index < 0 || index >= sizeRecursive())
            throw new IndexOutOfBoundsException();
        ListNode current = head;
        int currentIndex = 0;
        while(index != currentIndex)
        {
            current = current.next;
            currentIndex++;
        }

        return current.val;

    }

    public int indexOf(T target)
    {
        if(!contains(target))
            return -1;
        ListNode current = head;
        int currentIndex = 0;
        while(!current.val.equals(target))
        {
            current = current.next;
            currentIndex++;
        }
        return currentIndex;
    }

    public void set(T newVal, int index)
    {
        if(index < 0 || index >= sizeRecursive())
            throw new IndexOutOfBoundsException();
        ListNode current = head;
        int currentIndex = 0;
        while(index != currentIndex)
        {
            current = current.next;
            currentIndex++;
        }
        current.val = newVal;
    }


  /*  public int size()
    {
        int size = 0;
        ListNode current = head;
        while(current != null) {
            size++;
            current= current.next;
        }
        return size;
    }*/
    
    public int size()
    {
    	return size;
    }

    public int sizeRecursive()
    {
        return sizeRecursive(head);
    }

    private int sizeRecursive(ListNode current)
    {
        if(current == null)
            return 0;
        return 1 + sizeRecursive(current.next);
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public T remove(int index)
    {
        if(index <  0 || index >= sizeRecursive())
            throw new IndexOutOfBoundsException();
        ListNode current = head;
        int currentIndex= 0;
        T val;
        if(index == 0)
        {
        	val = head.val;
            if(size() == 1)
            	head = null;
            
            else
            	head = current.next;
            size--;
            return val;

        }
        while(currentIndex != index-1)
        {
            currentIndex++;
            current = current.next;
        }
        val = current.next.val;
        if(indexOf(val) == size()-1)
            current.next = null;
        else
            current.next = current.next.next;
        size--;
        return val;
    }

    public void add(T newVal, int index)
    {
        if(index < 0 || index > sizeRecursive())
            throw new IndexOutOfBoundsException();
        int size = sizeRecursive();
        ListNode current = head;
        int currentIndex= 0;
        
        if(index == 0)
        {
            head = new ListNode(newVal);
            if(size>1)
                head.next = current;
            this.size++;
        }
        else if(index == sizeRecursive())
        {
        	
        	add(newVal);
        }
        else
        {
            while(currentIndex != index-1)
            {
                currentIndex++;
                current = current.next;
            }
            ListNode next = current.next;
            current.next = new ListNode(newVal);
            current = current.next;
            current.next = next;
            this.size++;
            
        }


    }

    public String toString()
    {
        String list = "[";
        if(isEmpty())
            return list + "]";
        ListNode current = head;
        while(current != null)
        {
            list+=current.val;
            if(current.next != null)
                list+=", ";
            current = current.next;
        }
        return list + "]";

    }
    private class ListNode
    {
        T val;
        ListNode next;

        public ListNode(T val) {this.val = val;}

        @Override
        public String toString() {return "" + this.val;} //printing / debug
    }
}

