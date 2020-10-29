package cmd;

import consolehandler.Outputer;

import java.util.Arrays;

/**
 * Get info about all commands
 *
 *
 */

public class CommandHelp implements Command, Local {

    private static final long serialVersionUID = 1337000008L;

    @Override
    public String execute(String[] args){
        try {
            if (args.length == 1) {
                return ("There is no args for this command!");
            }
        }catch (NullPointerException e){
            return (Outputer.getString("HelpOutput") + "\n" + Outputer.getString("InfoOutput") + "\n" + Outputer.getString("ShowOutput") + "\n" + Outputer.getString("InsertOutput") + "\n" + Outputer.getString("RemoveOutput") + "\n" + Outputer.getString("ScriptOutput") + "\n" + Outputer.getString("LowerOutput") + "\n" + Outputer.getString("GroupOutput") + "\n" + Outputer.getString("ReplaceOutput") + "\n" + Outputer.getString("FilterOutput") + "\n" + Outputer.getString("MinOutput") + "\n" + Outputer.getString("ClearOutput") + "\n" + Outputer.getString("ExitOutput") + "\n" + Outputer.getString("HistoryOutput"));
        }
        return null;
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "help";
    }
}