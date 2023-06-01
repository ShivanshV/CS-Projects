public class MyHashTable<K,V>{

    private Object[] table;
    int size;

    public MyHashTable()
    {
        this(29);
    }

    public MyHashTable(int capacity)
    {
        table = new Object[capacity];
        size = 0;
    }

    public V get(K key)
    {
        Entry current = (Entry) table[Math.abs(key.hashCode())%table.length];
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

    public V put(K key, V value)
    {
        Entry current = (Entry) table[Math.abs(key.hashCode())%table.length];
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

    public V remove(K key)
    {
        Entry current = (Entry) table[Math.abs(key.hashCode())%table.length];
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


    public int size() {
        return size;
    }

    private class Entry
    {
        K key;
        V value;
        Entry next;

        public Entry(K k, V v)
        {
            this(k,v,null);
        }
        public Entry(K k, V v, Entry n)
        {
            key = k;
            value = v;
            next = n;
        }
    }
}