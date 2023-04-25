package model;

import java.time.LocalDateTime;

public class Player implements Comparable<Player> {
    private int guessCount;

    public int getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }
    @Override
    public int compareTo(Player o) {
        int compareQuantity = ((Player) o).getGuessCount();

        //ascending order
        return this.guessCount - compareQuantity;

    }
}