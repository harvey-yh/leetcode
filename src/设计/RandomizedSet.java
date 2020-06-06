package 设计;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/6/6
 * @slogan Drive business with technology, make business generate value.
 */
public class RandomizedSet {
    /** Initialize your data structure here. */
    public Set<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }else{
            set.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val)){
            return false;
        }else{
            set.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        List<Integer> list = new ArrayList<>(set);
        Collections.shuffle(list);
        return list.size() > 0 ? list.get(0) : 0;
    }
}
