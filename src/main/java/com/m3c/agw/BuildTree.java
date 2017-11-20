package com.m3c.agw;

/**
 * Created by alumniCurie02 on 11/10/2017.
 */
public class BuildTree {

    int node;
    BuildTree leftTree;
    BuildTree rightTree;

    public BuildTree(int node){
        this.node = node;
        leftTree = null;
        rightTree = null;
    }
}
