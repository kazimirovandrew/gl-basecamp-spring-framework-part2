import basecamp.service.GameService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameServiceTest {

    private static GameService gameService;

    @BeforeClass
    public static void init() {
        gameService = new GameService();
    }

    @Test
    public void givenGuess_whenIsGameWon_thenGetResult() {

        // given
        String guess = "50";

        // when
        gameService.isGameWon(guess);

        //then
        String result = gameService.getResult();
        assertTrue("Winner!".equals(result) || "Looser!".equals(result));
    }
}
