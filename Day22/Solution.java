class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList();
        
        int num1 = -1, num2 = -1, c1 = 0, c2 = 0;   //double moores algo as there can be only 2 majority elements
        
        for(int ele : nums)
        {
            if( ele == num1 )
                c1++;       // increment count1  
            else if(ele == num2)
                c2++;        // increment count2
            
            else if( c1 == 0 )  //reset
            {
                num1 = ele;
                c1 = 1;             
            }
            else if(c2 == 0)
            {
                num2 = ele;
                c2 = 1;
            }
            else        //drecrement
            {
                c1--;
                c2--;
            }
        }
        
        int cn1 = 0, cn2 = 0;
        
        for(int ele : nums)     // to confirm majority
        {
            if(ele == num1)
                cn1++;
            else if(ele == num2)
                cn2++;
        }
        
        if(cn1 > nums.length/3)
            ans.add(num1);
          if(cn2 > nums.length/3)
            ans.add(num2);
        
        return ans;
    }
}