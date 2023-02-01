import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    private static PhoneBook testPhoneBook;

    @BeforeAll
    public static void init() {
        testPhoneBook = new PhoneBook();
    }

    @ParameterizedTest
    @MethodSource("sourceForAdd")
    public void addTest(String name, String number, int count) {
        int result = testPhoneBook.add(name, number);
        assertEquals(count, result);
    }

    private static Stream<Arguments> sourceForAdd() {
        return Stream.of(
                Arguments.of("Ivan", "+79161234567", 1),
                Arguments.of("Elena", "+74951234567", 2),
                Arguments.of("Ivan", "+79161234567", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("addNullCase")
    public void addNotEnoughDataTest(String name, String number) {
        Assertions.assertThrows(Exception.class, () -> testPhoneBook.add(name, number));
    }

    private static Stream<Arguments> addNullCase() {
        return Stream.of(
                Arguments.of(null, "+78121234567"),
                Arguments.of("Maria", null),
                Arguments.of(null, null)
        );
    }

    @AfterAll
    public static void tearDown() {
        testPhoneBook = null;
    }
}
