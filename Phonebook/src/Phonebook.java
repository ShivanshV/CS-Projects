
public class Phonebook implements IMap{

    private Entry[] table;
    int size = 0;

    public Phonebook(int capacity)
    {
        table = new Entry[capacity];
        size = 0;
    }

    public PhoneNumber get(Person key)
    {
        Entry current = table[Math.abs(key.hashCode())%table.length];
        while(current != null)
        {
            if(current.key.equals(key))
            {
                return current.value;
            }
            current = current.next;

        }
        return null;
    }

    public PhoneNumber put(Person key, PhoneNumber value)
    {
        Entry current = table[Math.abs(key.hashCode())%table.length];
        if(current == null)
        {
            table[Math.abs(key.hashCode())%table.length] = new Entry(key, value);
            size+=1;
            return null;
        }
        if(current.key.equals(key))
        {
        	Entry temp = current;
        	table[Math.abs(key.hashCode())%table.length] = new Entry(key, value, current.next);
        	return temp.value;
        }
        while(current.next != null)
        {
            if(current.next.key.equals(key))
            {
                Entry temp = current.next;
                current.next = new Entry(key,value,current.next.next);
                return temp.value;
            }
            current = current.next;
        }
        current.next = new Entry(key,value);
        size+=1;
        return null;
    }

    public PhoneNumber remove(Person key)
    {
        Entry current = table[Math.abs(key.hashCode())%table.length];
        if(current == null)
        	return null;
        if(current.key.equals(key))
        {
        	Entry temp = current;
        	table[Math.abs(key.hashCode())%table.length] = current.next;
        	size-=1;
        	return temp.value;
        }
        while(current.next != null)
        {
            if(current.next.key.equals(key))
            {
                Entry temp = current.next;
                current.next = current.next.next;
                size-=1;
                return temp.value;
            }
            current = current.next;

        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }

    private class Entry
    {
        Person key;
        PhoneNumber value;
        Entry next;

        public Entry(Person k, PhoneNumber v)
        {
            this(k,v,null);
        }
        public Entry(Person k, PhoneNumber v, Entry n)
        {
            key = k;
            value = v;
            next = n;
        }
    }
}  