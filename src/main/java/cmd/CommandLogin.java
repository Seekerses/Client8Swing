package cmd;

import client.UserSession;

import java.io.IOException;
import java.util.Scanner;

public class CommandLogin implements Command, Preparable, Registerable {

    private String login;
    private String password;
    private static final long serialVersionUID = 1337000051L;

    @Override
    public String execute(String[] args) throws IOException {
        //Логика запроса к БД
        return "Approved";
    }

    @Override
    public void prepare(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter login:\n>");
        login = scanner.next().trim();
        System.out.print("Enter password:\n>");
        password = scanner.next().trim();
    }
}
