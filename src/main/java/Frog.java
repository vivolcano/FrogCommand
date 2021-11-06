import java.util.Arrays;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;
    protected int lastMove;
    protected String[] field = new String[]{" ", " ", " ", " ", " ", "X", " ", " ", " ", " ", " "};

    public Frog() {
        this.position = 5;
    }

    public boolean jump(int steps) {
        if ((MIN_POSITION <= this.position + steps) && (this.position + steps) <= MAX_POSITION) {
            this.position += steps;
            this.lastMove = steps;
            System.out.println("Лягушка прыгнула на " + steps + " клетку(ок), текущая позиция = " + this.position + ".");
            field = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
            field[position] = "X";
            printField(field);
            return true;
        } else {
            System.out.println("Лягушка не может прыгнуть за пределы поля. " +
                    "Текущая позиция = " + position + " из " + MAX_POSITION + ".");
            printField(field);
        }
        return false;
    }

    protected void printField(String[] field) {
        System.out.print("| ");
        for (String location : field) {
            System.out.print(location + " | ");
        }
        System.out.println("\n");
    }

}

