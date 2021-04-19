package ru.kisusil.icecreamrose.view;

public interface IO extends AutoCloseable {
    boolean hasNext();
    String readLine();
    void print(String string);
    void println(String string);
}
