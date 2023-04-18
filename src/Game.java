import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    static FileManagement fm = new FileManagement();
    static ArrayList<ArrayList<String>> grid;


    ArrayList<Player> players = fm.leaderboard();

    public Game(String grids, String input) throws IOException {
        grid = fm.gameGrid(grids);
        String playerName;
        int point = 0;
        Scanner file = fm.openCommand(input); // open input file
        FileWriter monitor = fm.openMonitor();
        monitor.write("Game grid:\n\n");
        fm.showGrid(grid, monitor);
        while (file.hasNext()) // play indexes
        {
            String command = file.nextLine();
            if (command.equals("E")) // exit statement
            {
                monitor.write("Select coordinate or enter E to end the game: " + command + "\n\n");
                monitor.write("Total score: " + point + " points" + "\n\n");
                break;
            }
            else // play statement
            {
                monitor.write("Select coordinate or enter E to end the game: " + command + "\n\n");
                String[] spl = command.split(" ");
                Integer col = Integer.parseInt(spl[0]);
                Integer line = Integer.parseInt(spl[1]);
                String com;
                try {
                    com = grid.get(col).get(line);
                    if (col > 9 | col < 0 | line < 0 | line > 9 | Objects.equals(com, " ")) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    monitor.write("Please enter a valid coordinate\n\n");
                    continue;
                }
                int roundPoint = 0;
                switch (com) {
                    case "S":
                        Square s = new Square(grid, col, line);
                        roundPoint = s.getPoint();
                        break;
                    case "T":
                        Triangle t = new Triangle(grid, col, line);
                        roundPoint = t.getPoint();
                        break;
                    case "D":
                        Diamond d = new Diamond(grid, col, line);
                        roundPoint = d.getPoint();
                        break;
                    case "W":
                        Wildcard w = new Wildcard(grid, col, line);
                        roundPoint = w.getPoint();
                        break;
                    case "/":
                        div div = new div(grid, col, line);
                        roundPoint = div.getPoint();
                        break;
                    case "+":
                        sum sum = new sum(grid, col, line);
                        roundPoint = sum.getPoint();
                        break;
                    case "-":
                        sub sub = new sub(grid, col, line);
                        roundPoint = sub.getPoint();
                        break;
                    case "\\":
                        revDiv revDiv = new revDiv(grid, col, line);
                        roundPoint = revDiv.getPoint();
                        break;
                    case "|":
                        orSign orSign = new orSign(grid, col, line);
                        roundPoint = orSign.getPoint();
                        break;
                }
                point += roundPoint;
                fm.showGrid(grid, monitor);
                monitor.write("Score: " + roundPoint + " points\n\n");
            }

        }
        playerName = file.nextLine();
        Player player = new Player(playerName, point);
        player.outLeaderboard(players);
        player.compare(players);
        monitor.write("Enter name: "+ playerName +"\n\n");
        monitor.write(player.compareStr(players));
        monitor.write("Good bye!");


        fm.closeCommand(file); //close input file
        fm.closeMonitor(monitor); // close monitor file
    }



    public static void updateGame(Integer col, Integer line)
    {
        for(int i = col; i > 0; i--)
        {
            if (!Objects.equals(grid.get(i - 1).get(line), " "))
            {
                grid.get(i).set(line, grid.get(i - 1).get(line));
                grid.get(i - 1).set(line, " ");
            }
        }
    }

}
