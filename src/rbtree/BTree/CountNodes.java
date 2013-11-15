package BTree;
import java.util.*;

import rbtree.*;
/**
 * Visits an RBTree<X> and returns an ArrayList<Integer> with three elements:
 * - index 0: number of non-empty nodes
 * - index 1: number of non-empty black nodes
 * - index 2: number of non-empty red nodes
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 11-10-13
 * @param <X>
 * @access public
 */
public class CountNodes<X> implements RBTreeVisitor<X, ArrayList<Integer>> {
    /**
     * ArrayList<Integer> with the node counts specified above
     * @access private
     */
    private ArrayList<Integer> finalCount = 
        new ArrayList<Integer>(Arrays.asList(0, 0, 0));
    /**
     * Counts the nodes in an empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @return ArrayList<Integer>
     * @access public
     */
    public ArrayList<Integer> visitEmpty(Comparator<X> comp, String color) {
        return finalCount;
    }
    /**
     * Counts the nodes in a non-empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @param leaf  X
     * @param left  RBTree<X>
     * @param right RBTree<X>
     * @return ArrayList<Integer>
     * @access public
     */
    public ArrayList<Integer> visitNode(Comparator<X> comp, String color, 
            X leaf, RBTree<X> left, RBTree<X> right) {
        finalCount.set(0, finalCount.get(0) + 1);
        if (color.equals("BLACK")) {
            finalCount.set(1, finalCount.get(1) + 1);
        }
        else {
            finalCount.set(2, finalCount.get(2) + 1);
        }
        left.accept(this);
        right.accept(this);
        return finalCount;
    }
}
