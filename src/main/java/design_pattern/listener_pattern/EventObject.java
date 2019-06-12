package design_pattern.listener_pattern;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cc
 * @Date 2019-05-12 23:42:42 Sunday
 */
@Data
public class EventObject implements Serializable {

    private Object source;

    public EventObject(Object object) {
        this.source = object;
    }
}
