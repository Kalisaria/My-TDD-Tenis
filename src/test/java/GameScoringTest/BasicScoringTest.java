package GameScoringTest;

import ScorePlay.TennisGameScoring;
import junit.framework.TestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasicScoringTest {

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(0, 0, "love-love"),
                new TestCase(0, 15, "love-fifteen"),
                new TestCase(0, 30, "love-thirty"),
                new TestCase(0, 40, "love-forty"),
                new TestCase(40, 40, "deuce"),
                new TestCase(50, 40, "advantage Player1"),
                new TestCase(40, 50, "advantage Player2"),
                new TestCase(40,60, "Win player2"),
                new TestCase(60,40, "Win player1")
        );

    }

    @ParameterizedTest(name="{0}")
    @MethodSource("testCases")
    void givenScoreNumberConvertToScoreString(TestCase testCase){
        TennisGameScoring tennisGameScoring = new TennisGameScoring();
        String result = TennisGameScoring.convert(testCase.player1, testCase.player2);
        assertEquals(testCase.score, result);

    }

    static class TestCase{
        public int player1;
        public int player2;
        public String score;
        public TestCase(int player1, int player2, String score){
            this.player1 = player1;
            this.player2 = player2;
            this.score =  score;
        }

        public String toString(){
            return "given "+ player1+"-"+ player2+" Should return "+score;
        }

    }
}
