package com.yuan.springbootwebsocket;

import org.springframework.stereotype.Component;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author yuane
 * @date 2019/6/9 22:54
 **/
@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {
    private static Integer count = 0;
    private static CopyOnWriteArraySet<MyWebSocket> set = new CopyOnWriteArraySet<>();
    private Session session;

    public synchronized static void addCount() {
        MyWebSocket.count++;
    }

    public synchronized static Integer getCount() {
        return count;
    }

    public synchronized static void subCount() {
        MyWebSocket.count--;
    }


    public void onOpen(Session session) {
        this.session = session;
        set.add(this);
    }
}
