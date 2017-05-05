/**
 * Created by zacharyvargas on 5/4/17.
 */
public class TrafficLightDemo {
    enum TrafficLightColor
    {
        RED, GREEN, YELLOW
    }
}

class TrafficLightSimulator implements Runnable
{
    private Thread thrd;
    private TrafficLightDemo.TrafficLightColor tlc;
    boolean stop = false;
    boolean changed = false;

    TrafficLightSimulator(TrafficLightDemo.TrafficLightColor init)
    {
        tlc = init;
        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator()
    {
        tlc = TrafficLightDemo.TrafficLightColor.RED;
        thrd = new Thread(this);
        thrd.start();
    }

    public void run()
    {
        while (!stop)
        {
            try{
                switch (tlc)
                {
                    case GREEN:
                        Thread.sleep(10000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                    case RED:
                        Thread.sleep(12000);
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeColor();
        }
    }

    synchronized void changeColor()
    {
        switch (tlc)
        {
            case RED:
                tlc = TrafficLightDemo.TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightDemo.TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightDemo.TrafficLightColor.YELLOW;
        }

        changed = true;
        notify();
    }

    synchronized void waitForChange()
    {
        try {
            while (!changed)
            {
                wait();
            }
            changed = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized TrafficLightDemo.TrafficLightColor getColor()
    {
        return tlc;
    }

    synchronized void cancel()
    {
        stop = true;
    }
}

class TrafficLight
{
    public static void main(String[] args)
    {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightDemo.TrafficLightColor.GREEN);

        for(int i=0; i < 9; i++)
        {
            System.out.println(t1.getColor());
            t1.waitForChange();
        }

        t1.cancel();
    }
}
