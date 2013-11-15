package rbtree;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Empty RBTree<X>
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 10-08-13
 * @param <X>
 * @access public
 */
public class Empty<X> extends RBTree<X> {
    /**
     * Constructor for an empty RBTree<X>
     * 
     * @param comp  Comparator<X>
     * @access public
     */
    public Empty(Comparator<X> comp) {
        this.comp = comp;
        this.isRed = false;
    }
    /**
     * Returns the number of red RBTree<X>s with a red left 
     * or right RBTree<X>
     * 
     * @return int
     * @access default
     */
    int badReds() {
        return 0;
    }
    /**
     * What is the maximum number of blacks RBTree<X>s in a path?
     * 
     * @return int
     * @access default
     */
    int maxBlack() {
        return 1;
    }
    /**
     * What is the minimum number of black RBTree<X>s in a path?
     * 
     * @return int
     * @access default
     */
    int minBlack() {
        return 1;
    }
    /**
     * Is this RBTree<X> red with a red left or right RBTree<X>?
     * 
     * @return boolean
     * @access default
     */
    boolean hasRedChild() {
        return false;
    }
    /**
     * Make the color of this RBTree<X> black
     * 
     * @return RBTree<X>
     * @access default
     */
    RBTree<X> makeBlack() {
        return this;
    }
    /**
     * Balance this RBTree<X>
     * 
     * @return RBTree<X>
     * @access public
     */
    public RBTree<X> balance() {
        return this;
    }
    /**
     * Returns the leaf of this RBTree<X>
     * 
     * Throws an exception
     * 
     * @return X    Throws a RuntimeException
     * @access default
     */
    X getLeaf() {
        throw new RuntimeException("There is no leaf in this Tree");
    }
    /**
     * Returns the left of this RBTree
     * 
     * Throws an exception
     * 
     * @return RBTree<X>    Throws a RuntimeException
     */
    RBTree<X> getLeft() {
        throw new RuntimeException("There is no left in this Tree");
    }
    /**
     * Returns the right of this RBTree<X>
     * 
     * Throws an exception
     * 
     * @return RBTree<X>    Throws a RuntimeException
     */
    RBTree<X> getRight() {
        throw new RuntimeException("There is no right in this Tree");
    }
    /**
     * Returns the hashCode of this RBTree<X>
     * 
     * @return int
     * @access public
     */
    public int hashCode() {
        return 1 + this.comp.hashCode();
    }
    /**
     * Returns the number of Xs in this RBTree<X>
     * 
     * @return int
     * @access public
     */
    public int size() {
        return 0;
    }
    /**
     * Checks that this empty RBTree<X> has a Comparator<X> as a field 
     * and is black
     * 
     * @return boolean
     * @access public
     */
    public boolean repOK() {
        return (comp instanceof Comparator) && (!isRed);
    }
    /**
     * Does this empty RBTree<X> contain an X equal to the
     * given X by the comparator?
     * 
     * @param x X
     * @return boolean
     * @access public
     */
    public boolean contains(X x) {
        return false;
    }
    /**
     * Returns an ArrayList<X> with all the Xs in this RBTree<X>
     * in order by the Comparator<X>
     * 
     * @param list  ArrayList<X>
     * @return ArrayList<X> 
     * @access public
     */
    public ArrayList<X> toArray(ArrayList<X> list) {
        return list;
    }
    /**
     * Inserts the given X into this RBTree<X>
     * 
     * @param x X
     * @return RBTree<X>
     * @access public
     */
    public RBTree<X> insert(X x) {
        return add(x);
    }
    /**
     * Inserts the given X into this RBTree<X>
     * 
     * @param x X
     * @return RBTree<X>
     * @access default
     */
    RBTree<X> add(X x) {
        return new Cons<X>(true, comp, x, this, this);
    }
    /**
     * Returns an empty String
     * 
     * @return String
     * @access public
     */
    public String toString() {
        return "";
    }
    /**
     * Is this RBTree<X> equal to the given RBTree<X>?
     * 
     * @param t RBTree<X>
     * @return boolean
     * @access default
     */
    boolean equalsMethod(RBTree<?> t) {
        return (t instanceof Empty) &&
            (this.comp.equals(t.comp));
    }
    /**
     * Accept an RBTreeVisitor<X, R>
     * 
     * @param v RBTreeVisitor<X, R>
     * @param <R>
     * @return R
     * @access public
     */
    public <R> R accept(RBTreeVisitor<X, R> v) {
        return v.visitEmpty(comp, "BLACK");
    }
}