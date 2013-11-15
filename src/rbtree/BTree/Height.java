package BTree;
import java.util.*;
import rbtree.*;

/**
 * Visits an RBTree<X> and returns its height
 * 
 * The height of an RBTree<X> is the longest path length from the root 
 * to an empty RBTree<X>
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 11-8-13
 * @param <X>
 * @access public
 */
public class Height<X> implements RBTreeVisitor<X, Integer> {
    /**
     * Returns the height of an empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @return Integer
     * @access public
     */
    public Integer visitEmpty(Comparator<X> comp, String color) {
        return 0;
    }
    
    /**
     * Returns the height of a non-empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @param leaf  X
     * @param left  RBTree<X>
     * @param right RBTree<X>
     * @return Integer
     * @access public
     */
    public Integer visitNode(Comparator<X> comp, String color, X leaf, 
                     RBTree<X> left, RBTree<X> right) {
        PathLengths<X> lens = new PathLengths<X>();
        return 1 + Math.max(findMax(left.accept(lens)), 
                findMax(right.accept(lens)));
    }
    /**
     * Find the maximum Integer in the given ArrayList<Integer>
     * 
     * @param list  ArrayList<Integer>
     * @return int
     * @access public
     */
    public int findMax(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        else {
            Integer max = list.get(0);
            for (Integer i : list) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        }
    }
}
