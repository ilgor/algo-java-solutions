public class MazeGame
{
    private final static int MAXROW = 20;
    private final static int MAXCOL = 30;
    private final char maze[][] = new char[MAXROW + 1][MAXCOL + 1];
    private final int flag[][] = new int[MAXROW + 1][MAXCOL + 1];
    private final int x, y;
    private boolean found = false;
    private final int solution_count = 1;

    public MazeGame(char maze[][], int x, int y)
    {
        for (int i = 0; i < MAXROW; i++)
        {
            for (int j = 0; j < MAXCOL; j++)
            {
                this.maze[i][j] = maze[i][j];
            }
        } // end of for

        this.x = x;
        this.y = y;
    } // end of constructor

    // *******************************************

    void display()
    {
        for (int i = 0; i < MAXROW; i++)
        {
            for (int j = 0; j < MAXCOL; j++)
            {
                System.out.print(flag[i][j]);
            } // end of inner for loop
            System.out.println();
        } // end of outer for loop
        System.out.println("------------------------------");
    } // end of display

    // *******************************************

    public void play() throws Exception
    {
        if (search(x, y))
        {
            System.out.println("FOUND");
        } else
        {
            System.out.println("NOT FOUND");
        }

    } // end of play

    // *******************************************

    boolean search(int x, int y) throws Exception
    {
        while (!found)
        {
            flag[x][y]++;
            display();
            Thread.sleep(10);

            if (maze[x][y] == 'F')
            {
                flag[x][y] = 999;
                return true;
            } else if (maze[x][y] == '|' || maze[x][y] == '-' || maze[x][y] == 'X' || flag[x][y] >= 4)
            {
                return false;
            }

            found = search(x - 1, y);
            found = search(x, y + 1);
            found = search(x, y - 1);
            found = search(x + 1, y);
        }
        return found;
    } // end of search
} // end of class
