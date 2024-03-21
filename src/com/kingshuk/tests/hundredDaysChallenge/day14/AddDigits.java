package com.kingshuk.tests.hundredDaysChallenge.day14;

class AddDigits {
    /*
    Mathematical Solution:
        if ( num == 0 ) return 0;
        return num%9 == 0 ? 9 : num%9 ;
     */
    public static void main ( String[] args ) {
        System.out.println ( new AddDigits ().addDigits ( 0 ) );
    }

    public int addDigits ( int num ) {
        while (true) {
            int res = addUp ( num );
            if ( res / 10 == 0 )
                return res;
            num = res;
        }
    }

    private int addUp ( int num ) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}