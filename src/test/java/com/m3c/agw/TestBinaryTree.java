package com.m3c.agw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by alumniCurie02 on 11/10/2017.
 */
public class TestBinaryTree {

    private BinaryTreeImp binaryTreeImp;

    Logging logging = new Logging();

    @Test
    public void testingAddElements() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {1,2,3,4,5,1,6};
        binaryTreeImp.addElements(elements);
        int check = binaryTreeImp.findElement(2);
        Assert.assertEquals(0, check);

    }

    @Test
    public void testingNumElements() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {1,2,3,4,5,6,7,8,9};
        binaryTreeImp.addElements(elements);
        int check = binaryTreeImp.getNumberOfElements();
        Assert.assertEquals(9, check);

    }
    @Test
    public void testingOutOfOrderNumElements() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {7,4,1,3,5,8,11,9};
        binaryTreeImp.addElements(elements);
        int check = binaryTreeImp.getNumberOfElements();
        Assert.assertEquals(8, check);

    }

    @Test
    public void testingMultiNumElements() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {7,4,9,1,3,5,8,11,9};
        binaryTreeImp.addElements(elements);
        int check = binaryTreeImp.getNumberOfElements();
        Assert.assertEquals(8, check);

    }


    @Test
    public void testingFindLeftchild() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {7,4,9,1,3,5,8,11,9};
        binaryTreeImp.addElements(elements);
        int check = binaryTreeImp.getLeftChild(4);
        Assert.assertEquals(1, check);

    }

    @Test
    public void testingFindLeftchildFail() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {7,4,9,1,3,5,8,11,9};
        binaryTreeImp.addElements(elements);
        int check = binaryTreeImp.getLeftChild(1);
        Assert.assertEquals(-1, check);

    }



    @Test
    public void testingFindRightchild() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {7,4,9,1,3,5,8,11,9};
        binaryTreeImp.addElements(elements);
        int check = binaryTreeImp.getRightChild(4);
        Assert.assertEquals(5, check);

    }

    @Test
    public void testingAscendingList() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {7,4,9,1,3,5,8,11,9};
        binaryTreeImp.addElements(elements);
        List<Integer> listOfTree = binaryTreeImp.getSortedTreeAsc();

    }

    @Test
    public void testingDescendingList() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {7,4,9,1,3,5,8,11,9};
        binaryTreeImp.addElements(elements);
        List<Integer> listOfTree = binaryTreeImp.getSortedTreeDesc();

    }

    @Test
    public void testingAddElementsConintuous() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {1,2,3,4,5,6};
        binaryTreeImp.addElements(elements);
        int[] elements2 = {10,11,15,12,14,3};
        binaryTreeImp.addElements(elements2);
        int check = binaryTreeImp.findElement(14);
        Assert.assertEquals(0, check);

    }

    @Test
    public void testingAddElementsConintuousSort() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {1,2,3,4,5,6};
        binaryTreeImp.addElements(elements);
        int[] elements2 = {7,8,9,10,11,15,12,13,14,15};
        binaryTreeImp.addElements(elements2);
        List<Integer> listAscending = binaryTreeImp.getSortedTreeAsc();

        Assert.assertArrayEquals(new Object[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15},listAscending.toArray());
       /*

        int counter =1;

        for(Integer i : listAscending){
            Assert.assertEquals(counter,i.intValue());
            counter++;
        }
        */

    }

    @Test
    public void testingAddElementsConintuousSortDesc() {

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {1,2,3,4,5,6};
        binaryTreeImp.addElements(elements);
        int[] elements2 = {7,8,9,10,11,15,12,13,14,15};
        binaryTreeImp.addElements(elements2);
        List<Integer> listDescending = binaryTreeImp.getSortedTreeDesc();

        for (int i=1; i<15;i++){
            Assert.assertEquals(15-i, listDescending.get(i).intValue());
        }

    }

    @Test
    public void testingRootElement() {
        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        int[] elements = {1, 2, 3, 4, 5, 6};
        binaryTreeImp.addElements(elements);
        int[] elements2 = {7, 8, 9, 10, 11, 15, 12, 13, 14, 15};
        binaryTreeImp.addElements(elements2);
        int check = binaryTreeImp.getRootElement();
        Assert.assertEquals(1,check);
    }

    @Test
    public void testingLargeNumbers() {
        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        for (int i=0;i<101;i++){
            binaryTreeImp.addElement(i);
        }
        int check = binaryTreeImp.findElement(100);
        Assert.assertEquals(0,check);
    }

    @Test
    public void testingLargeNumbersSort() {
        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        for (int i=0;i<101;i++){
            binaryTreeImp.addElement(i);
        }
        List<Integer> check = binaryTreeImp.getSortedTreeDesc();
        for (int i=1; i<101;i++){
            Assert.assertEquals(100-i, check.get(i).intValue());
        }
    }

    @Test
    public void testingLargeNumbersOutOfOrderSort() {
        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        for (int i=0;i<101;i++){
            binaryTreeImp.addElement(i*2);
        }
        for (int j=0;j<101;j++){
            binaryTreeImp.addElement((j*2)-1);
        }
        List<Integer> check = binaryTreeImp.getSortedTreeDesc();
        for (int i=1; i<201;i++){
            Assert.assertEquals(200-i, check.get(i).intValue());
        }
    }
    @Test
    public void testingLargeNumbersOutOfOrdergetNumber() {
        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        for (int i=0;i<100;i++){
            binaryTreeImp.addElement(i*2);
        }
        for (int j=0;j<100;j++){
            binaryTreeImp.addElement((j*2)-1);
        }
        int check = binaryTreeImp.getNumberOfElements();
        Assert.assertEquals(200, check);

    }

    @Test
    public void testingRandom() {
        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        Random generator = new Random();
        for (int i = 0; i<10; i++) {
            int num = generator.nextInt(500);
//            System.out.print(num +" ");
            binaryTreeImp.addElement(num);
        }
//        System.out.println("");
        List<Integer> listAscending = binaryTreeImp.getSortedTreeAsc();
        System.out.println(listAscending);
    }
}
