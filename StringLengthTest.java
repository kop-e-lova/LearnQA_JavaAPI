import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringLengthTest {
    @ParameterizedTest
    @ValueSource(strings = {"14_symbols_111", "15_symbols_here", "16_sympols_here1"})
    public void testStringLength(String str){
        assertTrue(str.length() > 15, "The string's length is less than 15 symbols");

    }
}
