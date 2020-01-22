/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author cn1adil
 */
public class PriorityQueue {

    private Pair[] array = new Pair[100];
    
    public PriorityQueue()
    {
        for (int i = 0; i < 100; i++) {
            array[i] = new Pair(-1,-1);
        }
    }
    
    public void add(int node, int sum, int prev)
    {
        for (int i=0; i<100; i++)
        {
            if (array[i].getNode() == -1) {
                array[i].setNode(node);
                array[i].setSum(sum);
                array[i].setPrev(prev);
                break;
            }
        }
    }
    
    public Pair remove()
    {
        int min = array[0].getSum();
        int index = 0;
        for (int i = 1; i < 100; i++) {
            if (array[i].getSum() == -1) continue;
            else if (array[i].getSum() < min)
            {
                min = array[i].getSum();
                index = i;
            }
        }
        Pair temp = new Pair(array[index].getNode(), array[index].getSum());
        temp.setPrev(array[index].getPrev());
        array[index].setNode(-1);
        array[index].setSum(-1);
        array[index].setPrev(-1);
        return temp;
    }
    
    public boolean isEmpty()
    {
        boolean flag = true;
        for (int i = 0; i < 100; i++) {
            if (array[i].getNode() != -1) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
}