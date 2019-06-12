package design_pattern.listener_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cc
 * @Date 2019-05-13 00:31:31 Monday
 *
 *  监听者模式
 *  回调函数应该属于观察者模式的一种，目的是为了替代轮询机制，将组件之间的耦合性降低。
 *  https://blog.csdn.net/qq_32252957/article/details/82763848
 */
public class EventSource {

    private List<MonitorListener> listenerList = new ArrayList<>();

    public void addListener(MonitorListener eventListener) {
        listenerList.add(eventListener);
    }

    public void removeListener(MonitorListener eventListener) {
        int i = listenerList.indexOf(eventListener);
        if (i >= 0) {
            listenerList.remove(eventListener);
        }
    }

    public void notifyListenerEvents(PrintEvent event) {
        for (MonitorListener monitorListener : listenerList) {
            monitorListener.handleEvent(event);
        }
    }

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new MonitorListener() {
            @Override
            public void handleEvent(PrintEvent event) {
                event.doEvent();
                if(event.getSource().equals("openWindows")){
                    System.out.println("doOpen");
                }
                if(event.getSource().equals("closeWindows")){
                    System.out.println("doClose");
                }

            }
        });

        eventSource.notifyListenerEvents(new PrintEvent("openWindows"));
    }

}
