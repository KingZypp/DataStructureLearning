/**
 * 稀疏数组学习代码
 *
 * @author KingZYpp
 * @create 2021-09-17-15:17
 */

public class SparseArray {
    /**
     * 二维数组转稀疏数组
     *
     * @param arr 二维数组
     */
    public static int[][] arrayToSparesArr(int[][] arr) {
        // 取首行信息建立稀疏数组
        int sparseArrRow = arr[0][0];
        int sparseArrCol = arr[0][1];
        // int it = arr[0][2];
        int[][] sparseArr = new int[sparseArrRow][sparseArrCol];
        // 更新特殊位置数据
        for (int i = 1; i < arr.length; i++) {
            int[] spePoint = arr[i];
            int speRow = spePoint[0];
            int speCol = spePoint[1];
            int speVal = spePoint[2];
            // 更新
            sparseArr[speRow][speCol] = speVal;
        }
        // 返回最终稀疏矩阵
        return sparseArr;

    }

    /**
     * 稀疏数组转二维数组
     *
     * @param sparseArr
     * @return
     */
    public static int[][] sparseArrToArr(int[][] sparseArr) {
        // 遍历稀疏数组查找特殊点数量
        int arrRow = 0;
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                if (sparseArr[i][j] != 0) arrRow++;
            }
        }
        // 创建数组并初始化第一行内容
        int[][] arr = new int[arrRow + 1][3];
        arr[0][0] = sparseArr.length;
        arr[0][1] = sparseArr[0].length;
        arr[0][2] = arrRow;

        // 遍历稀疏数组更新数组内特殊点信息
        int count = 1;

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                if (sparseArr[i][j] != 0) {
                    arr[count][0] = i;
                    arr[count][1] = j;
                    arr[count][2] = sparseArr[i][j];
                    count++;
                    if (count == arrRow) {
                        break;
                    }
                }
            }
        }

        // 返回数组
        return arr;

    }


    /**
     * 打印二维数组
     *
     * @param arr
     */
    public static void show2_dArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] arr = new int[3][3];
        int[][] arr = new int[][]{{11, 11, 3}, {1, 2, 1}, {2, 3, 2}, {4, 5, 2}};
        int[][] sparseArr = arrayToSparesArr(arr);
        System.out.println("---稀疏数组---");
        show2_dArr(sparseArr);
        int[][] newArr = sparseArrToArr(sparseArr);
        System.out.println("---二维数组---");
        show2_dArr(newArr);


    }
}
