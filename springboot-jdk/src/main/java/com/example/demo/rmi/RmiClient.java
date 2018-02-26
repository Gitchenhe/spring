package com.example.demo.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by chenhe on 2018/2/26.
 */
public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RmiService rmiService = (RmiService) Naming.lookup("rmi://127.0.0.1:12312/RmiService");
        String result = rmiService.say("陈贺");
        System.out.println("服务器返回:"+result);
    }
}
