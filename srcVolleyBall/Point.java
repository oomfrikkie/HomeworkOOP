import java.time.LocalDate;
import java.time.LocalDateTime;

public class Point
{
    private Player scoringPlayer;
    private LocalDateTime scoringTime;

    public Point ( Player scoringPlayer, LocalDateTime scoringTime )
    {
        this.scoringPlayer = scoringPlayer;
        this.scoringTime = scoringTime;
    }

    public LocalDateTime getScoringTime()
    {
        return this.scoringTime;
    }

    public void setScoringTime(LocalDateTime scoringTime)
    {
        this.scoringTime = scoringTime;
    }

    public Player getScoringPlayer()
    {
        return this.scoringPlayer;
    }

    public void setScoringPlayer(Player scoringPlayer)
    {
        this.scoringPlayer = scoringPlayer;
    }

}
