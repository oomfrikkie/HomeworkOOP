import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Match
{
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;
    private List<Point> pointsScored;


    public Match( Team team1, Team team2)
    {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = 0;
        this.team2Score = 0;
        this.pointsScored = new ArrayList<>();

    }

    public Match( Team team1 , Team team2 , int team1Score, int team2Score )
    {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;

    }

    public Team getTeam1()
    {
        return this.team1;
    }

    public void setTeam1(Team team1)
    {
        this.team1 = team1;
    }

    public Team getTeam2()
    {
        return this.team2;
    }

    public void setTeam2(Team team2)
    {
        this.team2 = team2;
    }

    public int getTeam1Score()
    {
        return this.team1Score;
    }

    public void setTeam1Score(int team1Score)
    {
        this.team1Score = team1Score;
    }

    public int getTeam2Score()
    {
        return this.team2Score;
    }

    public List<Point> getPointsScored()
    {
        return this.pointsScored;
    }

    public void setPointsScored( List<Point> pointsScored )
    {
        if(!pointsScored.isEmpty())
        {
            this.pointsScored = pointsScored;
        }

        this.pointsScored = new ArrayList<>();
    }

    public int getAmountOfPointsScored()
    {
        return this.pointsScored.size();
    }

    public void setTeam2Score(int team2Score)
    {
        this.team2Score = team2Score;
    }



    public int getPointDifference()
    {
        int pointDifference = 0;

        if(team1Score > team2Score)
        {
             pointDifference = team1Score - team2Score;
        }
        else if (team2Score > team1Score)
        {
             pointDifference = team2Score - team1Score;
        }

        return pointDifference;
    }

    public boolean isMatchOver()
    {

        return (team1Score >= 25 || team2Score >= 25 ) && this.getPointDifference() >= 2;
    }

    public void addPoint( Player scoringPlayer , LocalDateTime scoringTime)
    {
        if(!this.isMatchOver())
        {
            if(this.team1.getPlayers().contains( scoringPlayer ))
            {
                team1Score ++;
            }
            else if(this.team2.getPlayers().contains( scoringPlayer ))
            {
                team2Score++;
            }
            else
            {
                throw new IllegalArgumentException("Player is not in any of the teams");
            }

            this.pointsScored.add( new Point(scoringPlayer, scoringTime));
        }
        else
        {

            throw new IllegalStateException("Cannot add points , match is over");
        }
    }

    public Team getWinner() {
        if (!this.isMatchOver()) {
            throw new IllegalStateException("Match is not over yet");
        }

        Team winner = team1Score > team2Score ? team1 : team2;
        winner.increaseMatchesWon();

        return winner;
    }


    public Team getLoser()
    {
        if(!this.isMatchOver())
        {
            throw new IllegalStateException("Match is not over yet");
        }

        return team1Score < team2Score ? this.team1 : this.team2;
    }

    public int getWinningScore()
    {
        if(!this.isMatchOver())
        {
            throw new IllegalStateException("Match is not over yet");
        }

        return team1Score > team2Score ? this.team1Score : this.team2Score;
    }

    public int getLosingScore()
    {
        if(!this.isMatchOver())
        {
            throw new IllegalStateException("Match is not over yet");
        }

        return team1Score < team2Score ? this.team1Score : this.team2Score;
    }







}
