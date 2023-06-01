
public class Runner {

	public static void main(String[] args) {
		MyHashTable<Person, Integer> table = new MyHashTable<>();
		Person charlie = new Person("Charlie");
        table.put(charlie, 30);
        

	}

}
