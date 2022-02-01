package com.kingshuk.tests.DynamicProgramming;


    public class EqualSumPartition {
        static boolean isEqualSumPossible(int arr[],int n)
        {
            int sum = 0;
            for(int i =0;i<n;i++)
            {
                sum = sum + arr[i];
            }
            boolean t[][] = new boolean[n+1][(sum/2)+1];
            if(sum%2!=0)
            {
                return false;
            }
            else if(sum%2==0)
            {
                for(int i =0;i<=n;i++) {
                    for (int j = 0; j <= sum / 2; j++) {
                        if(i==0)
                        {
                            t[i][j] = false;
                        }
                        if(j==0)
                        {
                            t[i][j] = true;
                        }
                    }
                }
               for(int i =1;i<=n;i++)
               {
                   for(int j =1;j<=sum/2;j++)
                   {
                       if(arr[i-1]>j)
                       {
                           t[i][j] = t[i-1][j];
                       }
                       else
                           t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                   }
               }
            }

            return t[n][sum/2];
        }

        public static void main(String args[]){
            int arr[] = {3, 1, 2, 2,1};
            int n = arr.length;
            if(isEqualSumPossible(arr,n))
            {
                System.out.println("Equal Partition is possible");
            }
            else
            {
                System.out.println("Equal Partition is not possible");
            }
        }

}
