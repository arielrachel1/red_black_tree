package BTree;
import java.util.*;

import rbtree.*;


/**
 * A wrapper class for an RBTree<X>
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 10-08-13
 * @param <X> - the type of Objects in the RBTree<X>
 * @access public
 */
public class BTree<X> implements Iterable<X> {
    /**
     * Comparator<X> that compares Xs in the RBTree<X>
     * 
     * @access protected
     */
    protected Comparator<X> comp;
    /**
     * Number of RBTree<X> iterators currently traversing
     * 
     * @access protected
     */
    protected Integer active = 0;
    /**
     * RBTree<X>
     * 
     * @access protected
     */
    protected RBTree<X> tree; 
    /**
     * Constructor for an RBTree<X> wrapper
     * 
     * @param comp  Comparator<X>
     * @access default
     */
    BTree(Comparator<X> comp) {
        this.comp = comp;
        tree = new Empty<X>(comp);
    }
    /**
     * Checks that this BTree<X> has a Comparator<X>, 
     * an Integer, and an RBTree<X> as fields
     * 
     * @return boolean
     * @access public
     */
    public boolean repOK() {
        return (comp instanceof Comparator) && (active instanceof Integer) &&
            (tree instanceof RBTree);
    }
    /**
     * Inserts the first numElems Xs from the given Iterable<X> collection 
     * into the RBTree<X>.
     * 
     * The RBTree<X> will not have any duplicates. If an item to be added 
     * equals an item that is already in the tree (as decided by the 
     * Comparator<X>), it will not be added.
     *
     * @param iter  Iterable<X>
     * @param numElems  number of Xs to iterate through and add to
     * the red black tree
     * @access public
     *        
     * If numElems is negative or larger than the number of Xs in
     * iter, then all Xs in iter should be inserted into the tree 
     */
    public void build(Iterable<X> iter, int numElems) {
        Iterator<X> i = iter.iterator();
        if (active == 0) {
            while (numElems > 0) {
                if (i.hasNext()) {
                    tree = tree.insert(i.next());
                    numElems = numElems - 1;
                }
                else {
                    return ;
                }
            }
        }
        else {
            throw new ConcurrentModificationException();
        }
    }
    /**
     * Checks to see if this RBTree<X> contains the given X
     * 
     * @param x X
     * @return boolean
     * @access public
     */
    public boolean contains(X x) {
        return this.tree.contains(x);
    }
    /**
     * Factory method to generate an RBTree<X> wrapper with an
     * empty RBTree<X> and with the given Comparator<X>
     *
     * @param comp  Comparator<X>
     * @param <X>
     * @return BTree<X>
     * @access public
     */
    public static <X> BTree<X> binTree(Comparator<X> comp) {
        return new BTree<X>(comp);
    }

    /**
     * Inserts the Xs from the given Iterable<X> collection into the RBTree<X>
     * wrapper
     * 
     * The RBTree<X> will not have any duplicates. If an item to be added 
     * equals an item that is already in the tree (as decided by the 
     * Comparator<X>), it will not be added.
     *
     * @param iter  Iterable<X>
     * @access public
     */
    public void build(Iterable<X> iter) {
        Iterator<X> iterator = iter.iterator();
        if (active == 0) {
            while (iterator.hasNext()) {
                tree = tree.insert(iterator.next());
            }
        }
        else {
            throw new ConcurrentModificationException();
        }
    }
    /**
     * Produces a String that consists of all Xs in this tree separated
     * by comma and a space, generated in the order defined by this tree's 
     * Comparator<X>
     * 
     * @return String
     * @access public
     */
    public String toString() {
        return this.tree.toString();
    }
    /**
     * Produces false if the given Object is not an RBTree<X> wrapper
     * 
     * Produces true if this RBTree<X> wrapper and the given RBTree<X> wrapper 
     * contain the same Xs and are ordered by the same Comparator<X>
     *
     * @param o Object
     * @return boolean
     * @access public
     */
    public boolean equals(Object o) {
        if (!(o instanceof BTree)) {
            return false;
        }
        else {
            return (this.equalsBTree((BTree<?>)o));
        }
    }
    /**
     * Is this RBTree<X> wrapper equal to that RBTree<X> wrapper?
     * 
     * @param t BTree<X>
     * @return boolean
     * @access public
     */
    public boolean equalsBTree(BTree<?> t) {
        return (comp.equals(t.comp)) &&
            (active == t.active) &&
                (tree.equals(t.tree));
    }
    /**
     * Produces an Integer that is compatible with the implemented equals 
     * method and is likely to be different for objects that are not equal.
     * 
     * @return int
     * @access public
     */
    public int hashCode() {
        return this.toString().hashCode() + this.comp.hashCode();
    }
    /**
     * Iterator<X> that iterates through RBTree<X>s
     * 
     * @author Ariel Winton - winton.a@husky.neu.edu
     * @version 10-08-13
     * @access default
     */
    class BTIterator implements Iterator<X> {
        /**
         * Ordered ArrayList of Xs in the RBTree<X>
         * 
         * @access default
         */
        ArrayList<X> elems;
        /**
         * Index of an X in the ArrayList<X>
         * 
         * @access default
         */
        Integer i;
        /**
         * Constructor for a BTIterator<X>
         * 
         * @access default
         */
        BTIterator() {
            //Orders and flattens the elements of the RBTree<X> 
            //into an ArrayList<X>
            elems = tree.toArray(new ArrayList<X>());
            //Sets the index of the ArrayList<X> to 0
            i = 0;
            //Increments the number of traversing Iterator<X>s
            //if the RBTree<X> being iterated over is not empty
            if (this.hasNext()) {
                active = active + 1;
            }
        }
        /**
         * Does the ArrayList<X> have a next element?
         * 
         * @return boolean
         * @access public
         */
        public boolean hasNext() {
            return (i < elems.size());
        }
        /**
         * Return the next element in the ArrayList<X>
         * 
         * @return X
         * @access public
         */
        public X next() {
            if (this.hasNext()) {
                int result = i;
                i = i + 1;
                if (!this.hasNext()) {
                    active = active - 1;
                }
                return elems.get(result);
            }
            else {
                throw new NoSuchElementException();
            }
        }
        /**
         * Throw an exception
         * 
         * @access public
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    /**
     * Create a BTIterator<X>
     * 
     * @return Iterator<X>
     * @access public
     */
    public Iterator<X> iterator() {
        return new BTIterator();
    }
    /**
     * Accept an RBTreeVisitor<X>
     * 
     * @param v RBTreeVisitor<X, R>
     * @param <R>
     * @return  R
     * @access public
     */
    public <R> R accept(RBTreeVisitor<X, R> v) {
        return tree.accept(v); 
    }
}
















