package rbtree;
import java.util.Comparator;

/**
 * Comparator<String> that compares Strings lexicographically
 * 
 * @author Ariel Winton
 * @version 10-07-13
 * @access public
 */
public class StringByLex implements Comparator<String> {
    /**
     * Is this StringByLex non-null?
     * 
     * @return boolean
     * @access public
     */
    public boolean repOK() {
        return (this instanceof StringByLex);
    }
    /**
     * Compares Strings lexicographically
     * 
     * @param s1    String
     * @param s2    String
     * @return int 
         * -1 if s1 comes before s2 lexicographically
         * 0 if s1 equals s2 lexicographically
         * 1 if s1 comes after s2 lexicographically
     * @access public
     */
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
    /**
     * Is this StringByLex equal to the given Object?
     * 
     * @param o Object
     * @return boolean
     * @access public
     */
    public boolean equals(Object o) {
        return (o instanceof StringByLex);
    }
    /**
     * Returns the hashCode of this StringByLex
     * 
     * @return int
     * @access public
     */
    public int hashCode() {
        return 1;
    }
}