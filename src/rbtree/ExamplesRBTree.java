package rbtree;
import java.util.*;

import tester.*;

/**
 * Examples for rbtree package
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 11-14-2013
 * @access public
 */
public class ExamplesRBTree {
    /**
     * ArrayList<String>
     */
    ArrayList<String> list;
    /**
     * Lexicographical Comparator<String>
     */
    StringByLex comp;
    /**
     * Length Comparator<String>
     */
    StringByLength comp1;
    /**
     * Empty RBTree<String>
     */
    RBTree<String> empty;
    /**
     * Non-empty RBTree<String>
     */
    RBTree<String> cons;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons1;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons2;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons3;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons4;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> consHelp;
    /**
     * Non-empty RBTree<String>
     */
    RBTree<String> cons5;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons6;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons7;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons8;
    /**
     * Non-empty RBTree<String>
     */
    RBTree<String> cons9;
    /**
     * Non-empty RBTree<String> 
     */
    RBTree<String> cons10;
    /**
     * Size Comparator<Integer>
     */
    IntBySize compInt;
    /**
     * Empty RBTree<Integer> 
     */
    RBTree<Integer> emptyInt;
    /**
     * Empty RBTree<Integer> 
     */
    RBTree<Integer> consInt;
    
    /**
     * Initialize the variables above
     * @access default
     */
    void setVars() {
        list = new ArrayList<String>();
        list.add("Ariel");
        list.add("Hi");
        list.add("Whatever");
        list.add("Hi");
        list.add("Hello");
        list.add("Aloha");
        comp = new StringByLex();
        comp1 = new StringByLength();
        empty = new Empty<String>(comp);
        cons = empty.insert("Ariel");
        consHelp = empty.insert("Ask");
        cons1 = consHelp.insert("Ariel");
        cons3 = empty.insert("A");
        cons2 = cons3.insert("Ariel");
        cons4 = cons.insert("A");
        cons5 = cons.insert("Ask");
        cons6 = cons1.insert("A");
        cons7 = cons4.insert("1");
        cons8 = cons4.insert("Ar");
        cons9 = cons5.insert("Ariell");
        cons10 = cons5.insert("Asks");
        compInt = new IntBySize();
        emptyInt = new Empty<Integer>(compInt);
        consInt = emptyInt.insert(1);
    }
    /**
     * Test the balance method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testBalance(Tester t) {
        setVars();
        t.checkExpect(empty.balance(), new Empty<String>(comp));
        t.checkExpect(cons.balance(), 
                new Cons<String>(true, comp, "Ariel", empty, empty));
        t.checkExpect((new Cons<String>(false, comp, "Ariel", 
                new Cons<String>(true, comp, "A", empty, empty), 
                empty)).balance(), cons4);
        t.checkExpect((new Cons<String>(false, comp, "Ariel", empty, 
                new Cons<String>(true, comp, "Ask", empty, empty))).balance(),
                cons5);
        t.checkExpect((new Cons<String>(false, comp, "Ariel", 
                new Cons<String>(true, comp, "A", 
                        new Cons<String>(true, comp, "1", empty, empty), 
                        empty), 
                empty)).balance().makeBlack(), cons7);
        t.checkExpect((new Cons<String>(false, comp, "Ariel", 
                new Cons<String>(true, comp, "A", empty,
                        new Cons<String>(true, comp, "Ar", empty, empty)), 
                empty)).balance().makeBlack(), cons8);
        t.checkExpect((new Cons<String>(false, comp, "Ariel", empty, 
                new Cons<String>(true, comp, "Ask", 
                        new Cons<String>(true, comp, "Ariell", empty, empty),
                        empty))).balance().makeBlack(), 
                cons9);
        t.checkExpect((new Cons<String>(false, comp, "Ariel", empty, 
                new Cons<String>(true, comp, "Ask", empty, 
                        new Cons<String>(true, comp, "Asks", empty, empty))))
                        .balance().makeBlack(),
                cons10);
    }
    /**
     * Test the maxBlack method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testMaxBlack(Tester t) {
        setVars();
        t.checkExpect(empty.maxBlack(), 1);
        t.checkExpect(cons.maxBlack(), 1);
        t.checkExpect(cons6.maxBlack(), 3);
        t.checkExpect(emptyInt.maxBlack(), 1);
        t.checkExpect(consInt.maxBlack(), 1);
    }
    /**
     * Test the minBlack method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testMinBlack(Tester t) {
        setVars();
        t.checkExpect(empty.minBlack(), 1);
        t.checkExpect(cons.minBlack(), 1);
        t.checkExpect(cons6.minBlack(), 3);
        t.checkExpect(emptyInt.minBlack(), 1);
        t.checkExpect(consInt.minBlack(), 1);
    }
    /**
     * Test the badReds method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testBadReds(Tester t) {
        setVars();
        t.checkExpect(empty.badReds(), 0);
        t.checkExpect(cons.badReds(), 0);
        t.checkExpect((new Cons<String>(false, comp, "Ariel", empty, 
                new Cons<String>(true, comp, "Ask", empty, 
                        new Cons<String>(true, comp, "Asks", empty, empty))))
                            .badReds(), 1);
    }
    /**
     * Test the hasRedChild method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testHasRedChild(Tester t) {
        setVars();
        t.checkExpect(empty.hasRedChild(), false);
        t.checkExpect(cons.hasRedChild(), false);
        t.checkExpect((new Cons<String>(true, comp, "Ariel",
                new Cons<String>(true, comp, "A", empty, empty),
                empty)).hasRedChild(), true);
        t.checkExpect((new Cons<String>(true, comp, "Ariel",
                empty, new Cons<String>(true, comp, "Ask", empty, empty)))
                .hasRedChild(), true);
    }
    /**
     * Test the add method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testAdd(Tester t) {
        setVars();
        t.checkExpect(empty.add("Ariel"), 
                new Cons<String>(true, comp, "Ariel", empty, empty));
        t.checkExpect(cons.add("A"), 
                new Cons<String>(true, comp, "Ariel", cons3, empty));
    }
    /**
     * Test the makeBlack method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testMakeBlack(Tester t) {
        setVars();
        t.checkExpect(empty.makeBlack(), new Empty<String>(comp));
        t.checkExpect(cons.makeBlack(), 
                new Cons<String>(false, comp, "Ariel", empty, empty));
    }
    /**
     * Test the getComp method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testGetComp(Tester t) {
        setVars();
        t.checkExpect(empty.getComp(), comp);
        t.checkExpect(cons.getComp(), comp);
    }
    /**
     * Test the getLeaf method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testGetLeaf(Tester t) {
        setVars();
        t.checkExpect(cons.getLeaf(), "Ariel");
    }
    /**
     * Test the getLeft method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testGetLeft(Tester t) {
        setVars();
        t.checkExpect(cons.getLeft(), empty);
    }
    /**
     * Test the getRight method in the RBTree<X> class
     * @param t Tester
     * @access default
     */
    void testGetRight(Tester t) {
        setVars();
        t.checkExpect(cons.getRight(), empty);
    }
    /**
     * Test the getColor method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testGetColor(Tester t) {
        setVars();
        t.checkExpect(empty.getColor(), false);
        t.checkExpect(cons.getColor(), true);
    }
    /**
     * Test exceptions
     * 
     * @param t Tester
     * @access default
     */
    void testExceptions(Tester t) {
        setVars();
        t.checkException(
                "test the getLeaf method on an empty Tree",
                new RuntimeException("There is no leaf in this Tree"),
                empty, "getLeaf");
        t.checkException(
                "test the getLeft method on an empty Tree",
                new RuntimeException("There is no left in this Tree"),
                empty, "getLeft");
        t.checkException(
                "test the getRight method on an empty Tree",
                new RuntimeException("There is no right in this Tree"),
                empty, "getRight");
    }
    /**
     * Test the hashCode method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testHashCode2(Tester t) {
        setVars();
        t.checkExpect(empty.hashCode(), 2);
        t.checkExpect(cons.hashCode(), "Ariel".hashCode() + 
                empty.hashCode() + empty.hashCode() + 
                cons.getComp().hashCode());
    }
    /**
     * Test the size method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testSize1(Tester t) {
        setVars();
        t.checkExpect(empty.size(), 0);
        t.checkExpect(cons.size(), 1);
        t.checkExpect(cons1.size(), 2);
        t.checkExpect(cons2.size(), 2);
        t.checkExpect(emptyInt.size(), 0);
        t.checkExpect(consInt.size(), 1);
    }
    /**
     * Test the repOK method for RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testRepOK1(Tester t) {
        setVars();
        t.checkExpect(empty.repOK(), true);
        t.checkExpect(new Empty<String>(null).repOK(), false);
        Empty<String> emp = new Empty<String>(comp);
        emp.isRed = true;
        t.checkExpect(emp.repOK(), false);
        t.checkExpect(cons.repOK(), true);
        t.checkExpect(new Cons<String>(true, null, "Ariel", empty, 
                empty).repOK(), false);
        t.checkExpect(new Cons<String>(true, comp, null, empty, 
                empty).repOK(), false);
        t.checkExpect(new Cons<String>(true, comp, "Ariel", null, 
                empty).repOK(), false);
        t.checkExpect(new Cons<String>(true, comp, "Ariel", empty, 
                null).repOK(), false);
        t.checkExpect(new Cons<String>(true, comp, "Arie", empty, 
                cons).repOK(), false);
        t.checkExpect(new Cons<String>(false, comp, "Ariel", empty, 
                new Cons<String>(false, comp, "Ask", empty, empty)).repOK(),
                false);
        t.checkExpect(emptyInt.repOK(), true);
        t.checkExpect(consInt.repOK(), true);
    }
    /**
     * Test the contains method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testContains1(Tester t) {
        setVars();
        t.checkExpect(empty.contains("Ariel"), false);
        t.checkExpect(cons.contains("Ariel"), true);
        t.checkExpect(cons1.contains("Ariel"), true);
        t.checkExpect(cons2.contains("Ariel"), true);
        t.checkExpect(emptyInt.contains(1), false);
        t.checkExpect(consInt.contains(2), false);
        t.checkExpect(consInt.contains(1), true);
    }
    /**
     * Test the toArray method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testToArray(Tester t) {
        setVars();
        t.checkExpect(empty.toArray(list), list);
        t.checkExpect(cons.toArray(list), list);
    }
    /**
     * Test the insert method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testInsert(Tester t) {
        setVars();
        t.checkExpect(empty.insert("Ariel"), cons);
        t.checkExpect(cons.insert("A"), cons4);
        t.checkExpect(emptyInt.insert(1), consInt);
        RBTree<Integer> consExample = consInt;
        t.checkExpect(consInt.insert(1), consExample.makeBlack());
    }
    /**
     * Test the toString method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testToString1(Tester t) {
        setVars();
        t.checkExpect(empty.toString(), "");
        t.checkExpect(cons.toString(), "Ariel");
        t.checkExpect(emptyInt.toString(), "");
        t.checkExpect(consInt.toString(), "1");
    }
    /**
     * Tests the equals method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testEquals1(Tester t) {
        setVars();
        t.checkExpect(empty.equals(new Empty<String>(comp)), true);
        t.checkExpect(empty.insert("Ariel").equals(cons), true);
        setVars();
        t.checkExpect(empty.equals(cons), false);
        t.checkExpect(cons.equals(cons1), false);
        t.checkExpect(cons.equals(empty), false);
        t.checkExpect(empty.equals("Hello"), false);
        t.checkExpect(cons.equals("Hello"), false);
        t.checkExpect(emptyInt.equals(new Empty<Integer>(compInt)), true);
        t.checkExpect(consInt.equals(cons), false);
        
    }
    /**
     * Test the equalsMethod method in the RBTree<X> class
     * 
     * @param t Tester
     * @access default
     */
    void testEqualsMethod(Tester t) {
        setVars();
        t.checkExpect(empty.equalsMethod(empty), true);
        t.checkExpect(empty.equalsMethod(cons), false);
        t.checkExpect(empty.equalsMethod(new Empty<String>(null)), false);
        t.checkExpect(cons.equalsMethod(
                new Cons<String>(true, comp1, "Ariel", empty, empty)), false);
        t.checkExpect(cons.equalsMethod(
                new Cons<String>(false, comp, "Ariel", empty, empty)), false);
        t.checkExpect(cons.equalsMethod(new Cons<String>(
                true, comp, "Ariel", empty, empty)), true);
        t.checkExpect(cons.equalsMethod(
                new Cons<String>(true, comp, "Hello", empty, empty)), false);
        t.checkExpect(cons.equalsMethod(
                new Cons<String>(true, comp, "Ariel", cons3, empty)), false);
        t.checkExpect(cons.equalsMethod(
                new Cons<String>(true, comp, "Ariel", empty, consHelp)), false);
    }
    /**
     * Test the compare method in the StringByLength class
     * 
     * @param t Tester
     * @access default
     */
    void testCompare(Tester t) {
        setVars();
        t.checkExpect(comp1.compare("Ariel", "Fart"), 1);
        t.checkExpect(comp1.compare("Fart", "Ariel"), -1);
        t.checkExpect(comp1.compare("Fart", "Mall"), 0);
    }
    /**
     * Test the equals method in the StringByLength class
     * 
     * @param t Tester
     * @access default
     */
    void testEquals2(Tester t) {
        setVars();
        t.checkExpect(comp1.equals(new StringByLength()), true);
        t.checkExpect(comp1.equals(comp), false);
    }
    /**
     * Test the hashCode method in the StringByLength class
     * 
     * @param t Tester
     * @access default
     */
    void testHashCode3(Tester t) {
        setVars();
        t.checkExpect(comp1.hashCode(), 0);
    }
    /**
     * Test the compare method in the StringByLex class
     * 
     * @param t Tester
     * @access default
     */
    void testCompare1(Tester t) {
        setVars();
        t.checkExpect(comp.compare("Ariel", "A"), 4);
        t.checkExpect(comp.compare("A", "Ariel"), -4);
        t.checkExpect(comp.compare("Ariel", "Ariel"), 0);
    }
    /**
     * Test the equals method in the StringByLex class
     * 
     * @param t Tester
     * @access default
     */
    void testEquals3(Tester t) {
        setVars();
        t.checkExpect(comp.equals(new StringByLex()), true);
        t.checkExpect(comp.equals(comp1), false);
    }
    /**
     * Test the hashCode method in the StringByLex class
     * 
     * @param t Tester
     * @access default
     */
    void testHashCode4(Tester t) {
        setVars();
        t.checkExpect(comp.hashCode(), 1);
    }
    /**
     * Test the repOK method in the StringByLex class
     * 
     * @param t Tester
     * @access default
     */
    void testRepOK3(Tester t) {
        setVars();
        t.checkExpect(comp.repOK(), true);
    }
    /**
     * Test the repOK method in the StringByLength class
     * 
     * @param t Tester
     * @access default
     */
    void testRepOK2(Tester t) {
        setVars();
        t.checkExpect(comp1.repOK(), true);
    }
    /**
     * Test the methods in the IntBySize class
     * 
     * @param t Tester
     * @access default
     */
    void testIntBySize(Tester t) {
        setVars();
        t.checkExpect(compInt.compare(0, 1), -1);
        t.checkExpect(compInt.compare(0, 0), 0);
        t.checkExpect(compInt.compare(1, 0), 1);
        t.checkExpect(compInt.repOK(), true);
        t.checkExpect(compInt.hashCode(), 2);
        t.checkExpect(compInt.equals(new IntBySize()), true);
        t.checkExpect(compInt.equals(comp), false);
    }
}
