package classwork;

import java.util.ArrayList;
import java.util.Objects;

public class Vertex {

    int number;
    boolean visit;

    public Vertex(int number) {
        this.number = number;
        visit = false;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
