import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Frog frog = new Frog();

        List<FrogCommands> commands = new ArrayList<>();
        int curCommand = -1;

        while (true) {

            System.out.println("Для управления лягушкой введите команду:\n" +
                    "+N - прыгни на N шагов направо\n" +
                    "-N - прыгни на N шагов налево\n" +
                    "<< - Undo (отмени последнюю команду)\n" +
                    ">> - Redo (повтори отменённую команду)\n" +
                    "!! - повтори последнюю команду\n" +
                    "0 - выход");
            String input = reader.readLine();

            switch (input) {
                case "0":
                    return;
                case "<<": {
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        //commands.get(curCommand).undo(????);
                        curCommand--;
                    }
                    break;
                }
                case ">>": {
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нечего повторять!");
                    } else {
                        curCommand++;
                        //commands.get(curCommand).doit(????);
                    }
                    break;
                }
                default: {
                    if (curCommand != commands.size() - 1) {
                        // удаляем все команды которые были отменены
                    }
                    FrogCommands cmd = new FrogCommands(
                            new DoItCommand(frog),
                            new UndoCommand(frog));
                    curCommand++;
                    commands.add(cmd);
                    cmd.doit(Integer.parseInt(input));
                }
            }
        }
    }
}

