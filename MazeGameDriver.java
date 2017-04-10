public class MazeGameDriver
{
    public static void main(String[] args) throws Exception
    {
        final int MAZE_ROWS = 20;
        final int MAZE_COLS = 30;
        // One extra column is needed for the null character.
        String k[] =
                { " ---------------------------- ", 
                "|XXXXXXXXXXXXXXXXXXXXXXXXXXXX|", 
                "|XXX                         |",
                "|XXX XXXXX XXXXXXXXXXXXXXXXXX|", 
                "|XXX       XXXXXXXXXXXXXXXXXX|", 
                "|XXX XXXXX XXXXXXXXXXXXXXXXXX|",
                "|XXX XXXXX                  X|", 
                "|S   XXXXXXXXXXXXXXXXXXXXXX X|", 
                "| XX XXXXXXXXXXXXXXXXXXXXXX X|",
                "| XXXXXXXXXXXXX    FXXXXXXX X|", 
                "|    XXXXXXXXXXXXXX XXXXXXXXX|", 
                "|XXX XXXXXXXXXXXXXX XXXXXXXXX|",
                "|XXX         XXXXXX   XXXXXXX|", 
                "|XXX XXXXXXX XXXXXX   XXXXXXX|", 
                "|XXX XXXXXXX XXXXXXXX XXXXXXX|",
                "|XXX     XXX XXXXXXXX       X|", 
                "|XXX XXX XXX XXXXXXXX XXXXXXX|", 
                "|XXX     XXX          XXXXXXX|",
                "|XXXXXXXXXXXXXXXXXXXXXXXXXXXX|", 
                " ---------------------------- " };

        char maze[][] = new char[MAZE_ROWS][MAZE_COLS];
        for (int i = 0; i < MAZE_ROWS; i++)
        {
            for (int j = 0; j < MAZE_COLS; j++)
            {
                maze[i][j] = k[i].charAt(j);
            }
        }

        MazeGame mazeGame = new MazeGame(maze, 7, 1);
        mazeGame.play();
    } // end main
}
