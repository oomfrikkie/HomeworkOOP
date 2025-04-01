import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team {

    private String teamName;
    private List<Player> players;
    private int matchesWon;  // New field to track the number of matches won

    public Team(String teamName, List<Player> players) {
        this.teamName = teamName;
        setPlayers(players);
        this.matchesWon = 0;  // Initialize the matchesWon field to 0
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        if (!players.isEmpty()) {
            this.players = players;
        } else {
            this.players = new ArrayList<>();
        }
    }

    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public void removePlayer(Player player) {
        Iterator<Player> iterator = players.iterator();

        while (iterator.hasNext()) {
            Player currentPlayer = iterator.next();
            if (currentPlayer == player) {
                iterator.remove();
                return;
            }
        }
    }

    // Getter for the number of matches won
    public int getMatchesWon() {
        return matchesWon;
    }

    // Increment the matchesWon count when a match is won
    public void increaseMatchesWon() {
        this.matchesWon++;
    }

    // Optionally, you could reset the matchesWon count (if required in some cases)
    public void resetMatchesWon() {
        this.matchesWon = 0;
    }
}
