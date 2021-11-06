public class DoItCommand implements Command {

    private Frog frog;

    public DoItCommand(Frog frog) {
        this.frog = frog;
    }

    @Override
    public void run(int steps) {
        frog.jump(steps);
    }
}
