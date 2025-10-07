public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                array[i] = array[i] * 5;
            } else if (array[i] % 3 == 1) {
                array[i] = array[i] + 7;
            } else {
                continue;
            }
        }
        return array;
    }
}