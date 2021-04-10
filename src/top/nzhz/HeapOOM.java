package top.nzhz;
//VM_Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
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
