package Task1;

class Time {
    int time = 0;
    boolean isDelivered = false;

    public synchronized void setTime(int time) {
        this.time = time;
        isDelivered = false;
        notify();
    }

    public synchronized int getTime() {
        while (isDelivered) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isDelivered = true;
        return time;
    }
}