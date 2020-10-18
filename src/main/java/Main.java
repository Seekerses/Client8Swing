import consolehandler.*;
import gui.Registration;

public class Main {

    public static void main(String[] args) {

        Registration.main(null);

        System.out.print("\n");

        TableManager prodTable = new TableManager("products");
        TableController.setCurrentTable(prodTable);

        CommandController cmd = new CommandController();
        cmd.start(new ClientInterpreter());
        cmd.stop();
    }

}
