import java.util.LinkedList;

public class Monkey {
    private int evenGoesTo;
    private int oddGoesTo;
    private int id;
    private LinkedList<Integer> evenCoconuts;
    private LinkedList<Integer> oddCoconuts;

    public Monkey(int id, int evenGoesTo, int oddGoesTo, LinkedList<Integer> startingCoconuts) {
        this.id = id;
        this.evenGoesTo = evenGoesTo;
        this.oddGoesTo = oddGoesTo;

        evenCoconuts = new LinkedList<Integer>();
        oddCoconuts = new LinkedList<Integer>();

        for (Integer i : startingCoconuts) {
            if (i % 2 == 0) {
                evenCoconuts.add(i);
            } else {
                oddCoconuts.add(i);
            }
        }
    }

    public LinkedList<Integer> getEvenCoconutsLinkedList() {
        return evenCoconuts;
    }

    public LinkedList<Integer> getOddCoconutsLinkedList() {
        return oddCoconuts;
    }

    public boolean addToOddLinkedList(LinkedList<Integer> oddCoconutsLinkedList) {
        return oddCoconuts.addAll(oddCoconutsLinkedList);
    }

    public boolean addToEvenLinkedList(LinkedList<Integer> evenCoconutsLinkedList) {
        return evenCoconuts.addAll(evenCoconutsLinkedList);
    }

    public void clearEvenCoconuts() {
        evenCoconuts.clear();
    }

    public void clearOddCoconuts() {
        oddCoconuts.clear();
    }

    public int getCoconutsAmount() {
        return evenCoconuts.size() + oddCoconuts.size();
    }

    public int getEvenGoesTo() {
        return evenGoesTo;
    }

    public int getOddGoesTo() {
        return oddGoesTo;
    }

    public String toString() {
        String output = "\nMacaco " + id + " par -> " + this.getEvenGoesTo() + " impar -> "
                + this.getOddGoesTo();
        output += " : " + this.getCoconutsAmount() + " : ";
        for (int number : this.getEvenCoconutsLinkedList()) {
            output += " " + number;
        }

        for (int number : this.getOddCoconutsLinkedList()) {
            output += " " + number;
        }
        return output;
    }
}
