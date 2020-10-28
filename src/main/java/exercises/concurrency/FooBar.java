package exercises.concurrency;

public class FooBar {
    private int n;
    private boolean fooFlag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!fooFlag) {
                wait();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooFlag = !fooFlag;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (fooFlag) {
                wait();
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooFlag = !fooFlag;
            notifyAll();
        }
    }
}