public class DoItCommand implements Command {

    private Frog frog;

    public DoItCommand(Frog frog) {
        this.frog = frog;
    }

    @Override
    public boolean run(int steps) {
        return frog.jump(steps);
    }
}
