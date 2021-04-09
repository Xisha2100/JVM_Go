package top.nzhz;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject {
        static int a=5;
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
