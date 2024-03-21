package com.kingshuk.tests.Arrays;

import java.util.Stack;

public class Balancedparanthesis {


    static boolean isparanBalanced ( char[] exp ) {
        Stack<Character> st = new Stack<> ();

        for ( int i = 0; i < exp.length; i++ ) {
            if ( exp[i] == '(' || exp[i] == '{' || exp[i] == '[' ) {
                st.push ( exp[i] );
            }
            if ( exp[i] == ')' || exp[i] == '}' || exp[i] == ']' ) {
                if ( st.isEmpty () ) {
                    return false;
                } else if ( ! balanceCheck ( st.pop (), exp[i] ) ) {
                    return false;
                }
            }
        }
        /*not balanced*/
        return st.isEmpty (); /*balanced*/
    }

    static boolean balanceCheck ( char exp2, char exp1 ) {
        if ( exp2 == '(' && exp1 == ')' ) {
            return true;
        } else if ( exp2 == '{' && exp1 == '}' ) {
            return true;
        } else return exp2 == '[' && exp1 == ']';
    }

    public static void main ( String[] args ) {
        char[] exp = { '{', '(', ')', '}', '[', ']' };
        if ( isparanBalanced ( exp ) ) {
            System.out.println ( "The expression has balanced parathesis" );
        } else {
            System.out.println ( "The expression does not have balanced parathesis" );
        }
    }
}
