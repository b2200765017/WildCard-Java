import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileManagement
{
    public ArrayList<ArrayList<String>> gameGrid(String grids) throws FileNotFoundException  // makes the game grid
    {
        Scanner gridFile = new Scanner(new File(grids));
        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        for ( int i = 0; i < 10; i++)
        {
            String line = gridFile.nextLine().trim();
            ArrayList<String> lineList = new ArrayList<>(Arrays.asList(line.split(" ")));
            grid.add(lineList);
        }
        return grid;
    }
    public ArrayList<Player> leaderboard() throws FileNotFoundException
    {
        Scanner LeaderboardFile = new Scanner(new File("leaderboard.txt"));
        ArrayList<Player> players = new ArrayList<>();
        while (LeaderboardFile.hasNext())
        {
            Player newPlayer;
            String[] personList = LeaderboardFile.nextLine().trim().split(" ");
            newPlayer = new Player(personList[0], Integer.parseInt(personList[1]));
            players.add(newPlayer);
        }
        return players;
    }
    public Scanner openCommand(String fileSrc) throws FileNotFoundException {
        return new Scanner(new File(fileSrc));
    }
    public void closeCommand(Scanner sc) {
        sc.close();
    }
    public FileWriter openMonitor() throws IOException {
        return new FileWriter("monitoring.txt");
    }
    public void closeMonitor(FileWriter sc) throws IOException {
        sc.close();
    }
    public void showGrid(ArrayList<ArrayList<String>> grid, FileWriter monitor ) throws IOException {
        for (ArrayList<String> line : grid)
        {
            for (String ch : line)
            {
                monitor.write(ch + " ");
            }
            monitor.write("\n");
        }
        monitor.write("\n");
    }
}
