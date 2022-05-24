package com.company;
import java.util.ArrayList;
public class filling_Matrix {
    ArrayList<Integer> Num= new ArrayList<>();
    ArrayList<String> Num2= new ArrayList<>();
    int no_Rehashed_times=0;
    /// function to insert element inside hash without collision ;
    public String [] insert(String[] hash, int [][]h, int n )
    {
        Num.add(n);
        int [][]number;
        number=convert_number_to_binary(n);
        int res[][];
         res = multiply(h,number);
        int decimal = convert_to_decimal(res);
      if(hash[decimal]==null)
      {
          hash[decimal]=Integer.toString(n);
      }
      else
      {
          int i=0;
          fill(h);
          no_Rehashed_times++;
          for(int j=0;j<hash.length;j++)
          {
              hash[j]=null;
          }
          while(i!=Num.size())
          {
              number=convert_number_to_binary(Num.get(i));
              res = multiply(h,number);
              decimal = convert_to_decimal(res);
              if(hash[decimal]==null)
              {
                  hash[decimal]=Integer.toString(Num.get(i));
                  i++;
              }
              else
              {
                  i=0;
              }
             if(i==0)
             {
                 for(int j=0;j<hash.length;j++)
                 {
                     hash[j]=null;
                 }
                 fill(h);
                 no_Rehashed_times++;
             }
          }
      }
        return hash;
    }
    /// function to convert answer of multiply to decimal to get the place where the element should be placed;
    public int convert_to_decimal(int [][]res)
    {
        String num="";
        for(int i=0;i<res.length;i++)
        {
            for (int j=0;j<res[i].length;j++)
            {
                num=num+(res[i][j]%2);

            }
        }
        int decimal = Integer.parseInt(num,2);
        return decimal;
    }
    /// function to multiply matrix h and matrix x;
    public  int [][] multiply(int [][]h,int [][]number)
    {
        int res[][]= new int [h.length][1];
        for(int i=0;i<h.length;i++)
        {
            for (int j=0;j<number[0].length;j++)
            {
                for(int k=0;k<number.length;k++)
                {
                    res[i][j]+= h[i][k]*number[k][j];
                }
            }
        }
        return res;
    }
    /// function is used to fill matrix h with different values of 0 or 1 ;
    public int [][] fill(int[][]h)
    {
        for(int i=0;i<h.length;i++)
        {
            for (int j =0 ;j<h[0].length;j++)
            {
                Double rand2= Math.random();
                int rand ;
                if(rand2-0.5>0)
                {
                    rand=1;
                }
                else
                {
                    rand=0;
                }
                h[i][j]=rand;
            }
        }
        return h;
    }
    /// function is used to convert number to binary;
    public int[][] convert_number_to_binary( int n)
    {
        int[][] binaryNum = new int[32][1];
        if(n>0)
        {
            int i = 0;
            while (n > 0)
            {
                // storing remainder in binary array
                binaryNum[i][0] = n % 2;
                n = n / 2;
                i++;
            }
            for(int s=i;s<binaryNum.length;s++)
            {
                for (int j=0;j<1;j++)
                {
                    binaryNum[s][j]=0;
                }
            }
        }
        else
        {
            String num= Integer.toBinaryString(n);
            int sum= binaryNum.length-1;
            for(int i=0;i<num.length();i++)
            {
                binaryNum[sum][0]=num.charAt(i);
            }
            for(int s=sum;s>0;s--)
            {
                for (int j=0;j<1;j++)
                {
                    binaryNum[s][j]=0;
                }
            }
        }
        return binaryNum;
    }
    public String[] []  insert2( String[][] hash ,int [][]h,int n )
    {
        int [][]number;
        number=convert_number_to_binary(n);
        int res[][];
        res = multiply(h,number);
        int decimal = convert_to_decimal(res);
        if(decimal>=hash.length)
        {
            decimal=decimal%hash.length;
        }
        if(hash[decimal].length==1&&hash[decimal][0]==null)
        {
            hash[decimal][0]=Integer.toString(n);
        }
        else
        {
            ArrayList<String> Num2= new ArrayList<>();
            int f=decimal;
            for(int z=0;z<hash[decimal].length;z++)
            {
                if(hash[decimal][z]!=null)
                {
                    Num2.add(hash[decimal][z]);
                }
            }
            Num2.add(Integer.toString(n));
            int z=Num2.size();
            int i=0;
            hash[decimal]=new String[(int)Math.pow(z,2)];
            for(int j=0;j<hash[decimal].length;j++)
            {
                hash[decimal][j]=null;
            }
            h=new int[Num2.size()][32];
            fill(h);
            while(i!=Num2.size() )
            {

                number=convert_number_to_binary(Integer.parseInt(Num2.get(i)));
                res = multiply(h,number);
                decimal = convert_to_decimal(res);
                if(decimal>=hash[f].length)
                {
                    decimal=decimal%hash.length;
                }
                if(hash[f][decimal]==null)
                {
                    hash[f][decimal]=Num2.get(i);
                    i++;
                }
                else
                {
                    i=0;
                }
                if(i==0)
                {
                    for(int j=0;j<hash[f].length;j++)
                    {
                        hash[f][j]=null;
                    }
                    fill(h);
                }
            }
        }
        return hash;
    }
}
