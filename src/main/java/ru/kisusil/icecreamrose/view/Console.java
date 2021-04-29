package ru.kisusil.icecreamrose.view;

import java.io.*;

public class Console implements IO {
    private final java.util.Scanner scanner;
    private final PrintWriter printWriter;

    public Console(InputStream inputStream, OutputStream outputStream) {
        this.scanner = new java.util.Scanner(inputStream);
        this.printWriter = new PrintWriter(outputStream);
    }

    @Override
    public String readLine() {
        return scanner.nextLine().trim();
    }

    @Override
    public void println(String string) {
        printWriter.println(string);
        printWriter.flush();
    }
}
