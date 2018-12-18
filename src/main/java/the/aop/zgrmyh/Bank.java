package the.aop.zgrmyh;


import org.springframework.stereotype.Component;

@Component
public class Bank {
    // void Bank.withdraw(float);
    public float withdraw (float howmuch) {
        if (howmuch > 4000) {
            System.out.println("您没有那么大的额度，请重试");
        } else if (howmuch < 0) {
            System.out.println("取款必须要大于 0 元");
        } else {
            System.out.println("原先余额 - xxx - 取出来 " + howmuch + " 元");
        }
        return howmuch;
    }

    // void Bank.withdraw(float, int);
    public void withdraw (float howmuch, int others) {
    }
}
