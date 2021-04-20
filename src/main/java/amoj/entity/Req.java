package amoj.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Req implements Serializable {

    private int code;
    private String msg;
    private Object obj;

    public static Req success(String msg0, Object obj0){
        Req r = new Req();
        r.setCode(0);
        r.setMsg(msg0);
        r.setObj(obj0);
        return r;
    }
    public static Req success(String msg0){
        Req r = new Req();
        r.setCode(0);
        r.setMsg(msg0);
        return r;
    }

    public static Req fail(String msg0, Object obj0){
        Req r = new Req();
        r.setCode(-1);
        r.setMsg(msg0);
        r.setObj(obj0);
        return r;
    }
    public static Req fail(String msg0){
        Req r = new Req();
        r.setCode(-1);
        r.setMsg(msg0);
        return r;
    }

}
