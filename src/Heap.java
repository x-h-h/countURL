import java.util.Arrays;

//这里做小根堆的操作，将堆顶的最小值不断替换出去，剩下的100个数为最大值

public class Heap {
//设计一个结构体，存数量和URL名称
    public class foo {
        public int count;
        public String url;

        public void setNumber(int number) {
            this.count = number;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    foo[] array; // int[] array;
    int size;

    public void buildHeapWithArray(foo[] array, int size) {
        if (size > array.length)
            throw new RuntimeException("元素个数超过数组大小");

        this.array = array;



        this.size = size;
        for (int i = size / 2 - 1; i >= 0; i--)
            percolateDown(i);
    }
    //删除小的值
    public int deleteMin() {
        if (size == 0)
            throw new RuntimeException("堆中没有元素，无法删除");

        int minItem = array[0].count;
        //System.out.println("size1: " + size);
        array[0].count = array[--size].count;
        array[0].url = array[size].url;
        //System.out.println("size2: " + size);
        array[size].count = -1; // 删除的元素放在数组最后，值为-1

        percolateDown(0);

        return minItem;
    }
    //插入大的值
    public void insert(int x, String xx) {
        if (size == array.length)
            throw new RuntimeException("数组已满，无法插入");
        int hole = size++;
        // 上滤
        for (; hole != 0; hole = (hole - 1) / 2) {
            if (x < array[(hole - 1) / 2].count && xx != array[(hole - 1) / 2].url) {
                array[hole].count = array[(hole - 1) / 2].count;
                array[hole].url = array[(hole - 1) / 2].url;
            }
            else
                break;
        }
        array[hole].count = x;
        array[hole].url = xx;


    }
    //获取最小值
    public int getMin() {
        return array[0].count;
    }

    // 若堆元素从数组0索引开始，对第i号元素，子节点为(2i+1,2i+2)，父节点为(i-1)/2
    private void percolateDown(int hole) {
        int tmp = array[hole].count;
        String emp = array[hole].url;
        int childIndex;

        for (; hole * 2 <= size - 2; hole = childIndex) {
            childIndex = hole * 2 + 1;
            if (childIndex != size - 1 && array[childIndex + 1].count < array[childIndex].count && array[childIndex + 1].url != array[childIndex].url)
                childIndex++;

            if (tmp > array[childIndex].count && emp != array[childIndex].url) {
                array[hole].count = array[childIndex].count;
                array[hole].url = array[childIndex].url;
            }
            else
                break;
        }
        array[hole].count = tmp;
        array[hole].url = emp;
    }
}