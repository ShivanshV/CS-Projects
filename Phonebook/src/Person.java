public class Person {
    private String name;

    public Person(String n)
    {
        name = n;
    }

    @Override
    public boolean equals(Object obj) {

        return name.equals(((Person)obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}