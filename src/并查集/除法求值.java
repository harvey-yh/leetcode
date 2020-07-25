package 并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/7/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 除法求值 {
    private HashMap<String,String> parent=new HashMap<>();
    private HashMap<String,Double> quotient=new HashMap<>();

    private String find(String p){
        if (!parent.get(p).equals(p)) {
            //需要先保存父亲的值,因为后面压缩后树只有两层,后面*的就是根节点的权值1,是不对的
            //这里可以看看上面的并查集的方向和值来判断
            String f=parent.get(p);
            parent.put(p,find(f));
            //这样压缩后的子节点才是正确的
            quotient.put(p,quotient.get(p)*quotient.get(f));
        }
        return parent.get(p);
    }

    private void init(String s){
        if (!parent.containsKey(s)) {
            parent.put(s,s);
            quotient.put(s,1.0);
        }
    }

    private void union(String a, String b, double value){
        init(a);
        init(b);
        // a/fa=val[a], b/fb=val[b]
        String fa=find(a);
        String fb=find(b);
        if (fa.equals(fb)) {
            return;
        }
        parent.put(fa,fb);
        quotient.put(fa,value*(quotient.get(b)/quotient.get(a)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i=0;i<equations.size();i++) {
            List<String> equation=equations.get(i);
            union(equation.get(0),equation.get(1),values[i]);
        }
        double[] res = new double[queries.size()];
        int index=0;
        for (List<String> query:queries) {
            String a=query.get(0);
            String b=query.get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b)) {
                res[index++]=-1.0;
            }else{
                //先做路径压缩
                res[index++]=find(a).equals(find(b)) ? quotient.get(a)/quotient.get(b) : -1.0;
            }
        }
        return res;
    }
}
