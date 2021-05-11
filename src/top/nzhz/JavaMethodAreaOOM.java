package top.nzhz;

//VM_Args:-XX:PermSize=10M -XX:MaxPermSize=10M

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            var enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(o,args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
