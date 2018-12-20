package the.aop.proxy.p2;

public class GirlProxy implements Sleepable {
    private final Sleepable girl;

    public GirlProxy(Sleepable g) {
        this.girl = g;
    }

    @Override
    public void sleep() {
        System.out.println("苍茫的。。。我的爱");
        girl.sleep();
    }
}
