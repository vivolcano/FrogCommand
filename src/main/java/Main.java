import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static int curCommand = -1;

    public static void main(String[] args) {

        Frog frog = new Frog();
        List<FrogCommands> commands = new ArrayList<>();

        System.out.println("TEST");

        while (true) {
            String input = SCANNER.nextLine();

            switch (input) {
                case "back": { //работает!!!
                    if (curCommand < 0) {
                        System.out.println("Нечего отменить");
                    } else {
                        if (commands.get(curCommand).undo()) curCommand--;
                        System.out.println("Отмена последней операции");
                        System.out.println("curCommand = " + curCommand);
                        commands.stream().forEach(System.out::println);
                    }
                    break;
                }

                case "backback": {
                    if (curCommand == commands.size() - 1) {
                        System.out.println("нечего потворить");
                    }
                    break;
                }


                case "repeat": { //работает!!!
                    if (curCommand < 0) {
                        System.out.println("Нечего повторить");
                    } else {
                        if (commands.get(commands.size() - 1).doit()) {
                            commands.add(commands.get(commands.size() - 1));
                            curCommand++;
                            System.out.println("Повтор последней операции");
                            System.out.println("curCommand = " + curCommand);
                            commands.stream().forEach(System.out::println);
                        }
                    }
                    break;
                }
                default: { //работает!!!
                    FrogCommands cmd = new FrogCommands(
                            new DoItCommand(frog),
                            new UndoCommand(frog),
                            Integer.parseInt(input)
                    );

                    System.out.println("curCommand = " + curCommand);
                    if (cmd.doit()) {
                        if (curCommand != commands.size() - 1) {
                            for (int i = commands.size() - 1; i != curCommand; i--) {
                                commands.remove(i);
                            }
                        }
                        curCommand++;
                        System.out.println("curCommand = " + curCommand);
                        commands.add(cmd);
                    }

                    commands.stream().forEach(System.out::println);
                }
            }

        }








    }
    private static void startMessage () {
        System.out.print("""
                    Для управления лягушкой введите команду:
                    + N --> прыгни на N шагов направо
                    - N --> прыгни на N шагов налево
                     << --> Undo (отмени последнюю команду)
                     >> --> Redo (повтори отменённую команду)
                     !! --> повтори последнюю команду
                      0 --> выход
                    %%:\s""");
    }
}




