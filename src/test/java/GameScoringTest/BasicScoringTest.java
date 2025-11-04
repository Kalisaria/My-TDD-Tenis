package GameScoringTest;
package ScorePlay;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoringTest {
    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(0, "love"),
                new TestCase(15, "fifteen"),
                new TestCase(30, "thirty"),
                new TestCase(40, "forty")
        );

    }
    void gi
}
