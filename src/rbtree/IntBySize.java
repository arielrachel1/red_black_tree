package rbtree;
import java.util.*;
/**
 * A Comparator<Integer> that compares Integers by size
 * @author Ariel Winton
 * @version 11-7-13
 * @access public
 */
public class IntBySize implements Comparator<Integer> {
    /**
     * Compare Integers by size
     * 
     * @param i Integer
     * @param i1    Integer
     * @return int 
         * positive if i > i1,
         * negative if i < i1
         * 0 if i == i1
     * @access public
     */
    public int compare(Integer i, Integer i1) {
        return i - i1;
    }
    /**
     * Is this IntBySize non-null?
     * 
     * @return boolean
     * @access public
     */
    public boolean repOK() {
        return (this instanceof IntBySize);
    }
    /**
     * Return the hashCode of this IntBySize
     * 
     * @return int
     * @access public
     */
    public int hashCode() {
        return 2;
    }
    /**
     * Is this IntBySize equal to the given Object?
     * 
     * @param o Object
     * @return boolean
     * @access public
     */
    public boolean equals(Object o) {
        return (o instanceof IntBySize);
    }
}
