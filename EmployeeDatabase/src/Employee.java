public class Employee {

    private String name;
    private int ID;

    public Employee(String s, int i)
    {
        name = s;
        ID = i;
    }

    @Override
    public boolean equals(Object obj) {
        return ID == ((Employee)obj).ID && name.equals(((Employee)obj).name);
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        for(int i = ID; i > 0; i/=10) {
            hash += i;
            
        }
        for(int i = 0; i < name.length(); i++)
        {
        	hash+=name.charAt(i);
        }
        return hash;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    
    public String toString()
    {
    	return name + ", " + ID;
    }
}
