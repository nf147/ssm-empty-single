package the_aop.proxy.p6;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setClassLoader(Thread.currentThread().getContextClassLoader());
//        enhancer.setSuperclass(ChinaBank.class);
//        enhancer.setCallback(new CGRecordProxyGenerator());
//
//        ChinaBank bankWithRecord = (ChinaBank) enhancer.create();
//        bankWithRecord.withdraw(300);

        ChinaBank bankWithRecord = (ChinaBank) Enhancer.create(ChinaBank.class, null, new CGRecordProxyGenerator());
        bankWithRecord.withdraw(233);
        System.out.println(64 >>> 2);
    }
}
