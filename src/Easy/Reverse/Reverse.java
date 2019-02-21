package Easy.Reverse;

public class Reverse {
    public static void main(String[] args) {
        int reverse = reverse(1232321311);
        System.out.println(reverse);
    }
    /**
    * @Description: 翻转方法(数学方法)
     *
    * @Param: [x]
    * @return: int
    * @Author: xjp
    * @Date: 2019/2/21
    */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            //求余数
            int pop = x % 10;
            //除以10
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            /**
             * Integer.MAX_VALUE = 2147483647
             * Integer.MIN_VALUE = -2147483648
             * rev * 10 + pop存在溢出可能,
             * 分析:假设rev为正数,如果出现溢出,必定
             * rev*10 >= max/10;
             * 如果 rev*10 = max/10 那么 pop最大值为7,否则溢出;
             * 假设rev为负数,如果出现溢出,必定
             * rev*10<=min/10;
             * 如果rev*10 = min,那么,pop最小值为-8,否则溢出
             */
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
