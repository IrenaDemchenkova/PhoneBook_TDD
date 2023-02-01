import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    Map<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String number) {
        if (name != null && number != null) {
            phoneBook.put(name, number);
        } else {
            throw new RuntimeException("Not enough data for operation");
        }
        return phoneBook.size();
    }
}
