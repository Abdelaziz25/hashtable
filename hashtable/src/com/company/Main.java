package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of Hash");
        int M = scan.nextInt();
        int n=M;
        M= (int) Math.pow(M,2);
        ArrayList<Integer> number = new ArrayList<Integer>();
        System.out.println("Insert elements ");
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums;
        strNums = bi.readLine().split(" ");
        if(strNums.length<=n)
        {

            for (int i = 0; i < strNums.length; i++) {
                number.add(Integer.parseInt(strNums[i])) ;
            }
        }
        else
        {
            String[] strNums2={};
            while (strNums2.length!=n)
            {
                System.out.println("Insert elements  less than size or equal to size of Hashtable");
                BufferedReader bi2 = new BufferedReader(
                        new InputStreamReader(System.in));
                strNums2 = bi2.readLine().split(" ");
            }
            for (int i = 0; i < strNums2.length; i++) {
                number.add(Integer.parseInt(strNums2[i])) ;
            }
        }
        String []hash = new String[M];
        int a = (int) (Math.log(hash.length) / Math.log(2));
        int [][] h = new int[a][32];
        filling_Matrix fill =new filling_Matrix();
        fill.fill(h);
        for(int i=0;i<number.size();i++)
        {
           hash= fill.insert(hash,h,number.get(i));
        }
        System.out.println("Number of Rehashed times :");
        System.out.println(fill.no_Rehashed_times);
        System.out.println("\nHash Table O(n^2): ");
        for (int i = 0; i < hash.length; i++)
            System.out.print(hash[i] + " ");
        System.out.println();
        System.out.println("Total length of array ");
        System.out.println(hash.length);
        System.out.println();
        System.out.println("Hash table O(n): ");
        String[][] arrays = new String[n][];
        String[][] arrays2 = new String[0][];
        int [][] h2 = new int[a][32];
        fill.fill(h2);
        for(int i=0;i<arrays.length;i++)
        {
            arrays[i]=new String[]{null};
        }
        for(int i=0;i<number.size();i++)
        {
            arrays2= fill.insert2(arrays,h2,number.get(i));
        }
        int z=0;
        for(String[] arr: arrays2) {
            if(arr.length==1 && arr[0]!=null || arr.length!=1)
            {
                z=z+arr.length;
            }
            for(String n2: arr) {
                System.out.print(n2+" ");
            }
            System.out.println();
        }
        System.out.println("Total length of arrays ");
        System.out.println(z);
    }
}
