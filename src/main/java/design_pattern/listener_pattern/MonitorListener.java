package design_pattern.listener_pattern;

/**
 * @author cc
 * @Date 2019-05-13 00:28:28 Monday
 */
public interface MonitorListener extends  EventListener{

    void handleEvent(PrintEvent event);
}
