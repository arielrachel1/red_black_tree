package BTree;
import java.util.*;

import rbtree.*;
/**
 * Visits an RBTree<X> and returns its black height
 * 
 * The black height of an RBTree<X> is the number of non-empty black
 * RBTree<X> from the root to any empty RBTree<X>
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 11-10-13
 * @param <X>
 * @access public
 */
public class BlackHeight<X> implements RBTreeVisitor<X, Integer> {
    /**
     * The number of black nodes in the RBTree<X> being visited
     * @access private
     */
    private Integer blacks = 0;
    /**
     * Returns the black height of an empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @return Integer
     * @access public
     */
    public Integer visitEmpty(Comparator<X> comp, String color) {
        return blacks;
    }
    /**
     * Returns the black height of a non-empty RBTree<X>
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
        if (color.equals("BLACK")) {
            blacks = blacks + 1;
        }
        left.accept(this);
        return blacks;
    }
}
