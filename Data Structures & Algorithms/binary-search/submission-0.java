class Solution {
    public int search(int[] arr, int target) {
        int l=0;
        int high=arr.length-1;
        while(l<=high){
            int mid=(l+high)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                l=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
