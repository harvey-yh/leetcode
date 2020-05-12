package 公司.字节跳动.挑战字符串;

import java.util.ArrayList;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 简化路径 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        ArrayList<String> array = new ArrayList<>();
        StringBuffer simplepath = new StringBuffer();
        for(int i = 0; i < paths.length; i++){
            if("..".equals(paths[i]) && !array.isEmpty()){
                array.remove(array.size()-1);
            }else if(".".equals(paths[i]) || "".equals(paths[i]) || "..".equals(paths[i])){
                continue;
            }else{
                array.add(paths[i]);
            }
        }
        for(int i=0; i<array.size();i++){
            simplepath.append("/").append(array.get(i));
        }
        if(simplepath.toString().equals("")){
            simplepath.append("/");
        }
        return simplepath.toString();
    }
}
