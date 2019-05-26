import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.io.*;

//这里使用hashmap来对URL做处理，分别读入每个小文件，将URL名称和数量存在hashmap中，把数量做小根堆处理，最后输出10个最小的值

public class Main {
/*
 *
 *      这个位置的n值需要根据生成的小文件数量做调整
 *      因为是循环读入所有小文件
 *      数量与情况不同则会导致读入数据不完整
 */
    public static void main(String[] args) throws Exception{
        //System.out.println(System.getProperty("user.dir"));
        int n = 1;
        HashMap<String,Integer> HashURL = new HashMap<String, Integer>();
        while(n <= 115) {
            BufferedReader readTxt = new BufferedReader(new FileReader(new File( System.getProperty("user.dir") + "/" + n + ".txt")));

            String textLine = "";

            String str = "";

            while ((textLine = readTxt.readLine()) != null) {
                str += " " + textLine;
            }

            String[] numbersArray = str.split(" ");
            //System.out.println(numbersArray[66]);
            Integer i = 1;

            while (i < numbersArray.length) {
                String URL = numbersArray[i];
                if (HashURL.containsKey(URL) == false) {
                    HashURL.put(URL, 1);
                } else {
                    Integer count = HashURL.get(URL);
                    //System.out.println(count + URL + " " + i);
                    count = count + 1;
                    HashURL.put(URL, count);
                    //System.out.println(count);
                }
                i = i + 1;
            }
            n = n + 1;
            readTxt.close();

        }
        Set<String> keys = HashURL.keySet();
        for (String key : keys) {
            //System.out.println(key + " " + HashURL.get(key));
        }


        int size = 100;
        Heap heap = new Heap();
        // int[] data = new int[6];

        Heap foo = new Heap();
        Heap.foo[] data = new Heap.foo[size];
        for (int i = 0; i < size; i++) { // 初始化数组
            data[i] = foo.new foo();
        }

        for (int i = 0; i < size; i++) {
            data[i].setNumber(0);
            data[i].setUrl("a");
        }

        heap.buildHeapWithArray(data, size);
        for (String key : keys) {
            int num;
            num = HashURL.get(key);
            // System.out.println(num);
            int minEle = heap.getMin();
            // System.out.println(minEle);
            if (num > minEle) {
                heap.deleteMin();
                heap.insert(num, key);
                //System.out.println("After insert, min = " + heap.getMin());
            }
        }
        // System.out.println(Arrays.toString(data));
        for(int i = 0; i < size; i++) {
            System.out.println("count: " + data[i].count + " " + "url: " + data[i].url);
        }
    }
}
