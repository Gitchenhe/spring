package com.example.demo.tree;

/**
 * Created by chenhe on 2018/3/11.
 */
public class Tree extends AbstractTree {
    private Integer value;//当前结点的值
    private Tree leftTree;//左子树
    private Tree rightTree;//有字数
    private int deep;//深度
    private int degree;//结点的度
    private Integer root;//根结点
    private int count = 0;//结点个数


    @Override
    public Tree add(Integer value) {
        if (count == 0) {
            this.root = value;
            this.value = value;
            count++;
            return this;
        }
        Integer rootItem = this.root;

        for (int i = 0; i < count; i++) {
            if (rootItem.intValue() < value) {
            }

        }
        return null;

    }

    @Override
    public Tree delete(Integer value) {
        return null;
    }

    @Override
    public Tree update(Integer value) {
        return null;
    }


}
