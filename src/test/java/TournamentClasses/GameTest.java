package TournamentClasses;

import DataClasses.Player;
import Exceptions.NotRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void shouldToWinFirstPlayer() {
        Player venom = new Player(0, "Venom", 67);
        Player witcher = new Player(1, "Witcher", 37);
        Player batman = new Player(2, "Batman", 50);
        Player superman = new Player(3, "Superman", 100);
        Player ironman = new Player(4, "Ironman", 50);

        Game game = new Game();
        game.register(witcher);
        game.register(batman);
        game.register(superman);
        game.register(ironman);
        game.register(venom);

        int expected = 1;
        int actual = game.round("Superman", "Batman");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldToWinSecondPlayer() {
        Player venom = new Player(0, "Venom", 67);
        Player witcher = new Player(1, "Witcher", 37);
        Player batman = new Player(2, "Batman", 50);
        Player superman = new Player(3, "Superman", 100);
        Player ironman = new Player(4, "Ironman", 50);

        Game game = new Game();
        game.register(witcher);
        game.register(batman);
        game.register(superman);
        game.register(ironman);
        game.register(venom);

        int expected = 2;
        int actual = game.round("Witcher", "Batman");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGameDraw() {
        Player venom = new Player(0, "Venom", 67);
        Player witcher = new Player(1, "Witcher", 37);
        Player batman = new Player(2, "Batman", 50);
        Player superman = new Player(3, "Superman", 100);
        Player ironman = new Player(4, "Ironman", 50);

        Game game = new Game();
        game.register(witcher);
        game.register(batman);
        game.register(superman);
        game.register(ironman);
        game.register(venom);

        int expected = 0;
        int actual = game.round("Ironman", "Batman");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowException() {
        Player venom = new Player(0, "Venom", 67);
        Player witcher = new Player(1, "Witcher", 37);
        Player batman = new Player(2, "Batman", 50);
        Player superman = new Player(3, "Superman", 100);
        Player ironman = new Player(4, "Ironman", 50);

        Game game = new Game();
        game.register(witcher);
        game.register(batman);
        game.register(superman);
        game.register(ironman);
        game.register(venom);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Spiderman", "Batman");
        });
    }
}