public class MulChart {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int b[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int i = 1 ; i < 10; i++){
            for(int j = 1 ; j <= i; j++){
                System.out.print("|" + j + "x" + i + "=" + a[i-1] * b[j-1] + "|");
            }
            System.out.println();
        }
    }
}
