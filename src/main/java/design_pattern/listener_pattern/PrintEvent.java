package design_pattern.listener_pattern;

/**
 * @author cc
 * @Date 2019-05-12 23:42:42 Sunday
 */
public class PrintEvent extends EventObject {

    public PrintEvent(Object object) {
        super(object);
    }

    public void doEvent(){
        System.out.println("通知一个事件源 source: " + this.getSource());
    }
}
