import java.util.*;
public class nextPermutation {
	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
//		permute(str,0,n-1);
		int nums[] = new int[] {1,5,8,4,7,6,5,3,1};
		permuteEfficientApproach(nums);
		
	}
	
	private static void permuteEfficientApproach(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i+1] <= nums[i]){
            i--;
        }
        if(i>=0){
            int j= nums.length-1;
            while(j >=0 && nums[j] <= nums[i]){
                j--;
            }
            swapInt(nums,i,j);
        }
        reverse(nums,i+1);
    }
    
    public static void swapInt(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
    
    public static void reverse(int[] nums,int start){
        int i = start;
        int j = nums.length-1;
        while(i<j){
            swapInt(nums,i,j);
            i++;
            j--;
        }
    }

	public static void permute(String str, int l,int r) {
		if(l==r) {
			System.out.println(str);
		}
		
		else {
			for(int i=l; i<=r; i++) {
				str = swap(str,l,i);
				permute(str,l+1,r);
				str = swap(str,l,i);
			}
		}
	}
	
	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
