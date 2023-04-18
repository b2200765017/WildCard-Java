import java.util.ArrayList;
import java.util.Objects;

public class Characters {
    public ArrayList<String> matchList = new ArrayList<>();

    public Integer getPoint(String str) {
        switch (str) {
            case "S":
                return 15;
            case "T":
                return 15;
            case "D":
                return 30;
            case "W":
                return 10;
            case "/":
                return 20;
            case "\\":
                return 20;
            case "+":
                return 20;
            case "-":
                return 20;
            case "|":
                return 20;
        }
        return null;
    }

    public Integer search1(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        try {
        int point = 0;
        if (pt == 0) {
            if (!Objects.equals(grid.get(col).get(line), " ")) {
                if (matchList.contains(grid.get(col - 2).get(line - 2))) {
                    if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col - 2).get(line - 2), "W"))
                    {
                        matchList.clear();
                        matchList.add("W");
                        matchList.add(grid.get(col - 2).get(line - 2));
                    }
                    if (matchList.contains(grid.get(col - 1).get(line - 1)))
                    {
                        point += getPoint(grid.get(col - 2).get(line - 2));
                        point += getPoint(grid.get(col - 1).get(line - 1));
                        point += getPoint(grid.get(col).get(line));
                        grid.get(col - 2).set(line - 2, " ");
                        grid.get(col - 1).set(line - 1, " ");
                        grid.get(col).set(line, " ");
                        Game.updateGame(col - 2, line - 2);
                        Game.updateGame(col - 1, line - 1);
                        Game.updateGame(col, line);
                    }
                }
            }
        }
        return point; // doldur
    } catch (Exception e) {
            return  0;
        }
    }

    public Integer search2(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        int point = 0;
        try{
            if (pt == 0) {
                if (!Objects.equals(grid.get(col).get(line), " ")) {
                    if (matchList.contains(grid.get(col - 1).get(line))) {
                        if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col - 1).get(line), "W"))
                        {
                            matchList.clear();
                            matchList.add("W");
                            matchList.add(grid.get(col - 1).get(line));
                        }
                        if (matchList.contains(grid.get(col - 2).get(line)))
                        {
                            point += getPoint(grid.get(col - 2).get(line));
                            point += getPoint(grid.get(col - 1).get(line));
                            point += getPoint(grid.get(col).get(line));
                            grid.get(col - 2).set(line, " ");
                            grid.get(col - 1).set(line, " ");
                            grid.get(col).set(line, " ");
                            Game.updateGame(col - 2, line);
                            Game.updateGame(col - 1, line);
                            Game.updateGame(col, line);
                        }
                    }
                }
            }
        return point;
        } catch (Exception e) {
            return  0;
        }
    }

    public Integer search3(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        int point = 0;
        try{
            if (pt == 0)
            {
                if (!Objects.equals(grid.get(col).get(line), " ")) {
                    if (matchList.contains(grid.get(col - 1).get(line + 1))) {
                        if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col - 1).get(line + 1), "W"))
                        {
                            matchList.clear();
                            matchList.add("W");
                            matchList.add(grid.get(col - 1).get(line + 1));
                        }
                        if (matchList.contains(grid.get(col - 2).get(line + 2)))
                        {
                            point += getPoint(grid.get(col - 2).get(line + 2));
                            point += getPoint(grid.get(col - 1).get(line + 1));
                            point += getPoint(grid.get(col).get(line));
                            grid.get(col - 2).set(line + 2, " ");
                            grid.get(col - 1).set(line + 1, " ");
                            grid.get(col).set(line, " ");
                            Game.updateGame(col - 2, line + 2);
                            Game.updateGame(col - 1, line + 1);
                            Game.updateGame(col, line);
                        }
                    }
                }
            }
        return point; // doldur
        } catch (Exception e) {
            return  0;
        }
    }

    public Integer search4(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        int point = 0;
        try{
            if (pt == 0)
            {
                if (!Objects.equals(grid.get(col).get(line), " ")) {
                    if (matchList.contains(grid.get(col).get(line - 2))) {
                        if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col).get(line - 2), "W"))
                        {
                            matchList.clear();
                            matchList.add("W");
                            matchList.add(grid.get(col).get(line - 2));
                        }
                        if (matchList.contains(grid.get(col).get(line - 1)))
                        {
                            point += getPoint(grid.get(col).get(line - 2));
                            point += getPoint(grid.get(col).get(line - 1));
                            point += getPoint(grid.get(col).get(line));
                            grid.get(col).set(line - 2, " ");
                            grid.get(col).set(line - 1, " ");
                            grid.get(col).set(line, " ");
                            Game.updateGame(col, line - 2);
                            Game.updateGame(col, line - 1);
                            Game.updateGame(col, line);
                        }
                    }
                }
            }
        return point; // doldur
        } catch (Exception e) {
            return  0;
        }
    }

    public Integer search6(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        int point = 0;
        try{
            if (pt == 0) {
                if (!Objects.equals(grid.get(col).get(line), " ")) {
                    if (matchList.contains(grid.get(col).get(line + 2))) {
                        if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col).get(line + 2), "W"))
                        {
                            matchList.clear();
                            matchList.add("W");
                            matchList.add(grid.get(col).get(line + 2));
                        }
                        if (matchList.contains(grid.get(col).get(line + 1)))
                        {
                            point += getPoint(grid.get(col).get(line + 2));
                            point += getPoint(grid.get(col).get(line + 1));
                            point += getPoint(grid.get(col).get(line));
                            grid.get(col).set(line + 2, " ");
                            grid.get(col).set(line + 1, " ");
                            grid.get(col).set(line, " ");
                            Game.updateGame(col, line + 2);
                            Game.updateGame(col, line + 1);
                            Game.updateGame(col, line);
                        }
                    }
                }
            }
        return point; // doldur
        } catch (Exception e) {
            return  0;
        }
    }

    public Integer search7(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        int point = 0;
        try{
            if (pt == 0) {
                if (!Objects.equals(grid.get(col).get(line), " ")) {
                    if (matchList.contains(grid.get(col + 1).get(line - 1))) {
                        if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col + 1).get(line - 1), "W"))
                        {
                            matchList.clear();
                            matchList.add("W");
                            matchList.add(grid.get(col+1).get(line - 1));
                        }
                        if (matchList.contains(grid.get(col + 2).get(line - 2)))
                        {
                            point += getPoint(grid.get(col + 2).get(line - 2));
                            point += getPoint(grid.get(col + 1).get(line - 1));
                            point += getPoint(grid.get(col).get(line));
                            grid.get(col + 2).set(line - 2, " ");
                            grid.get(col + 1).set(line - 1, " ");
                            grid.get(col).set(line, " ");
                            Game.updateGame(col, line);
                            Game.updateGame(col + 1, line - 1);
                            Game.updateGame(col + 2, line - 2);
                        }
                    }
                }
            }
        return point; // doldur
        } catch (Exception e) {
            return  0;
        }
    }

    public Integer search8(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        int point = 0;
        try{
            if ( pt == 0) {
                if (!Objects.equals(grid.get(col).get(line), " ")) {
                    if (matchList.contains(grid.get(col + 1).get(line))) {
                        if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col + 1).get(line + 1), "W"))
                        {
                            matchList.clear();
                            matchList.add("W");
                            matchList.add(grid.get(col+1).get(line));
                        }
                        if (matchList.contains(grid.get(col + 2).get(line)))
                        {
                            point += getPoint(grid.get(col + 2).get(line));
                            point += getPoint(grid.get(col + 1).get(line));
                            point += getPoint(grid.get(col).get(line));
                            grid.get(col + 2).set(line, " ");
                            grid.get(col + 1).set(line, " ");
                            grid.get(col).set(line, " ");
                            Game.updateGame(col, line);
                            Game.updateGame(col + 1, line);
                            Game.updateGame(col + 2, line);
                        }
                    }
                }
            }
        return point; // doldur
        } catch (Exception e) {
            return  0;
        }
    }

    public Integer search9(ArrayList<ArrayList<String>> grid, Integer col, Integer line, Integer pt) {
        int point = 0;
        try{
            if (pt == 0) {
                if (!Objects.equals(grid.get(col).get(line), " ")) {
                    if (matchList.contains(grid.get(col + 1).get(line + 1))) {
                        if (Objects.equals(grid.get(col).get(line), "W") & !Objects.equals(grid.get(col + 1).get(line + 1), "W"))
                        {
                            matchList.clear();
                            matchList.add("W");
                            matchList.add(grid.get(col+1).get(line + 1));
                        }
                        if (matchList.contains(grid.get(col + 2).get(line + 2)))
                        {
                            point += getPoint(grid.get(col + 2).get(line + 2));
                            point += getPoint(grid.get(col + 1).get(line + 1));
                            point += getPoint(grid.get(col).get(line));
                            grid.get(col + 2).set(line + 2, " ");
                            grid.get(col + 1).set(line + 1, " ");
                            grid.get(col).set(line, " ");
                            Game.updateGame(col, line);
                            Game.updateGame(col + 1, line + 1);
                            Game.updateGame(col + 2, line + 2);
                        }
                    }
                }
            }
        return point;
        } catch (Exception e) {
            return  0;
        }
    }
}
class Square extends Characters
{
    private int point = 0;
    public Square(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("S");
        point += search4(grid, col, line, point);
        point += search6(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class Triangle extends Characters
{
    private int point = 0;
    public Triangle(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("T");
        point += search2(grid, col, line, point);
        point += search8(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class Wildcard extends Characters
{
    private int point = 0;
    public Wildcard(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        setMatchList();
        point += search2(grid, col, line, point);
        setMatchList();
        point += search8(grid, col, line, point);
        setMatchList();
        point += search4(grid, col, line, point);
        setMatchList();
        point += search6(grid, col, line, point);
        setMatchList();
        point += search1(grid, col, line , point);
        setMatchList();
        point += search9(grid, col, line, point);
        setMatchList();
        point += search3(grid, col, line, point);
        setMatchList();
        point += search7(grid, col, line, point);
        setMatchList();
    }
    public void setMatchList()
    {
        if (matchList.size() == 2 |matchList.size() == 0)
        {
            matchList.clear();
            matchList.add("T");
            matchList.add("W");
            matchList.add("D");
            matchList.add("S");
        }
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class Diamond extends Characters
{
    private int point = 0;
    public Diamond(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("D");
        point += search1(grid, col, line, point);
        point += search9(grid, col, line, point);
        point += search3(grid, col, line, point);
        point += search7(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class div extends Characters
{
    private int point = 0;
    public div(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("/");
        matchList.add("-");
        matchList.add("+");
        matchList.add("\\");
        matchList.add("|");
        point += search3(grid, col, line, point);
        point += search7(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class sub extends Characters
{
    private int point = 0;
    public sub(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("/");
        matchList.add("-");
        matchList.add("+");
        matchList.add("\\");
        matchList.add("|");
        point += search4(grid, col, line, point);
        point += search6(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class sum extends Characters
{
    private int point = 0;
    public sum(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("/");
        matchList.add("-");
        matchList.add("+");
        matchList.add("\\");
        matchList.add("|");
        point += search4(grid, col, line, point);
        point += search6(grid, col, line, point);
        point += search2(grid, col, line, point);
        point += search8(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class revDiv extends Characters
{
    private int point = 0;
    public revDiv(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("/");
        matchList.add("-");
        matchList.add("+");
        matchList.add("\\");
        matchList.add("|");
        point += search1(grid, col, line, point);
        point += search9(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}
class orSign extends Characters
{
    private int point = 0;
    public orSign(ArrayList<ArrayList<String>> grid, Integer col, Integer line)
    {
        matchList.add("/");
        matchList.add("-");
        matchList.add("+");
        matchList.add("\\");
        matchList.add("|");
        point += search2(grid, col, line, point);
        point += search8(grid, col, line, point);
    }
    public Integer getPoint()
    {
        Integer temp = this.point;
        this.point = 0;
        return temp;
    }
}

