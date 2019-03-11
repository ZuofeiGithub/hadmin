package com.jili.hadmin.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: 左飞
 * @Date: 2019/3/11 12:46
 * @Version 1.0
 */
@ServerEndpoint(value = "/websocket")
@Component
public class MyWebsocket {
    //用来存储每隔客户端对应的MyWebsocket对象
    private static CopyOnWriteArraySet<MyWebsocket> websockets = new CopyOnWriteArraySet<>();
    private Session session;//当前回话session
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        websockets.add(this);
        this.session.getAsyncRemote().sendText("成功加入");
    }
    @OnClose
    public void onClose(Session session){
        websockets.remove(this);
    }
    @OnMessage
    public void onMessage(String message,Session session){
        //群发给所有客户端
        broadcast(message);
    }

    /**
     * 群发
     * @param message
     */
    private void broadcast(String message) {
        for(MyWebsocket item:websockets){
            item.session.getAsyncRemote().sendText(message);
        }
    }

    /**
     * 发送错误时调用
     */
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }
}
