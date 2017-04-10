import java.util.Scanner;

public class BouncingBalls
{
    public static final int maxX = 15;
    public static final int maxY = 130;
    public static final int maxBalls = 10;

    public static void main(String[] args) throws Exception
    {
        Ball ball[] = new Ball[maxBalls];
        for (int i = 0; i < maxBalls; i++)
        {
            int x = (int) (maxX * Math.random() + 1);
            int y = (int) (maxY * Math.random() + 1);
            ball[i] = new Ball(x, y);
        }
        while (true)
        {
            for (int i = 0; i < maxBalls; i++)
            {
                ball[i].simulate();
            }
            Ball.display();
        }
    } // end of main
} // end of class

// ************************************************************

class Ball
{
    Scanner stdIn = new Scanner(System.in);
    private int x, y;
    private final static int maxX = BouncingBalls.maxX;
    private final static int maxY = BouncingBalls.maxY;
    private int vx = Math.random() > .5 ? 1 : -1;
    private int vy = Math.random() > .5 ? 1 : -1;
    private static char[][] table = new char[maxX + 1][maxY + 1];

    public static void display() throws Exception
    {
        for (int x = 0; x < maxX; x++)
        {
            for (int y = 0; y < maxY; y++)
            {
                System.out.print(table[x][y]);
            }
            System.out.println();
        }
        Thread.sleep(80); // sleep
        for (int x = 0; x < maxX; x++)
        {
            for (int y = 0; y < maxY; y++)
            {
                table[x][y] = ' ';
            }
            System.out.println();
        }
    } // end of display

    public Ball(int x, int y)
    {
        this.x = x;
        this.y = y;
    } // end of constructor

    public void simulate() throws Exception
    {
        vx = x == 0 ? 1 : x == maxX ? -1 : vx;
        vy = y == 0 ? 1 : y == maxY ? -1 : vy;
        x += vx;
        y += vy;
        for (int x = 0; x < maxX; x++)
        {
            for (int y = 0; y < maxY; y++)
            {
                if (this.x == x && this.y == y)
                {
                    table[x][y] = '0';
                }
            }
        }
    } // end of simulate
} // end of Ball

