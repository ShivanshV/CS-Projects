public class EmployeeDatabase {

    private Employee[] database;
    private int capacity;
    private int size;

    public EmployeeDatabase()
    {
        this(11);
    }

    public EmployeeDatabase(int c)
    {
        capacity = c;
        database = new Employee[capacity];
        size = 0;
    }

    public boolean add(Employee key)
    {
        int hash = key.hashCode() % capacity;
        if(size == capacity)
        {
            return false;
        }
        if (database[hash] != null)
        {
            if(contains(key))
            {
                return false;
            }
            int  i = 1;
            while(true)
            {
            	
              //  hash = (hash+1)%capacity; //linear probe
                if(database[(hash + (int) Math.pow(i, 2))%capacity] == null)
                {
                    database[(hash+ (int) Math.pow(i, 2))%capacity] = key;
                    size+=1;
                    return true;
                }
                i+=1;
            }
        }
        database[hash] = key;
        size+=1;
        return true;
    }


    public boolean contains(Employee key)
    {
        int hash = key.hashCode() % capacity;
        int i = 0;
        while(database[(hash + (int) Math.pow(i, 2))%capacity] != null)
        {
            if(database[(hash + (int) Math.pow(i, 2))%capacity].equals(key))
            {
                return true;
            }
            i+=1;
           // hash = (hash + 1)%capacity; //linear

        }

        return false;
    }

    public boolean remove(Employee key)
    {
        if(contains(key))
        {
        	int i = 1;
        	int hash = key.hashCode() % capacity;
        	if(database[hash].equals(key))
        	{
        		database[hash] = null;
        		
        	}
        	else
        	{
        		
        		while(true)
        		{
        			//hash = (hash+1)% capacity;
        			if(database[(hash + (int) Math.pow(i, 2))%capacity].equals(key))
        			{
        				database[(hash + (int) Math.pow(i, 2))%capacity] = null;
        			}
        			i+=1;
        		}
        	}
        	size-=1;
        	
        	//hash = (hash+1)% capacity;
        	while(database[(hash + (int) Math.pow(i, 2))%capacity] != null && key.hashCode() == database[(hash + (int) Math.pow(i, 2))%capacity].hashCode())
        	{
        		Employee e = database[(hash + (int) Math.pow(i, 2))%capacity];
        		remove(database[(hash + (int) Math.pow(i, 2))%capacity]);
        		add(e);
        		//hash = (hash+1)% capacity;
        		i+=1;
        	}
        	return true;
        }
        return false;
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {
        String str = "";
        for(int i = 0 ; i < capacity; i++)
        {
            if(database[i] != null)
            {
                str+= "[ " + database[i].toString() + " ] ";
            }
        }
        return str;
    }


} 