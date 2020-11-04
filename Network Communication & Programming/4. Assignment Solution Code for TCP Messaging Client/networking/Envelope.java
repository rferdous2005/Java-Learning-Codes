package networking;

import java.io.Serializable;

public class Envelope implements Serializable {
    String type, from, to, msg;

    public Envelope() {

    }

    public Envelope(Envelope en) {
        this.from = en.from;
        this.to = en.to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
