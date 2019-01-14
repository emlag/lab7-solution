import java.util.Scanner;

/**
 * TODO 10: Recursively reproduce the patterns found in "patterns.png".
 * You can use any colors or borders that you want, as long as the patterns are correct.
 * User a 2.2:1 ratio.
 * HINT: One of the patterns has been implemented.
 */

public class RecursiveSquares
{

    // plot a square, centered on (x, y) of the given side length
    // with a light gray background and black border
    public static void drawSquare(double x, double y, double size)
    {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, size / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, size / 2);
    }
    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length
    public static void pattern1(int n, double x, double y, double size)
    {
        if (n == 0) return;
        // 2.2 ratio looks good
        double ratio = 2.2;
        // recursively draw 4 smaller trees of order n-1
        pattern1(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        pattern1(n-1, x - size/2, y + size/2, size/ratio);    // upper left
        pattern1(n - 1, x + size / 2, y - size / 2, size / ratio);    // lower right
        pattern1(n-1, x + size/2, y + size/2, size/ratio);    // upper right
        drawSquare(x, y, size); //draw the square when it gets to the smallest size
    }

    public static void pattern2(int n, double x, double y, double size)
    {
        if (n == 0) return;
        // 2.2 ratio looks good
        double ratio = 2.2;
        // recursively draw 4 smaller trees of order n-1
        pattern2(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        pattern2(n-1, x - size/2, y + size/2, size/ratio);    // upper left
        pattern2(n-1, x + size/2, y + size/2, size/ratio);    // upper right
        drawSquare(x, y, size); //draw the other squares first, then draw the lower right
        pattern2(n - 1, x + size / 2, y - size / 2, size / ratio);    // lower right
    }

    public static void pattern3(int n, double x, double y, double size)
    {
        if (n == 0) return;
        // 2.2 ratio looks good
        double ratio = 2.2;
        // recursively draw 4 smaller trees of order n-1

        drawSquare(x, y, size);
        pattern3(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        pattern3(n-1, x - size/2, y + size/2, size/ratio);    // upper left
        pattern3(n-1, x + size / 2, y - size / 2, size / ratio);    // lower right
        pattern3(n-1, x + size/2, y + size/2, size/ratio);    // upper right
    }

    public static void pattern4(int n, double x, double y, double size)
    {
        if (n == 0) return;
        drawSquare(x, y, size);
        // 2.2 ratio looks good
        double ratio = 2.2;
        // recursively draw 4 smaller trees of order n-1

        pattern4(n-1, x - size/2, y + size/2, size/ratio);    // upper left
        pattern4(n-1, x + size/2, y + size/2, size/ratio);    // upper right
        drawSquare(x, y, size); //draw the other squares first, then draw lower left and right
        pattern4(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        pattern4(n-1, x + size / 2, y - size / 2, size / ratio);    // lower right
    }



    // read in an integer command-line argument n and plot an order n recursive
    // squares pattern
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("How many recursive squares do you want to draw? (Provide a positive integer)");
        int n = reader.nextInt();
        System.out.println("Which pattern would you like? (Provide positive integer)");
        int p = reader.nextInt();
        double x = 0.5, y = 0.5;   // center of square
        double size = 0.5;         // side length of square

        switch (p)
        {
            case 1:
                pattern1(n, x, y, size);
                break;
            case 2:
                pattern2(n, x, y, size);
                break;
            case 3:
                pattern3(n, x, y, size);
                break;
            case 4:
                pattern4(n, x, y, size);
                break;
        }

    }
}





