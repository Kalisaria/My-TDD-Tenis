package GameScoringTest;

import ScorePlay.TennisGameScoring;
import ScorePlay.TennisSetScoring;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class setScoringTest {

    static Stream<BasicScoringTest.TestCase> testCases() {
        return Stream.of(
                new BasicScoringTest.TestCase(0, 0, "love-love"),
                new BasicScoringTest.TestCase(0, 1, "love-fifteen"),
                new BasicScoringTest.TestCase(0, 2, "love-thirty"),
                new BasicScoringTest.TestCase(0, 3, "love-forty"),
                new BasicScoringTest.TestCase(3, 3, "deuce"),
                new BasicScoringTest.TestCase(4, 3, "advantage Player1"),
                new BasicScoringTest.TestCase(3, 4, "advantage Player2"),
                new BasicScoringTest.TestCase(3,5, "Win player2"),
                new BasicScoringTest.TestCase(5,3, "Win player1")
        );

    }

    @ParameterizedTest(name="{0}")
    @MethodSource("testCases")
    void givenScoreNumberConvertToScoreString(BasicScoringTest.TestCase testCase){
        TennisSetScoring tennisSetScoring = new TennisSetScoring();
        String result = TennisSetScoring.convert(testCase.player1, testCase.player2);
        assertEquals(testCase.score, result);

    }


}