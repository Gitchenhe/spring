package com.example.demo.paths;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by chenhe on 2018/3/1.
 */
public class PathsDemo {

    @Test
    public void pathsTest(){
        Path path = Paths.get("C:\\Program Files (x86)\\IIS Express");
        System.out.println("path :"+path);
        System.out.println("file name :"+path.getFileName());
        System.out.println("name count :"+path.getNameCount());
    }
}
