package com.m3c.agw;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumniCurie02 on 11/10/2017.
 */


public class BinaryTreeImp implements BinaryTree {


    private Logger log = Logger.getLogger(App.class.getName());


    private BuildTree root;
    public BinaryTreeImp(){
        this.root = null;
    }


    public int getRootElement() {
        this.root = root;
        if (root != null){
            log.info("Found the root element!");
            return root.node;
        }
        log.debug("Root element does not exist in the tree yet!");
//        System.out.println("Root element does not exist");
        return -1;
    }

    public int getNumberOfElements() {
        if (root == null) {
            return 0;
        }
        int counter = 1;
        BuildTree currentNode = root;
        counter = countNodes(currentNode,counter);
        log.info("Found "+counter+" number of nodes");
        return counter;
    }

    private int countNodes(BuildTree currentNode, int counter) {

        if (currentNode.leftTree != null) {
            counter += 1;
            counter = countNodes(currentNode.leftTree, counter);
        }
        if (currentNode.rightTree != null) {
            counter += 1;
            counter = countNodes(currentNode.rightTree, counter);
        }
        return counter;
    }

    public void addElement(int element) {

        if (findElement(element) == 0){
            try {
                throw new DuplicatedNode();
            } catch (DuplicatedNode duplicatedNode) {
                duplicatedNode.printStackTrace(element);
            } finally {
                log.debug("Did not add element" +element+" to tree");
                return;
            }
        }


        BuildTree newNode = new BuildTree(element);
        if (root == null){
            root = newNode;
            log.info("element "+element+" was added as the root node");
            return;
        }

        BuildTree currentNode = root;
        BuildTree parentNode = null;
        while (currentNode != null) {

            parentNode = currentNode;
            if (element < currentNode.node) {
                currentNode = currentNode.leftTree;

                if (currentNode == null) {
                    parentNode.leftTree = newNode;
                    log.info("Element "+newNode.node+" sucessfully added to the left tree");
                }

            }else if (element > currentNode.node){
                currentNode = currentNode.rightTree;
                if (currentNode == null) {
                    parentNode.rightTree = newNode;
                    log.info("Element "+newNode.node+" sucessfully added to the right tree");
                }
            }
        }
    }

    public void addElements(int[] elements){
        for (int i = 0; i < elements.length; i++){
            addElement(elements[i]);
        }
        return;

    }

    public int findElement(int value) {

        BuildTree currentNode = root;
        while (currentNode != null) {
            if (currentNode.node == value) {
                return 0;
            } else if (value < currentNode.node) {
                currentNode = currentNode.leftTree;
            } else {
                currentNode = currentNode.rightTree;
            }
        }
        log.debug("element "+value+" does not exist yet");
        return -1;

    }

    public int getLeftChild(int element) {
        int check = findElement(element);
        if (check == 0){
            BuildTree currentNode = root;
            while (true) {
                if (currentNode.node == element) {
                    if (currentNode.leftTree != null) {
                        log.debug(currentNode.leftTree.node+" is the left child of element "+ currentNode.node);
                        return currentNode.leftTree.node;
                    } else {
                        return -1;
                    }
                } else if (element < currentNode.node) {
                    currentNode = currentNode.leftTree;
                } else if (element > currentNode.node) {
                    currentNode = currentNode.rightTree;
                }
                else {return -1;}
            }
        }
        log.info(element+" does not have a left child node");
        return -1;
    }

    public int getRightChild(int element) {
        int check = findElement(element);
        if (check == 0){
            BuildTree currentNode = root;
            while (true) {
                if (currentNode.node == element) {
                    if (currentNode.rightTree != null) {
                        log.debug(currentNode.rightTree.node+" is the right child of element "+ currentNode.node);
                        return currentNode.rightTree.node;
                    } else {
                        return -1;
                    }
                } else if (element < currentNode.node) {
                    currentNode = currentNode.leftTree;
                } else if (element > currentNode.node) {
                    currentNode = currentNode.rightTree;
                }
                else {return -1;}
            }
        }
        return -1;
    }


    public List<Integer> getSortedTreeAsc() {
        BuildTree currentNode = root;
        List<Integer> listAscending = new ArrayList<Integer>();
        sortAscending(root, listAscending);
        log.debug("list sorted in ascending order");
        return listAscending;
    }

    private List<Integer> sortAscending(BuildTree currentNode, List<Integer> listAscending){

        if (currentNode == null) {
            return null;
        }
        sortAscending(currentNode.leftTree,listAscending);
        listAscending.add(currentNode.node);
        sortAscending(currentNode.rightTree, listAscending);
        return listAscending;
    }

    public List<Integer> getSortedTreeDesc() {
        BuildTree currentNode = root;
        List<Integer> listDescending = new ArrayList<Integer>();
        sortDescending(root, listDescending);
        log.debug("list sorted in descending order");
        return listDescending;
    }

    private List<Integer> sortDescending(BuildTree currentNode, List<Integer> listDescending){

        if (currentNode == null) {
            return null;
        }
        sortDescending(currentNode.rightTree,listDescending);
        listDescending.add(currentNode.node);
        sortDescending(currentNode.leftTree, listDescending);
        return listDescending;
    }
}
