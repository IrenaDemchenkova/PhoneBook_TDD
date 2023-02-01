import java.util.Map;
import java.util.Objects;
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

    public String findByNumber(String number) {
        if (phoneBook.containsValue(number)) {
            return phoneBook.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), number))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .get();
        } else {
            throw new RuntimeException("No such number found");
        }
    }

    public String findByName(String name) {
        return null;
    }
}
