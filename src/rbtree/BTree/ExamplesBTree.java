package BTree;

import java.util.*;
import rbtree.*;
import tester.*;



/**
 * Test the BTree package
 * 
 * @author Ariel Winton - winton.a@husky.neu.edu
 * @version 11-14-2013
 * @access public
 */
public class ExamplesBTree {
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
     * BTree<String>
     */
    BTree<String> b;
    /**
     * BTree<String>
     */
    BTree<String> b1;
    /**
     * Iterator<String>
     */
    Iterator<String> iter;
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
     * BTree<Integer>
     */
    BTree<Integer> bInt;
    /**
     * ArrayList<Integer>
     */
    ArrayList<Integer> intList;
    /**
     * RBTreeVisitor<String> that counts nodes
     */
    CountNodes<String> countNodes;
    /**
     * RBTreeVisitor<String> that produces height
     */
    Height<String> height;
    /**
     * RBTreeVisitor<String> that produces black height
     */
    BlackHeight<String> blackHeight;
    /**
     * RBTreeVisitor<String> that finds path lengths
     */
    PathLengths<String> pathLengths;
    /**
     * Initializes the above variables
     * 
     * @access public
     */
    public void setVars() {
        list = new ArrayList<String>();
        list.add("Ariel");
        list.add("Hi");
        list.add("Whatever");
        list.add("Hi");
        list.add("Hello");
        list.add("Aloha");
        comp = new StringByLex();
        comp1 = new StringByLength();
        b = BTree.binTree(comp);
        b1 = BTree.binTree(comp1);
        iter = b.iterator();
        empty = new Empty<String>(comp);
        cons = empty.insert("Ariel");
        consHelp = empty.insert("Ask");
        cons1 = consHelp.insert("Ariel");
        cons3 = empty.insert("A");
        cons2 = cons3.insert("Ariel");
        cons4 = cons.insert("A");
        cons5 = cons.insert("Ask");
        compInt = new IntBySize();
        emptyInt = new Empty<Integer>(compInt);
        consInt = emptyInt.insert(1);
        bInt = BTree.binTree(compInt);
        intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        countNodes = new CountNodes<String>();
        height = new Height<String>();
        blackHeight = new BlackHeight<String>();
        pathLengths = new PathLengths<String>();
    }
    /**
     * Test the repOK method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testRepOK(Tester t) {
        setVars();
        t.checkExpect(b.repOK(), true);
        BTree<String> bad = new BTree<String>(null);
        t.checkExpect(bad.repOK(), false);
        b.active = null;
        t.checkExpect(b.repOK(), false);
        setVars();
        b.tree = null;
        t.checkExpect(b.repOK(), false);
    }
    /**
     * Test the build method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testBuild(Tester t) {
        setVars();
        b.build(list);
        t.checkExpect(b.toString(), "Aloha, Ariel, Hello, Hi, Whatever");
        bInt.build(intList);
        t.checkExpect(bInt.toString(), "1, 2, 3");
    }
    /**
     * Test the contains method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testContains(Tester t) {
        setVars();
        t.checkExpect(b.contains("Ariel"), false);
        b.build(list, 1);
        t.checkExpect(b.contains("Ariel"), true);
        t.checkExpect(bInt.contains(1), false);
        bInt.build(intList, 3);
        t.checkExpect(bInt.contains(3), true);
    }
    /**
     * Test the binTree method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testBinTree(Tester t) {
        setVars();
        t.checkExpect(BTree.binTree(comp), b);
        t.checkExpect(BTree.binTree(compInt), bInt);
    }
    /**
     * Test the second build method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testBuild2(Tester t) {
        setVars();
        t.checkExpect(b.toString(), "");
        b.build(new ArrayList<String>(), 4);
        t.checkExpect(b.toString(), "");
        b.build(list, 3);
        t.checkExpect(b.toString(), "Ariel, Hi, Whatever");
        bInt.build(intList, 2);
        t.checkExpect(bInt.toString(), "1, 2");
    }
    /**
     * Test the toString method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testToString(Tester t) {
        setVars();
        t.checkExpect(b.toString(), "");
        b.build(list, 2);
        t.checkExpect(b.toString(), "Ariel, Hi");
    }
    /**
     * Test the equals method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testEquals(Tester t) {
        setVars();
        t.checkExpect(b.equals(list), false);
        t.checkExpect(b.equals(b1), false);
        t.checkExpect(b.equals(new BTree<String>(comp)), true);
    }
    /**
     * Test the equalsBTree method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testEqualsBTree(Tester t) {
        setVars();
        t.checkExpect(b.equalsBTree(new BTree<String>(comp)), true);
        t.checkExpect(b1.equalsBTree(b), false);
        b.build(list, 3);
        t.checkExpect(b.equalsBTree(new BTree<String>(comp)), false);
        BTree<String> treeExample = BTree.binTree(comp);
        treeExample.build(list, 3);
        b.iterator();
        t.checkExpect(b.equalsBTree(treeExample), false);
    }
    /**
     * Test the hashCode method in the BTree class
     * 
     * @param t Tester
     * @access default
     */
    void testHashCode(Tester t) {
        setVars();
        t.checkExpect(b.hashCode(), 1);
    }
    /**
     * Test the iterator method in the BTIterator class
     * 
     * @param t Tester
     * @access default
     */
    void testIterator(Tester t) {
        setVars();
        t.checkExpect(b.iterator().hasNext(), false);
        b.build(list, 3);
        Iterator<String> iterator = b.iterator();
        t.checkExpect(iterator.hasNext(), true);
        t.checkExpect(iterator.next(), "Ariel");
        t.checkExpect(iterator.next(), "Hi");
        t.checkExpect(iterator.next(), "Whatever");
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
                "test the remove method",
                new UnsupportedOperationException(),
                b.iterator(), "remove");
        t.checkException(
                "test the next method when hasNext == false",
                new NoSuchElementException(),
                b.iterator(), "next");
        b.build(list, 3);
        b.iterator();
        t.checkException(
                "test the build method when active > 0",
                new ConcurrentModificationException(),
                b, "build", list, 3);
        t.checkException(
                "test the build method when active > 0",
                new ConcurrentModificationException(),
                b, "build", list);
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
    void testEquals4(Tester t) {
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
     * @param t Tester
     * @access default
     */
    void testRepOK2(Tester t) {
        setVars();
        t.checkExpect(comp1.repOK(), true);
        b.build(list, 5);
    }
    /**
     * Test the visitEmpty and visitNode methods in the PathLengths<X> 
     * visitor
     * 
     * @param t Tester
     * @access default
     */
    void testPathLengths(Tester t) {
        setVars();
        t.checkExpect(b.accept(pathLengths), new ArrayList<Integer>(0));
        b.build(list, 2);
        t.checkExpect(b.accept(pathLengths), 
                new ArrayList<Integer>(Arrays.asList(1, 2, 2)));
    }
    /**
     * Test the visitEmpty, visitNode, and findMax methods in the 
     * Height<X> visitor
     * 
     * @param t Tester
     * @access default
     */
    void testHeight(Tester t) {
        setVars();
        t.checkExpect(b.accept(height), 0);
        b.build(list, 2);
        t.checkExpect(b.accept(height), 2);
        t.checkExpect(height.findMax(new ArrayList<Integer>()), 0);
        ArrayList<Integer> arraylist = 
            new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        t.checkExpect(height.findMax(arraylist), 2);
    }
    /**
     * Test the visitEmpty and visitNode methods in the BlackHeight<X>
     * visitor
     * 
     * @param t Tester
     * @access default
     */
    void testBlackHeight(Tester t) {
        setVars();
        t.checkExpect(b.accept(blackHeight), 0);
        b.build(list, 1);
        t.checkExpect(b.accept(blackHeight), 0);
        setVars();
        b.build(list, 2);
        t.checkExpect(b.accept(blackHeight), 1);
    }
    /**
     * Test the visitEmpty and visitNode methods in the CountNodes<X> 
     * visitor
     * 
     * @param t Tester
     * @access default
     */
    void testCountNodes(Tester t) {
        setVars();
        t.checkExpect(b.accept(countNodes), new ArrayList<Integer>(
                Arrays.asList(0, 0, 0)));
        b.build(list, 2);
        t.checkExpect(b.accept(countNodes), new ArrayList<Integer>(
                Arrays.asList(2, 1, 1)));
    }
}

