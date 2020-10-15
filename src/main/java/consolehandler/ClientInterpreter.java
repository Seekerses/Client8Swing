package consolehandler;



import client.RequestManager;
import clientserverdata.Reply;
import consolehandler.cmdLists.CommandList;
import consolehandler.cmdLists.StdCommandList;
import java.util.Arrays;

//client
/**
 * Class that takes a command from Controller and interpret it
 */
public class ClientInterpreter implements Interpreter {
    /**
     * Command List that Interpreter uses, changeable
     */
    private CommandList cmdList =  new StdCommandList();

    /**
     * This method takes the command, separate it on command and arguments
     * and then interpret command according to the current Command List
     * @param args Command
     * @return
     */
    @Override
    public Reply handle(String[] args) {
        if (cmdList.getCommands().containsKey(args[0])) {
            try {
                String[] arguments;
                if (args.length > 1) {
                    arguments = Arrays.copyOfRange(args,1,args.length);
                } else arguments = null;
                if (arguments != null) for (int i=0;i<= arguments.length-1;i++) {
                    if (";".equals(arguments[i])){
                        arguments[i] = "";
                    }
                }
                Reply res = RequestManager.makeRequest(cmdList.getCommands().get(args[0]),arguments);
                System.out.println(res.getAnswer());
                return res;
            } catch (NullPointerException e){
                e.printStackTrace();
                System.out.println("Wrong arguments...");
                return null;
            }
        }
        else {
            System.out.println("There is no such command. Enter help to see a list of available commands ..");
            return null;
        }
    }

    /**
     * This method change the Command List that concrete Interpreter uses
     * @param list New Command List
     */
    public void changeCommandList(CommandList list){
        cmdList = list;
    }
}