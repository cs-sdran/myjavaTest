import java.util.ArrayList;
import java.util.HashMap;
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
/*class Solution {
    public int rob(int[] nums) {
         int max=0;
         if(nums.length==0)
             return max;
         if(nums.length==1)
             return nums[0];
         if(nums.length==2)
             return Math.max(nums[0],nums[1]);
         if(nums.length>2) {
             int[] prices = new int[nums.length];//prices[i]为偷窃前i个房屋所能得到的最大金额
             prices[0] = nums[0];
             prices[1] = Math.max(nums[0], nums[1]);
             //如果偷了第i个房屋，则不能偷窃第i-1个房屋，只能偷窃第i-2个房屋
             for(int i=2;i< nums.length;i++)
             {
                 prices[i]=Math.max(prices[i-1],nums[i]+prices[i-2]);
                 //偷不偷当前房屋取决于偷了此房屋之后，与i-2个房屋之和能不能超过i-1个房屋
                  max=Math.max(max,prices[i]);
             }


         }
        return max;


    }
}*/


/*4.27*/
/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；
换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。*//*
class Solution {
    public int numSquares(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
    }
}*/
/*给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

        计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

        你可以认为每种硬币的数量是无限的。

        class Solution {
            public int coinChange(int[] coins, int amount) {
                if(amount==0)
                    return 0;
                int []dp=new int[amount+1];

                if(amount>=1)
                {
                    for(int i=1;i<amount+1;i++){
                        dp[i]=amount+1;
                        for(int j=0;j<coins.length;j++){
                            if(i-coins[j]>=0)
                                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                        }

                    }

                }
                return dp[amount] > amount ? -1 : dp[amount];
            }
        }*/
/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
        子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
        例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
        class Solution {
            public int lengthOfLIS(int[] nums) {
                int dp[]=new int[nums.length+1];//dp数组记录到第i个元素为止的最长递增子序列
                int max=0;
                if(nums.length==0)
                    return 0;

                for(int i=0;i<nums.length;i++)
                {
                    dp[i]=1;
                    for(int j=i-1;j>=0;j--)
                    {
                        if(nums[j]<nums[i]&&dp[j]+1>=dp[i])
                            dp[i]=dp[j]+1;


                    }
                    max=Math.max(max,dp[i]);
                }
                return max;
            }
        }*/



/*
class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];//记录最大乘积
        int maxdp=nums[0];//记录前方最大乘积
        int mindp=nums[0];//记录前方最小乘积
        if(nums.length==1)
            return nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int nowmax=maxdp;
            int nowmin=mindp;
            maxdp=Math.max(nums[i],Math.max(nowmax*nums[i],nowmin*nums[i]));
            mindp=Math.min(nums[i],Math.min(nowmax*nums[i],nowmin*nums[i]));

            max=Math.max(max,maxdp);
        }
        return max;


    }
}*/

/*
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int res[]=new int[len];
        res[0]=1;
        for(int i=1;i<len;i++)
        {

            res[i]=res[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }
}*/
