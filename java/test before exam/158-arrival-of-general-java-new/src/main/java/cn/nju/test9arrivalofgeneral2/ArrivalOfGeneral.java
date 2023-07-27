package cn.nju.test9arrivalofgeneral2;

public class ArrivalOfGeneral {
    /**
     * 处理士兵交换次数
     * @param num 士兵个数
     * @param heightArr 身高数组
     * @return 交换次数
     */
    public static int calculate(int num, int[] heightArr) {
        int maxxiabiao = num - 1;
        int count = 0;
        for (int i = 0; i < num - 1;i++){
            if (heightArr[i] > heightArr[maxxiabiao]) {
                maxxiabiao = i;
            }
        }

        count = maxxiabiao;
        for (int i = 0; i < maxxiabiao; i++) {
            int tmp = heightArr[maxxiabiao - i];
            heightArr[maxxiabiao - i] = heightArr[maxxiabiao - i - 1];
            heightArr[maxxiabiao - i - 1] = tmp;
        }

        int minxiabiao = 0;
        for (int i = 0; i < num;i++){
            if (heightArr[i] < heightArr[minxiabiao]) {
                minxiabiao = i;
            }
        }

        count = count + num - 1- minxiabiao;
        return count;
    }

}
