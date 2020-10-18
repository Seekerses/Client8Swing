package client;

import gui.MainWindow;

public class UserSession {

    private static String login;
    private static String password;
    private static MainWindow mainWindow;

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        UserSession.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserSession.password = password;
    }

    public static MainWindow getMainWindow() {
        return mainWindow;
    }

    public static void setMainWindow(MainWindow mainWindow) {
        UserSession.mainWindow = mainWindow;
    }
}
