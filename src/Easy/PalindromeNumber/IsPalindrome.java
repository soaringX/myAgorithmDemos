package Easy.PalindromeNumber;

import Easy.Reverse.Reverse;

public class IsPalindrome {
    /**
     * @Description: 判断是否是回文数
     * @Param: [num]
     * @return: boolean
     * @Author: xjp
     * @Date: 2019/2/22
     */
    public static boolean isPalindrome_1(int num) {
        int reverse = Reverse.reverse(num);
        if (reverse == num) {
            return true;
        }
        return false;
    }

    /**
     * @Description: 判断是否是回文数, 只用翻转一半数字即可
     * @Param: [num]
     * @return: boolean
     * @Author: xjp
     * @Date: 2019/2/22
     */
    public static boolean isPalindrome_2(int num) {
        //特殊情况
        //num<0时,不存在回文数,
        //当num的最后一位数为0时,第一位也必定是0,这样的回文数也不存在
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        int revertedNum = 0;
        //当num 的值小于 revertedNum时,翻转过半
        //存在两种情况,当num为奇数位时和偶数位时;
        //当为奇数位时,比如121,那么此时不满足循环条件时,
        // num =2,revertedNum = 12, num = revertedNum/10;
        //当为偶数时,比如1221,那么当不满足循环条件时,
        //num=12,revertedNum =12 ,num =revertedNum;
        while (num > revertedNum) {
            revertedNum = num % 10 + revertedNum * 10;
            num /= 10;
        }

        return num == revertedNum || num == revertedNum / 10;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome_2(121212123));
    }
}
