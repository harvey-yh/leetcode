package 基本排序算法;

import java.util.Arrays;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/29
 * @slogan Drive business with technology, make business generate value.
 */
public class 堆排序 {
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length){
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k=i*2+1;k<length;k=k*2+1){
            //如果左结点小于右结点，k指向右子结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    public static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sort(int[] arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            //将堆顶元素与末尾元素进行交换
            swap(arr,0,j);
            //重新对堆进行调整
            adjustHeap(arr,0, j);
        }

    }
    public static void main(String []args){
        int[] arr = new int[]{11,7,18,3,5,4,10,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

//    /**
//     * 调整为大顶堆
//     * @param arr   待调整的数组
//     * @param parent   当前父节点的下标
//     * @param length   需要对多少个元素进行调整
//     */
//    private static void adjustHeap(int[] arr, int parent, int length){
//        //临时保存父节点
//        int temp = arr[parent];
//        //左子节点的下标
//        int child = 2 * parent + 1;
//        //如果子节点的下标大于等于当前需要比较的元素个数，则结束循环
//        while(child < length){
//            //判断左子节点和右子节点的大小,若右边大，则把child定位到右边
//            if(child + 1 < length && arr[child] < arr[child + 1]){
//                child ++;
//            }
//            //若child大于父节点，则交换位置，否则退出循环
//            if(arr[child] > temp){
//                //父子节点交换位置
//                arr[parent] = arr[child];
//                //因为交换位置之后，不能保证当前的子节点是它子树的最大值，所以需要继续向下比较，
//                //把当前子节点设置为下次循环的父节点，同时，找到它的左子节点，继续下次循环
//                parent = child;
//                child = 2 * parent + 1;
//            }else{
//                //如果当前子节点小于等于父节点，则说明此时的父节点已经是最大值了，
//                //因此无需继续循环
//                break;
//            }
//        }
//        //把当前节点值替换为最开始暂存的父节点值
//        arr[parent] = temp;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {4,1,3,7,8,5,6,2};
//        //构建一个大顶堆，从最下面的非叶子节点开始向上遍历
//        for (int i = arr.length/2 - 1 ; i >= 0; i--) {
//            adjustHeap(arr,i,arr.length);
//        }
//        System.out.println(Arrays.toString(arr));
//    }
    /**
     * ————————————————————————————————————————————————————————————————
     */

//    public void insert(List<Integer> heap, int value){
//        //在数组的尾部添加
//        if(heap.size()==0) {
//            heap.add(0);
//        }
//        heap.add(value);
//        //开始上升操作
//        swimUp(heap, heap.size() - 1);
//    }
//    /**
//     * 上浮操作
//     * @param k
//     */
//    private void swimUp(List<Integer> heap, int k){
//        while (k > 1 && heap.get(k / 2) < heap.get(k)){
//            swap(heap, k/2, k);
//            k = k/2;
//        }
//    }
//    private void sinkDown(List<Integer> heap, int k){
//        int len = heap.size();
//        while (2*k <= len){
//            int j = 2*k;
//            if (j < len && heap.get(j) < heap.get(j + 1)) {
//                j++;
//            }
//            if (heap.get(k) >= heap.get(j)) {
//                break;
//            }
//            swap(heap, k, j);
//            k = j;
//        }
//    }
//    private void swap(List<Integer> nums, int a, int b){
//        int tmp = nums.get(a);
//        nums.set(a, nums.get(b));
//        nums.set(b, tmp);
//    }
}
