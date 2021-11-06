public class UndoCommand implements Command {

    private Frog frog;

    public UndoCommand(Frog frog) {
        this.frog = frog;
    }

    @Override
    public void run(int steps) {
        System.out.println("Отмена хода!");

        frog.jump(-frog.lastMove);
    }
}
