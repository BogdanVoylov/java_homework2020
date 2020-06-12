package com.company;

public class Door extends Detail {
    private boolean closed;

    public Door(Car owner) {
        super(owner);
        closed = true;
    }

    public boolean isClosed() {
        return closed;
    }

    public void open() {
        closed = false;
    }

    public void close() {
        closed = true;
    }

    @Override
    public String toString() {
        return "Door:\n Is closed: "+isClosed();
    }
}
