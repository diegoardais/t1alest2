import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Game {
    private int playersQuantity;
    private ArrayList<Monkey> players = new ArrayList<Monkey>();
    private int roundsDone = 0;
    private int amountOfRounds;

    public Game(String filePath) throws Exception {
        ArrayList<String[]> fileLines = FileReader.readFromFileTXT(filePath);

        for (String[] line : fileLines) {
            if (line.length == 3) {
                if (isNumeric(line[1])) {
                    amountOfRounds = Integer.parseInt(line[1]);
                } else {
                    throw new Exception("Invalid file");
                }
            } else {
                if (isNumeric(line[1]) && isNumeric(line[4]) && isNumeric(line[7]) && isNumeric(line[9])) {
                    LinkedList<Integer> startingCoconuts = new LinkedList<Integer>();
                    for (int i = 11; i < line.length; i++) {
                        startingCoconuts.add(Integer.parseInt(line[i]));
                    }
                    players.add(new Monkey(Integer.parseInt(line[1]), Integer.parseInt(line[4]),
                            Integer.parseInt(line[7]), startingCoconuts));
                }
            }

        }

    }

    public void nextRound() {
        for (Monkey monkey : players) {
            players.get(monkey.getEvenGoesTo()).addToEvenLinkedList(monkey.getEvenCoconutsLinkedList());
            players.get(monkey.getOddGoesTo()).addToOddLinkedList(monkey.getOddCoconutsLinkedList());
            monkey.clearEvenCoconuts();
            monkey.clearOddCoconuts();
        }
        roundsDone++;
    }

    public Monkey getWinner() {
        Monkey winner = players.get(0);
        for (Monkey monkey : players) {
            if (winner.getCoconutsAmount() < monkey.getCoconutsAmount())
                ;
            winner = monkey;
        }
        return winner;
    }

    public String toString() {
        String output = roundsDone + " rodadas realizadas";
        for (Monkey monkey : players) {
            output += monkey.toString();
        }
        return output;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(strNum).matches();
    }
}
