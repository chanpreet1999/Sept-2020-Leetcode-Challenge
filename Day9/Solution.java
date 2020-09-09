class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int i,j;
        for(i = 0, j = 0; i < v1.length && j < v2.length; i++, j++ )
        {
            String str1 = v1[i];
            String str2 = v2[j];
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);
            if(num1 > num2)
                return 1;
            else if(num2 > num1)
                return -1;
        }
        
        while(i < v1.length)
        {
            String str1 = v1[i];
            int num1 = Integer.parseInt(str1);
            System.out.println(num1);
            if(num1 != 0)
                return 1;
            i++;
        }
        
        while(j < v2.length)
        {
            String str2 = v2[j];
            int num2 = Integer.parseInt(str2);
            if(num2 != 0)
                return -1;
            j++;
        }
        
        return 0;
    }

    //shorter way same time more space
    public int compareVersion2(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        
        int maxLength = Math.max(v1.length, v2.length);
        for(int i = 0; i < maxLength; i++)
        {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]): 0;
            if(num1 > num2)
                return 1;
            else if(num2 > num1)
                return -1;           
        }
        return 0;        
        
    }
}