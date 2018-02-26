package com.example.demo.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by chenhe on 2018/2/26.
 */

public class RmiServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        RmiService service = new RmiServiceImpl();

        //创建并导出接受指定port请求的本地主机上的Registery实例
        LocateRegistry.createRegistry(12312);

        /** Naming类提供在对象注册表中存储和获得远程对象引用的方法
         * Naming类的每个方法都可将某个名称作为其中一个参数
         * 该名称是使用以下形式的URL格式(没有Schema组件)的java.lang.String: rmi://ip:post/name
         * host：注册表所在的主机（远程或本地)，省略则默认为本地主机
         * port：是注册表接受调用的端口号，省略则默认为1099，RMI注册表registry使用的著名端口
         * name：是未经注册表解释的简单字符串
         */
        Naming.bind("rmi://127.0.0.1:12312/RmiService",service);
        System.out.println("服务启动..");

    }
}
