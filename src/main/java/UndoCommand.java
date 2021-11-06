public class UndoCommand implements Command {

    private Frog frog;

    public UndoCommand(Frog frog) {
        this.frog = frog;
    }

    @Override
    public boolean run(int steps) {
        return frog.jump(-steps);
    }
}
