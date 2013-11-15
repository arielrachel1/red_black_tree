package rbtree;
import java.util.*;

/**
* A visitor that visits RBTree<X>s
* 
* @author Ariel Winton - winton.a@husky.neu.edu
* @version 11-01-13
* @param <T> 
* @param <R> 
* @access public
*/
public interface RBTreeVisitor<T, R> {
    /**
     * Visits an empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @return R
     * @access public
     */
    public R visitEmpty(Comparator<T> comp, String color);
    /**
     * Visits a non-empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @param color String (either "BLACK" or "RED")
     * @param data  X
     * @param left  RBTree<X>
     * @param right RBTree<X>
     * @return R
     * @access public
     */
    public R visitNode(Comparator<T> comp, String color, T data, 
                     RBTree<T> left, RBTree<T> right);
}
