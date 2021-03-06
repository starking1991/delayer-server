package client;
/**
 * Created by zp on 17/5/8.
 */
public class DelayService {
    private static AbstractFutureSchedule schedule;
    static {
        schedule = new RocketMqSchedule();
        schedule.start();
    }


    public boolean registerDelayAnnouncement(long id,long futureTime){
        return schedule.register(futureTime,Stub.toBytes("delayAnnouncement", String.valueOf(id)));
    }

    public boolean delayAnnouncement(String idStr){
        long id = Long.parseLong(idStr);
        System.out.println("test announcement " +idStr);
        return true;
    }

}
