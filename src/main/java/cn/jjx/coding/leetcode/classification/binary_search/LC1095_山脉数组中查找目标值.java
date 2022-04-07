package cn.jjx.coding.leetcode.classification.binary_search;

public class LC1095_山脉数组中查找目标值 {

    public int findInMountainArray(int target,MountainArray mountainArray){
        int l=0,r=mountainArray.length()-1;
        while(l<r){
            int mid = (l+r)/2;
            if(mountainArray.get(mid)<mountainArray.get(mid+1)){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        int peak=l;
        int index =  binarySearch(mountainArray,target,0,peak,true);
        if(index!=-1){
            return index;
        }
        return binarySearch(mountainArray,target,peak+1,mountainArray.length()-1,false);


    }


    public int binarySearch(MountainArray mountainArray,int target,int l,int r,boolean flag){
        if(!flag){
            target *= -1;
        }
        while(l<=r){
            int mid = (l+r)/2;
            int cur = mountainArray.get(mid)*(flag?1:-1);
            if(cur==target){
                return mid;
            }else if(cur<target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }


    interface MountainArray{
        public int get(int index);
        public int length();
    }

}
