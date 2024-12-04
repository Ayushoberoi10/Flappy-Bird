import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class crud {
    private static int one = 55;
    int two = 35;

    // static int[] creat(){
//         System.out.println("Size of array");
//         Scanner sc = new Scanner(System.in);
//         int size;
//         size = sc.nextInt();
//         int[] a = new int[size];
//         for(int i=0;i<size;i++){
//             System.out.println("Enter value");
//             int ele = sc.nextInt();
//             a[i] = ele;

//         }
//         for(int i=0;i<size;i++){
//             System.out.println("Element are :"+a[i]);
//         }
//         return a;
//     }
//    static void read(int[] a){
//    try {
//             System.setOut(new PrintStream("C:\\Users\\lenovo\\Documents\\read.txt"));
//             for (int i = 0; i < a.length; i++) {
//                 System.out.println(a[i]);
//             }
//         } catch (FileNotFoundException e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//     }
//     static void update(int[] a){
//         System.out.println("Inter index");
//         Scanner sc = new Scanner(System.in);
//         int ind = sc.nextInt();
//         System.out.println("Enter element");
//         int ele = sc.nextInt();
//         a[ind] = ele;
//         for(int i=0;i<a.length;i++){
//         System.out.println("Updated array:"+a[i]);}
//     }
//     static void delete(int[] a){
//         System.out.println("Enter the index to delete from Array");
//         Scanner sc = new Scanner(System.in);
//         int index=sc.nextInt();
//         int i;
//         for(i=index;i<a.length-1;i++)
//         {
//             a[i]=a[i+1];

//         }
//         a[i]=0;


    public static void main(String[] args){
        crud test = new crud();
        int today = 22;
        two = 42;
        System.out.println(today+test.two+test.one);
        // creat();
        // read(null);
        // update(null);
        // delete(null);
    }
    
}
