package ru.kisusil.icecreamrose.view;

import java.io.*;
import java.util.Scanner;

public class Console implements IO {
    private final Scanner scanner;
    private final PrintWriter printWriter;

    public Console(InputStream inputStream, OutputStream outputStream) {
        this.scanner = new Scanner(inputStream);
        this.printWriter = new PrintWriter(outputStream);
    }

    public Console(Reader reader, OutputStream outputStream) {
        this.scanner = new Scanner(reader);
        this.printWriter = new PrintWriter(outputStream);
    }


    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String readLine() {
        if (scanner.hasNext()) {
            return scanner.nextLine().trim();
        }

        return "";
    }

    @Override
    public void print(String string) {
        printWriter.print(string);
        printWriter.flush();
    }

    @Override
    public void println(String string) {
        printWriter.println(string);
        printWriter.flush();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
