package logic.utils;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;
import javax.management.Notification;
import java.io.Serializable;
import java.util.Objects;

/**
 * Позволяет отслеживать количество всех точек в рамках сессии и количество попаданий в О.Д.З.
 * @author Артемий Кульбако
 * @version 1.1
 */
@ManagedResource
@Component
public class ClicksMBean implements NotificationPublisherAware, Serializable {

    private final static long SerialVersionUID = 4L;
    private NotificationPublisher notificationPublisher;
    private int shots;
    private int hits;
    private int seq;

    @ManagedAttribute public int getShots() { return shots; }

    @ManagedAttribute public int getHits() { return hits; }

    public void takeAShot(boolean isHit) {
        shots++;
        if (isHit) hits++;
        if (shots % 10 == 0) notificationPublisher.sendNotification(new Notification("Achieved mod 10 shots",
                this, seq++, System.currentTimeMillis(), "Total amount of points now = " + shots));
    }

    @Override
    public void setNotificationPublisher(final NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClicksMBean)) return false;
        ClicksMBean that = (ClicksMBean) o;
        return shots == that.shots && hits == that.hits && seq == that.seq;
    }

    @Override
    public int hashCode() { return Objects.hash(shots, hits, seq); }

    @Override
    public String toString() { return "ClicksMBean{" + "shots=" + shots + ", hits=" + hits + ", seq=" + seq + '}'; }
}