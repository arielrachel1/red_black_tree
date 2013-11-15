package rbtree;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * A non-empty RBTree<X>
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 10-08-13
 * @param <X>
 * @access public
 */
public class Cons<X> extends RBTree<X> {
    /**
     * X
     * 
     * @access public
     */
    public X leaf;
    /**
     * RBTree<X> with a leaf less than this RBTree<X>'s leaf 
     * by the Comparator<X>
     * 
     * @access public
     */
    public RBTree<X> left;
    /**
     * RBTree<X> with a leaf greater than this RBTree<X>'s leaf 
     * by the Comparator<X>
     * 
     * @access public
     */
    public RBTree<X> right;
    /**
     * Constructor for non-empty RBTree
     * 
     * @param isRed boolean
     * @param comp  Comparator<X>
     * @param leaf  X
     * @param left  RBTree<X>
     * @param right RBTree<X>
     * @access default
     */
    Cons(boolean isRed, Comparator<X> comp, 
            X leaf, RBTree<X> left, RBTree<X> right) {
        this.isRed = isRed;
        this.comp = comp;
        this.leaf = leaf;
        this.left = left;
        this.right = right;
    }
    /**
     * Returns an int that indicates how many red RBTree<X>s in this Cons<X>
     * have a red left or right RBTree<X>
     * 
     * @return int
     * @access default
     */
    int badReds() {
        if (hasRedChild()) {
            return 1 + this.left.badReds() + this.right.badReds();
        }
        else {
            return this.left.badReds() + this.right.badReds();
        }
    }
    /**
     * Returns the maximum number of black RBTree<X>s in a path
     * 
     * @return int
     * @access default
     */
    int maxBlack() {
        if (isRed) {
            return Math.max(left.maxBlack(), right.maxBlack());
        }
        else {
            return 1 + Math.max(left.maxBlack(), right.maxBlack());
        }
    }
    /**
     * Returns the minimum number of black RBTree<X>s in a path
     * 
     * @return int
     * @access default
     */
    int minBlack() {
        if (isRed) {
            return Math.min(left.minBlack(), right.minBlack());
        }
        else {
            return 1 + Math.min(left.minBlack(), right.minBlack());
        }
    }
    /**
     * Make the color of this RBTree<X> black
     * 
     * @return RBTree<X>
     * @access default
     */
    RBTree<X> makeBlack() {
        return new Cons<X>(false, comp, leaf, left, right);
    }
    /**
     * Is this RBTree<X> red with a red left RBTree<X> or right RBTree<X>?
     * 
     * @return boolean
     * @access default
     */
    boolean hasRedChild() {
        return isRed && (this.getLeft().isRed ||
            this.getRight().isRed);
    }
    /**
     * Balance this RBTree<X>
     * 
     * @return RBTree<X>
     * @access public
     */
    public RBTree<X> balance() {
        if (!isRed && (left.hasRedChild())) {
            if (left.getLeft().isRed) {
                RBTree<X> theLeft = new Cons<X>(false, comp, 
                        this.left.getLeft().getLeaf(),
                        this.left.getLeft().getLeft(),
                        this.left.getLeft().getRight());
                RBTree<X> theRight = new Cons<X>(false, comp,
                        this.leaf, this.left.getRight(),
                        this.right);
                return new Cons<X>(true, comp, this.left.getLeaf(),
                        theLeft, theRight);
            }
            else {
                RBTree<X> theLeft = new Cons<X>(false, comp,
                        this.left.getLeaf(),
                        this.left.getLeft(),
                        this.left.getRight().getLeft());
                RBTree<X> theRight = new Cons<X>(false, comp,
                        this.leaf, 
                        this.left.getRight().getRight(),
                        this.right);
                return new Cons<X>(true, comp, this.left.getRight().getLeaf(),
                        theLeft, theRight);
            }
        }
        if (!isRed && (right.hasRedChild())) {
            if (right.getLeft().isRed) {
                RBTree<X> theLeft = new Cons<X>(false, comp,
                        this.leaf, this.left,
                        this.right.getLeft().getLeft());
                RBTree<X> theRight = new Cons<X>(false, comp,
                        this.right.getLeaf(),
                        this.right.getLeft().getRight(),
                        this.right.getRight());
                return new Cons<X>(true, comp, this.right.getLeft().getLeaf(),
                        theLeft, theRight);
            }
            else {
                RBTree<X> theLeft = new Cons<X>(false, comp,
                        this.leaf, this.left,
                        this.right.getLeft());
                RBTree<X> theRight = new Cons<X>(false, comp,
                        this.right.getRight().getLeaf(),
                        this.right.getRight().getLeft(),
                        this.right.getRight().getRight());
                return new Cons<X>(true, comp, this.right.getLeaf(),
                        theLeft, theRight);
            }
        }
        else {
            return this;
        }
    }
    /**
     * Returns the left of this RBTree<X>
     * 
     * @return RBTree<X>
     * @access default
     */
    RBTree<X> getLeft() {
        return this.left;
    }
    /**
     * Returns the right of this RBTree<X>
     * 
     * @return RBTree<X>
     * @access default
     */
    RBTree<X> getRight() {
        return this.right;
    }
    /**
     * Returns the leaf of this RBTree<X>
     * 
     * @return X - the leaf of this RBTree
     * @access default
     */
    X getLeaf() {
        return this.leaf;
    }
    /**
     * Returns the hashCode of this RBTree<X>
     * 
     * @return int
     * @access public
     */
    public int hashCode() {
        return this.leaf.hashCode() + this.right.hashCode() + 
            this.left.hashCode() + this.comp.hashCode();
    }
    /**
     * Returns the size of the RBTree<X>
     * 
     * @return int
     * @access public
     */
    public int size() {
        return 1 + left.size() + right.size();
    }
    /**
     * Checks that this Cons<X> has a Comparator<X>, an Object, and
     * two RBTree<X>s as fields, and satisfies the guidelines of a 
     * red black tree
     * 
     * @return boolean
     * @access public
     */
    public boolean repOK() {
        return (comp instanceof Comparator) && 
            (leaf instanceof Object) && (left instanceof RBTree) &&
                (right instanceof RBTree) && (badReds() == 0) && 
                    (maxBlack() == minBlack());
    }
    /**
     * Does this Cons<X> contain an X equal (by the comparator) to 
     * the given X?
     * 
     * @param x X
     * @return boolean
     * @access public
     */
    public boolean contains(X x) {
        if (comp.compare(x, leaf) == 0) {
            return true;
        }
        else if ((comp.compare(x, leaf)) > 0) {
            return this.right.contains(x);
        }
        else {
            return this.left.contains(x);
        }
    }
    /**
     * Adds the elements of this RBTree<X> in order by the Comparator<X>
     * to the given ArrayList<X>
     * 
     * @param list  ArrayList<X>
     * @return ArrayList<X>
     * @access public
     */
    public ArrayList<X> toArray(ArrayList<X> list) {
        this.left.toArray(list);
        list.add(leaf);
        this.right.toArray(list);
        return list;
    }
    /**
     * Insert the given X into this RBTree<X> and make the color of this
     * RBTree<X> black
     * 
     * @param x X
     * @return RBTree<X>
     * @access public
     */
    public RBTree<X> insert(X x) {
        return add(x).makeBlack();
    }
    /**
     * Add the given X to this RBTree<X>
     * 
     * @param x X
     * @return RBTree<X>
     * @access default
     */
    RBTree<X> add(X x) {
        Cons<X> t = new Cons<X>(isRed, comp, leaf, left, right);
        if ((comp.compare(leaf, x)) == 0) {
            return t.balance();
        }
        else if ((comp.compare(leaf, x) > 0)) {
            t.left = t.left.add(x);
            return t.balance();
        }
        else {
            t.right = t.right.add(x);
            return t.balance();
        }
    }
    /**
     * Return all of the Xs from this RBTree<X> in a String
     * 
     * @return String
     * @access public
     */
    public String toString() {
        if ((this.right instanceof Empty) &&
                (this.left instanceof Empty)) {
            return leaf.toString();
        }
        else if ((this.right instanceof Empty)) {
            return this.left.toString() + ", " + leaf;
        }
        else if ((this.left instanceof Empty)) {
            return leaf + ", " + this.right.toString();
        }
        else {
            return this.left.toString() + ", " + leaf + 
                ", " + this.right.toString();
        }
    }
    /**
     * Is this RBTree<X> equal to the given RBTree<X>?
     * 
     * @param t RBTree<X>
     * @return boolean
     * @access default
     */
    boolean equalsMethod(RBTree<?> t) {
        return (t instanceof Cons) && (this.isRed == t.isRed) &&
            (this.comp.equals(t.comp)) &&
                this.leaf.equals(((Cons<?>)t).leaf) && 
                    this.left.equals(((Cons<?>)t).left) &&
                        this.right.equals(((Cons<?>)t).right);
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
        if (isRed) {
            return v.visitNode(comp, "RED", leaf, left, right);
        }
        else {
            return v.visitNode(comp, "BLACK", leaf, left, right);
        }
    }
}