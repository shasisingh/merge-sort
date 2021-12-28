import java.time.LocalDateTime;
import java.util.Random;

class MergeSort {
    public static void main(String[] args) {

        int[] inputArray = new int[100];
        final Random random = new Random();
        for (var i = 0; i < inputArray.length; i++) {
            inputArray[i] = random.nextInt(1000000);
        }

        System.out.println("Before That:" + LocalDateTime.now());
        beforeThat(inputArray);
        mergeSort(inputArray);
        System.out.println("After That:" + LocalDateTime.now());
        afterThat(inputArray);
    }

    private static void mergeSort(int[] inputData) {
        int maxLength = inputData.length;
        int midIndex = maxLength / 2;

        if (maxLength == 1) {
            return;
        }
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[maxLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputData[i];
        }

        for (int i = midIndex; i < maxLength; i++) {
            rightHalf[i - midIndex] = inputData[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputData, leftHalf, rightHalf);

    }

    private static void merge(int[] inputData, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {

            if (leftHalf[i] <= rightHalf[j]) {
                inputData[k] = leftHalf[i];
                i++;
            } else {
                inputData[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            inputData[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            inputData[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    private static void beforeThat(int[] inputData) {
        for (int inputDatum : inputData) {
            System.out.println(inputDatum);
        }
    }

    private static void afterThat(int[] inputData) {
        for (int inputDatum : inputData) {
            System.out.println(inputDatum);
        }
    }
}
