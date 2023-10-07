import java.util.Arrays;

public class SDES {

    // 初始置换表（IP）
    private static final int[] IP = {2, 6, 3, 1, 4, 8, 5, 7};

    // 扩展置换表（EP）
    private static final int[] EP = {4, 1, 2, 3, 2, 3, 4, 1};

    // P4置换表
    private static final int[] P4 = {2, 4, 3, 1};

    // 逆初始置换表（IP^-1）
    private static final int[] IP_INV = {4, 1, 3, 5, 7, 2, 8, 6};
    // P10置换表
    private static final int[] P10 = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};

    // P8置换表
    private static final int[] P8 = {6, 3, 7, 4, 8, 5, 10 ,9};

    // S-盒表
    private static final int[][] S0 = {
            {1, 0, 3, 2},
            {3, 2, 1, 0},
            {0, 2, 1, 3},
            {3, 1, 0, 2}
    };

    private static final int[][] S1 = {
            {0, 1, 2, 3},
            {2, 3, 1, 0},
            {3, 0, 1, 2},
            {2, 1, 0, 3}
    };

    // P4置换函数
    private static int[] permuteP4(int[] input) {
        int[] output = new int[4];
        for (int i = 0; i < 4; i++) {
            output[i] = input[P4[i] - 1];
        }
        return output;
    }

    // P10置换
    private static int[] permuteP10(int[] key) {
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            result[i] = key[P10[i]-1];
        }
        return result;
    }

    // P8置换
    private static int[] permuteP8(int[] key) {
        int[] result = new int[8];
        for (int i = 0; i < 8; i++) {
            result[i] = key[P8[i]-1];
        }
        return result;
    }

    // 扩展函数 EP
    private static int[] expandEP(int[] input) {
        int[] output = new int[8];
        for (int i = 0; i < 8; i++) {
            output[i] = input[EP[i] - 1];
        }
        return output;
    }

    // 两个位数组进行异或操作
    private static int[] xor(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] ^ b[i];
        }
        return result;
    }

    // S-盒替换
    private static int[] sBox(int[] input, int[][] sBoxTable) {
        int row = input[0] * 2 + input[3];
        int col = input[1] * 2 + input[2];
        int value = sBoxTable[row][col];
        return new int[]{(value >> 1) & 1, value & 1};
    }

    // F函数
    private static int[] fFunction(int[] r, int[] subKey) {
        int[] expandedR = expandEP(r);
        int[] xorResult = xor(expandedR, subKey);
        int[] s0Input = Arrays.copyOfRange(xorResult, 0, 4);
        int[] s1Input = Arrays.copyOfRange(xorResult, 4, 8);

        int[] s0Output = sBox(s0Input, S0);
        int[] s1Output = sBox(s1Input, S1);

        int[] p4Input = concat(s0Output, s1Output);
        return permuteP4(p4Input);
    }

    // 循环左移
    private static int[] circularLeftShift(int[] input) {
        int temp = input[0];
        for (int i = 0; i < input.length - 1; i++) {
            input[i] = input[i + 1];
        }
        input[input.length - 1] = temp;
        return input;
    }

    // 连接两个位数组
    private static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    // 初始置换（IP）
    private static int[] initialPermutation(int[] input) {
        int[] output = new int[8];
        for (int i = 0; i < 8; i++) {
            output[i] = input[IP[i] - 1];
        }
        return output;
    }

    // 逆初始置换（IP^-1）
    private static int[] inverseInitialPermutation(int[] input) {
        int[] output = new int[8];
        for (int i = 0; i < 8; i++) {
            output[i] = input[IP_INV[i] - 1];
        }
        return output;
    }

    // 密钥生成
    private static int[][] generateSubKeys(int[] key) {
        int[] p10Result = permuteP10(key);
        int[] leftShift1 = circularLeftShift(Arrays.copyOfRange(p10Result, 0, 5));
        int[] leftShift2 = circularLeftShift(Arrays.copyOfRange(p10Result, 5, 10));
        int[] leftShiftedKey = concat(leftShift1, leftShift2);
        int[][] subKeys = new int[2][];
        subKeys[0] = permuteP8(leftShiftedKey);//k1
        leftShift1 = circularLeftShift(leftShift1);
        leftShift2 = circularLeftShift(leftShift2);
        leftShiftedKey = concat(leftShift1, leftShift2);
        subKeys[1] = permuteP8(leftShiftedKey);//k2
        return subKeys;
    }

    // 使用10位密钥加密8位明文
    public static int[] encrypt(int[] plaintext, int[] key) {
        int[][] subKeys = generateSubKeys(key);
        int[] initialPermutationResult = initialPermutation(plaintext);
        int[] left = Arrays.copyOfRange(initialPermutationResult, 0, 4);
        int[] right = Arrays.copyOfRange(initialPermutationResult, 4, 8);
        int[] fResult = fFunction(right, subKeys[0]);
        int[] xorResult = xor(left, fResult);
        int[] swapped = concat(right, xorResult);
        left = Arrays.copyOfRange(swapped, 0, 4);
        right = Arrays.copyOfRange(swapped, 4, 8);
        fResult = fFunction(right, subKeys[1]);
        xorResult = xor(left, fResult);
        return inverseInitialPermutation(concat(xorResult, right));
    }

    // 使用10位密钥解密8位密文
    public static int[] decrypt(int[] ciphertext, int[] key) {
        int[][] subKeys = generateSubKeys(key);
        int[] initialPermutationResult = initialPermutation(ciphertext);
        int[] left = Arrays.copyOfRange(initialPermutationResult, 0, 4);
        int[] right = Arrays.copyOfRange(initialPermutationResult, 4, 8);
        int[] fResult = fFunction(right, subKeys[1]);
        int[] xorResult = xor(left, fResult);
        int[] swapped = concat(right, xorResult);
        left = Arrays.copyOfRange(swapped, 0, 4);
        right = Arrays.copyOfRange(swapped, 4, 8);
        fResult = fFunction(right, subKeys[0]);
        xorResult = xor(left, fResult);
        return inverseInitialPermutation(concat(xorResult, right));
    }
}
