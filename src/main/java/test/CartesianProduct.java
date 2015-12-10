package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartesianProduct {
	public static void main (String[] args) {
        List <Character> la = Arrays.asList (new Character [] {'a', 'b'});
        List <Character> lb = Arrays.asList (new Character [] {'1', '2'});      
        List <Character> lc = Arrays.asList (new Character [] {'C', 'D'});
        List <List <Character>> llc = new ArrayList <List <Character>> ();
        llc.add (la);
        llc.add (lb);
        llc.add (lc);

        CartesianIterable <Character> ci = new CartesianIterable <Character> (llc);
        for (List<Character> lo: ci)
            show (lo);

        la = Arrays.asList (new Character [] {'x', 'y', 'z'});
        lb = Arrays.asList (new Character [] {'b'});    
        lc = Arrays.asList (new Character [] {'c'});
        llc = new ArrayList <List <Character>> ();
        llc.add (la);
        llc.add (lb);
        llc.add (lc);

        ci = new CartesianIterable <Character> (llc);
        for (List<Character> lo: ci)
            show (lo);    
    }

    public static void show (List <Character> lo) {
        System.out.print ("(");
        for (Object o: lo)
            System.out.print (o);
        System.out.println (")");
    }
}
