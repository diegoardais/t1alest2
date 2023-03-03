public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game("a.txt");
        System.out.println("\n" + game.toString());

        for (int i = 0; i < 1000; i++) {
            game.nextRound();
        }

        System.out.println("\n" + game.toString());

    }
}