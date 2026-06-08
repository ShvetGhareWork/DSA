
public static void main(String[] args) {
    int[] arr = {3, 5, 2, 1, 4, 6, 7, 8, 9, 10, 12, 11, 14, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
    cyclicSort(arr);
    System.out.println(java.util.Arrays.toString(arr));
    
}
 static void cyclicSort(int[] arr){
    int i = 0;
    while(i < arr.length){
        int correctIndex = arr[i] - 1;
        if(arr[i] != arr[correctIndex]){
            swap(arr, i, correctIndex);
        }
        else{
            i++;
        }
    }
 }

 static void swap(int[] arr, int num1, int num2){
    int temp = arr[num1];
    arr[num1] = arr[num2];
    arr[num2] = temp;
 }