import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static int curCommand = -1;

    public static void main(String[] args) {

        Frog frog = new Frog();
        List<FrogCommands> commands = new ArrayList<>();

        startMessage();
        frogJumper(frog, commands);

    }

    private static void startMessage() {
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

    private static void frogJumper(Frog frog, List<FrogCommands> commands) {
        while (true) {
            String input = SCANNER.nextLine();

            switch (input) {
                case "0" -> {
                    return;
                }
                case "<<" -> { // отмена команды
                    if (curCommand < 0) {
                        System.out.println("Нечего отменить!");
                    } else {
                        if (commands.get(curCommand).undo()) curCommand--;
                    }
                }
                case ">>" -> { // возврат отмененной команды
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нет отмененной операции!");
                    } else {
                        if (commands.get(curCommand + 1).doit()) curCommand++;
                    }
                }
                case "!!" -> { // повтор команды
                    if (curCommand < 0) {
                        System.out.println("Нечего повторить!");
                    } else {
                        if (commands.get(commands.size() - 1).doit()) {
                            commands.add(commands.get(commands.size() - 1));
                            curCommand++;
                        }
                    }
                }
                default -> { // ход, добавление команды
                    FrogCommands cmd = new FrogCommands(
                            new DoItCommand(frog),
                            new UndoCommand(frog),
                            Integer.parseInt(input)
                    );

                    if (cmd.doit()) {
                        if (curCommand != commands.size() - 1) {
                            if (commands.size() > curCommand + 1) {
                                commands.subList(curCommand + 1, commands.size()).clear();
                            }
                        }
                        curCommand++;
                        commands.add(cmd);
                    }
                }
            }
        }
    }
}




