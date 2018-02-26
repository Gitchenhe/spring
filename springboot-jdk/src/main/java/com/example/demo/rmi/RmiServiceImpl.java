package com.example.demo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by chenhe on 2018/2/26.
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    protected RmiServiceImpl() throws RemoteException {
    }

    @Override
    public String say(String msg) throws RemoteException {
        System.out.println("服务收到消息:" + msg);
        return "你好";
    }
}
