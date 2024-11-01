package com.github.fabriciolfj.lazyiniti;

public class Connection {

    private Connection() { }

    public static Connection get() {
        class LazyConnection {
            private static final Connection INSTANCE = new Connection();

            static {
                System.out.println("Creating Connection");}
        }
        return LazyConnection.INSTANCE;
    }

}
