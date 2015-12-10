package test;

import java.util.*;

public class CartesianIterator <T> implements Iterator <List <T>> {
	private final List <List <T>> lilio;    
    private int current = 0;
    private final long last;

    public CartesianIterator (final List <List <T>> llo) {
        lilio = llo;
        long product = 1L;
        for (List <T> lio: lilio)
            product *= lio.size ();
        last = product;
    } 

    public boolean hasNext () {
        return current != last;
    }

    public List <T> next () {
        ++current;
        return get (current - 1, lilio);
    }

    public void remove () {
        ++current;
    }

    private List<T> get (final int n, final List <List <T>> lili) {
        switch (lili.size ())
        {
            case 0: return new ArrayList <T> (); // no break past return;
            default: {
                List <T> inner = lili.get (0);
                List <T> lo = new ArrayList <T> ();
                lo.add (inner.get (n % inner.size ()));
                lo.addAll (get (n / inner.size (), lili.subList (1, lili.size ())));
                return lo;
            }
        }
    }
}

class CartesianIterable <T> implements Iterable <List <T>> {

    private List <List <T>> lilio;  

    public CartesianIterable (List <List <T>> llo) {
        lilio = llo;
    }

    public Iterator <List <T>> iterator () {
        return new CartesianIterator <T> (lilio);
    }
}
