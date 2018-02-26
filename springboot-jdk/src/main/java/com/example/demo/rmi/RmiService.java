package com.example.demo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by chenhe on 2018/2/26.
 */
public interface RmiService extends Remote {
    String say(String msg) throws RemoteException;
}
