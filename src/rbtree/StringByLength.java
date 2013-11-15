package rbtree;
import java.util.Comparator;

/**
 * Comparator<String> that compares the lengths of Strings
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 10-07-13
 * @access public
 */
public class StringByLength implements Comparator<String> {
    /**
     * Is this StringByLength non-null?
     * 
     * @return boolean
     * @access public
     */
    public boolean repOK() {
        return (this instanceof StringByLength);
    }
    /**
     * Compares Strings by their length
     * 
     * @param s1    String
     * @param s2    String
     * @return int
         * 1 means s1 is longer than s2
         * 0 means s1 is the same length as s2
         * -1 means s1 is shorter than s2
     * @access public
     */
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return 1;
        }
        if (s1.length() < s2.length()) {
            return -1;
        }
        else {
            return 0;
        }
    }
    /**
     * Is this StringByLength equal to the given Object?
     * 
     * @param o Object
     * @return boolean
     * @access public
     */
    public boolean equals(Object o) {
        return (o instanceof StringByLength);
    }
    /**
     * Returns the hashCode of this StringByLength
     * 
     * @return int
     * @access public
     */
    public int hashCode() {
        return 0;
    }
}