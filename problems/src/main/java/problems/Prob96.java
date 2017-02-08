package problems;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob96 {
    public static boolean nextPerm(int [] nums)
    {
        int i =  nums.length - 2;
        while(i >= 0) {
            if(nums[i] < nums[i + 1])
                break;
            i--;
        }
        if (i ==  -1) {
            return false;
        }
        int j =  nums.length - 1;
        while(j > i) {
            if(nums[j]>nums[i])
                break;
            j--;
        }
        if (j != i) {
            swap(i,j,nums);
        }
        int k = i + 1;
        int l = nums.length - 1;
        while(k < l) {
            swap(k,l,nums);
            k++;
            l--;
        }
        return true;
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public static void printAllPermutations(int[] nums) {
        while (nextPerm(nums)) {
            for (int i : nums)
                System.out.print(i);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printAllPermutations(new int[]{1, 2, 3, 4});
    }
}
