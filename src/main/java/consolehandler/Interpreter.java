package consolehandler;

import clientserverdata.Reply;

import java.io.IOException;

/**
 * Interface for all interpreters
 */
public interface Interpreter {
    /**
     * This method takes the command from Controller and interpret it according to the current command list
     * @param args Command
     * @throws IOException If an I/O error occurs
     * @return
     */
    Reply handle(String[] args) throws IOException;

}