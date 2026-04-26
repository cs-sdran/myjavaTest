import java.util.ArrayList;
import java.util.List;

/*2026.4.26
*//*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？*//*
class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if (n == 1) return first;
        if (n == 2) return second;
        if(n>2) {
            for (int i = 3; i <= n; i++) {
                int third = first + second;
                first = second;
                second = third;
            }
            return second;
        }
    }
}*/


/*给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。*//*
class Solution {//numRows即为每行添加的数字个数
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==1)
        {
            res.add(new ArrayList<>());
            res.get(0).add(1);
        }
        if(numRows>=2)
        {
            res.add(new ArrayList<>());
            res.get(0).add(1);
            for(int i=1;i<numRows;i++)
            {res.add(new ArrayList<>());
                res.get(i).add(1);
                for(int j=1;j<i;j++)
                {
                    res.get(i).add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
                }
                res.get(i).add(1);
            }
        }
        return res;
    }
}*/

/*你是一个专业的小偷，计划偷窃沿街的房屋。
每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
一夜之内能够偷窃到的最高金额。*/
class Solution {
    public int rob(int[] nums) {
         int max=0;
         if(nums.length==0)
             return max;
         if(nums.length==1)
             return nums[0];
        int[] prices = new int[nums.length];

    }
}
