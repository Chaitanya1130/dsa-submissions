class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>list=new ArrayList<>();
        int thresh=nums.length/3;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer>m:map.entrySet()){
            if(m.getValue()>thresh){
                list.add(m.getKey());
            }
        }
        return list;
    }
}