package BTree;
import java.util.*;

import rbtree.*;
/**
 * Produces an ArrayList<Integer> of the lengths of the paths from the 
 * root to each Empty in an RBTree<X>
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 11-7-13
 * @param <X>
 * @access public
 */
public class PathLengths<X> implements RBTreeVisitor<X, ArrayList<Integer>> {
    /**
     * The length of the path currently being traversed
     * 
     * Set to 0
     * 
     * @access private
     */
    private int length = 0;
    /**
     * Is this RBTreeVisitor<X, ArrayList<Integer>> visiting 
     * an empty RBTree<X>?
     * 
     * Set to true
     * 
     * @access private
     */
    private boolean isEmpty = true;
    /**
     * ArrayList<Integer> of lengths of paths 
     * 
     * Set to an empty ArrayList<Integer>
     * 
     * @access private
     */
    private ArrayList<Integer> lengths = new ArrayList<Integer>();
    /**
     * Returns an ArrayList<Integer> of the lengths of the paths
     * from the root to each node in an empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @return ArrayList<Integer>
     * @access public
     */
    public ArrayList<Integer> visitEmpty(Comparator<X> comp, 
            String color) {
        if (!isEmpty) {
            lengths.add(length);
        }
        return lengths;
    }
    
    /**
     * Returns an ArrayList<Integer> of the lengths of the paths
     * from the root to each node in a non-empty RBTree<X>
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
        isEmpty = false;
        length = length + 1;
        int currentLevel = length;
        left.accept(this);
        length = currentLevel;
        right.accept(this);
        return lengths;
    }
}