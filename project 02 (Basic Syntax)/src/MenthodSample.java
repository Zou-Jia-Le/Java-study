public class MenthodSample {
    //成员方法
    public String isOddNumber(int num) {
        if(num % 2 == 0){
            return "偶数";
        }else{
            return "奇数";
        }
    }

    public static void main(String[] args) {
        /*int a = 10;
        if(a % 2 == 0){
            System.out.println(a+"是偶数");
        }else{
            System.out.println(a+"是奇数");
        }

        int b= 5;
        if(b % 2 == 0){
            System.out.println(b + "是偶数");
        }else{
            System.out.println(b + "是奇数");
        }*/

        int a=10;
        MenthodSample menthodSample = new MenthodSample();
        String r1 = menthodSample.isOddNumber(a);
        System.out.println(a + " 是" + r1);

        int b =5;
        String r2 = menthodSample.isOddNumber(b);
        System.out.println(b + " 是" + r2);
    }
}
