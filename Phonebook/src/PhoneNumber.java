public class PhoneNumber {
    public String number;

    public PhoneNumber(String n)
    {
        number = n;
    }

    @Override
    public boolean equals(Object obj) {

        return number.equals(((PhoneNumber)obj).number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}