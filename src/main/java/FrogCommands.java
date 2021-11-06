public class FrogCommands {

    private Command doit;
    private Command undo;
    private int steps;

    public FrogCommands(Command doit, Command undo, int steps) {

        this.doit = doit;
        this.undo = undo;
        this.steps = steps;
    }

    public boolean doit(){

        return doit.run(this.steps);
    }

    public boolean undo(){

        return undo.run(this.steps);
    }

    @Override
    public String toString() {
        return "FrogCommands{" +
                "doit=" + doit +
                ", undo=" + undo +
                ", steps=" + steps +
                '}';
    }
}
