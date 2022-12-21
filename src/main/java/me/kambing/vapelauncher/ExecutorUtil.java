package me.kambing.vapelauncher;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExecutorUtil {
    public static void executeCommand(String command) {
        try {
            log(command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss:SSS");

    private static synchronized void log(String message) {
        System.out.println(format.format(new Date()) + ": " + message);
    }

}