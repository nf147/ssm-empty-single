package spring_basic.aop.proxy.p6;

public class ChinaBank {
    public float withdraw(float howmuch) {
        if (howmuch > 2000) {
            System.out.println("您没有那么大的额度，请重试");
        } else if (howmuch < 0) {
            System.out.println("取款必须要大于 0 元");
        } else {
            System.out.println("原先余额 - howmuch");
        }
        return howmuch;
    }
}
