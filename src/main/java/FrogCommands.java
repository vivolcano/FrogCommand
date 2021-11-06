public class FrogCommands {

    private Command doit, undo;

    public FrogCommands(Command doit, Command undo) {
        this.doit = doit;
        this.undo = undo;
    }

    public void doit(int steps){
        doit.run(steps);
    }

    public void undo(int steps){
        undo.run(steps);
    }


}
