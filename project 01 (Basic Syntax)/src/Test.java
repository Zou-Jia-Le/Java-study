public class Test {
    public static void main(String[] args) {
        int num = 999;
        int count = 0;
        int temp = num;

        if (temp == 0) {
            count = 1;
        } else {
            for ( ; temp != 0; temp /= 10) {
                count++;
            }
        }
        System.out.print(num + "，");
        System.out.println("它是个" + count + "位的数！");
    }
}
