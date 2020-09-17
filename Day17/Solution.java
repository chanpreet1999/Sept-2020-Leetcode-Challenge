class Solution {
    public boolean isRobotBounded(String instructions) {
        int d = 0;
        int x = 0, y = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        for(int i  = 0; i < instructions.length(); i++)
        {
            char ch = instructions.charAt(i);
            if(ch == 'G')
            {
                x += dx[d];
                y += dy[d];
            }
            else
            {
                d = (d + (ch == 'L' ? 3 : 1) )%4;
            }
        }
        return x == 0 && y == 0 || d != 0;
    }
}