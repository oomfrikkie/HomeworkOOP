import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private List<Team> teams;

    public Tournament() {
        this.teams = new ArrayList<>();
    }

    public List<Team> getTeams()
    {
        return this.teams;
    }

    public void setTeams( List<Team> teams)
    {
        if(!teams.isEmpty())
        {
            this.teams = teams;
        }

        this.teams = new ArrayList<>();
    }
    public void addTeam(Team team) {
        this.teams.add(team);
    }


    public Team getTournamentWinner() {
        Team winner = null;

        for (Team team : teams) {
            if (winner == null || team.getMatchesWon() > winner.getMatchesWon()) {
                winner = team;
            }
        }

        return winner;
    }
}
