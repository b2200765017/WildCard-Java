import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Player implements Comparable<Player>
{
    private String name;
    private Integer point;

    public Player(String name, Integer point)
    {
        this.name = name;
        this.point = point;
    }
    public String compareStr(ArrayList<Player> players)
    {
        String compareString = "";
        Integer place = players.indexOf(this) + 1;
        if (place == 1)
        {
            Integer high = this.point - players.get(place).point;
            compareString += "Your rank is " + place + "/" + players.size() + " your score is " +
                    high + " points higher than " + players.get(place).name + "\n\n";
        }
        else if (place == players.size())
        {
            Integer low = players.get(place - 2).point - this.point;
            compareString += "Your rank is " + place + "/" + players.size() + " your score is " +
                    low + " points lower than " + players.get(place - 2).name + "\n\n";
        }
        else
        {
            Integer low = players.get(place - 2).point - this.point;
            Integer high = this.point - players.get(place).point;
            compareString += "Your rank is " + place + "/" + players.size() + " your score is " +
                    low + " points lower than " + players.get(place - 2).name + " and " +
                high + " points higher than " + players.get(place).name + "\n\n";
        }
        return compareString;
    }
    public void compare(ArrayList<Player> players)
    {
        Collections.sort(players, Collections.reverseOrder());
    }
    public void outLeaderboard(ArrayList<Player> players) throws IOException {
        FileWriter outLeaderboard = new FileWriter("leaderboard.txt", true);
        players.add(this);
        outLeaderboard.write("\n" + this.name + " " + this.point + "\n");
        outLeaderboard.close();
    }

    public Integer getPoint() {
        return point;
    }

    @Override
    public int compareTo(Player o) {
        if (this.getPoint().equals(o.getPoint())) return 0;
        return this.getPoint().compareTo(o.getPoint());
    }
}
