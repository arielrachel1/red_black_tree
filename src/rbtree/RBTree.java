package rbtree;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * An abstract representation of a red black tree
 * 
 * A red black tree satisfies the following conditions:
     *  - A tree is either red or black
     *  - All empty trees are black
     *  - Every red tree must have black left and right trees
     *  - Every path from a tree to any of its descendant empty trees
     *    contains the same number of black trees
 *    
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 10-08-13
 * @param <X>
 * @access public
 */
public abstract class RBTree<X> {
    /**
     * Compares two Xs
     * 
     * @access default
     */
    Comparator<X> comp;
    /**
     * Is this RBTree red?
         * True indicates red
         * False indicates black
     * 
     * @access default
     */
    boolean isRed;
    /**
     * Returns the number of red RBTree<X>s with a red left or right RBTree<X>
     * 
     * @return int
     * @access default
     */
    abstract int badReds();
    /**
     * Returns the maximum number of blacks in a path from this RBTree<X> to an
     * empty RBTree<X>
     * 
     * @return int
     * @access default
     */
    abstract int maxBlack();
    /**
     * Returns the minimum number of blacks in a path from this RBTree<X> to an
     * empty RBTree<X>
     * 
     * @return int
     * @access default
     */
    abstract int minBlack();
    /**
     * Is this a red RBTree<X> with a red left or right RBTree<X>?
     * 
     * @return boolean
     * @access default
     */
    abstract boolean hasRedChild();
    /**
     * Make the color of this RBTree<X> black
     * 
     * @return RBTree<X>
     * @access default
     */
    abstract RBTree<X> makeBlack();
    /**
     * Is the color of this RBTree red?
     * 
     * @return boolean
     * @access default
     */
    boolean getColor() {
        return this.isRed;
    }
    /**
     * Balances this RBTree<X>
     * 
     * @return RBTree<X>
     * @access default
     */
    abstract RBTree<X> balance();
    /**
     * Returns the Comparator<X> of this RBTree<X>
     * 
     * @return Comparator<X>
     * @access default
     */
    Comparator<X> getComp() {
        return this.comp;
    }
    /**
     * Returns the left of this RBTree<X>
     * 
     * @return RBTree<X>
     * @access default
     */
    abstract RBTree<X> getLeft();
    /**
     * Returns the right of this RBTree<X>
     * 
     * @return RBTree<X>
     * @access default
     */
    abstract RBTree<X> getRight();
    /**
     * Returns the leaf of this RBTree
     * 
     * @return X
     * @access default
     */
    abstract X getLeaf();
    /**
     * Returns the hashCode of this RBTree<X>
     * 
     * @return int
     * @access public
     */
    public abstract int hashCode();
    /**
     * Does this RBTree<X> contain the given X?
     * 
     * @param x X
     * @return boolean
     * @access public
     */
    public abstract boolean contains(X x);
    /**
     * Returns the Xs in this RBTree<X> in an ArrayList<X> ordered by
     * the Comparator<X>
     * 
     * @param list  ArrayList<X>
     * @return ArrayList<X>
     * @access public
     */
    public abstract ArrayList<X> toArray(ArrayList<X> list);
    /**
     * Insert the given X into this RBTree<X>
     * 
     * @param x X
     * @return RBTree<X>
     * @access public
     */
    public abstract RBTree<X> insert(X x);

    /**
     * Is this RBTree<X> equal to the given RBTree<X>?
     * 
     * @param t RBTree<X>
     * @return boolean
     * @access default
     */
    abstract boolean equalsMethod(RBTree<?> t);
    /**
     * Returns the number of Xs in this RBTree<X>
     * @return int
     * @access public
     */
    public abstract int size();
    /**
     * Is this an OK representation of an RBTree<X>?
     * 
     * @return boolean
     * @access public
     */
    public abstract boolean repOK();
    /**
     * Adds the given X to this RBTree<X> and makes the color black
     * 
     * @param x X
     * @return RBTree<X>
     * @access default
     */
    abstract RBTree<X> add(X x);
    /**
     * Accept an RBTreeVisitor<X, R>
     * 
     * @param v RBTreeVisitor<X, R>
     * @param <R>
     * @return R
     * @access public
     */
    public abstract <R> R accept(RBTreeVisitor<X, R> v);
    /**
     * Is this RBTree<X> equal to the given Object?
     * 
     * @param o Object
     * @return boolean
     * @access public
     */
    public boolean equals(Object o) {
        if (o instanceof RBTree) {
            return this.equalsMethod((RBTree<?>)o);
        }
        else {
            return false;
        }
    }
}