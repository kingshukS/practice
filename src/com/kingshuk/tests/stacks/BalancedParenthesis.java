package com.kingshuk.tests.stacks;

import java.util.ArrayDeque;

public class BalancedParenthesis {
    public static void main ( String[] args ) {
        String parenthesis = "(()))";
        boolean isBalanced = isBalancedParenthesis ( parenthesis );
        System.out.println ( "Is parenthesis balanced? " + ( isBalanced ? " yes" : " no" ) );
    }

    private static boolean isBalancedParenthesis ( String parenthesis ) {
        if ( parenthesis.equals ( "" ) || parenthesis == null )
            return true;
        ArrayDeque<Character> stack = new ArrayDeque<> ();
        for ( int i = 0; i < parenthesis.length (); i++ ) {
            char presentChar = parenthesis.charAt ( i );
            if ( presentChar == '(' || presentChar == '{' || presentChar == '[' )
                stack.push ( presentChar );
            else if ( presentChar == ')' || presentChar == '}' || presentChar == ']' ) {
                if ( stack.isEmpty () )
                    return false;
                char topChar = stack.peek ();
                if ( isNotMatching ( presentChar, topChar ) )
                    return false;
                stack.pop ();
            } else {
                return false;
            }
        }
        return stack.isEmpty ();
    }

    private static boolean isNotMatching ( char presentChar, char topChar ) {
        return ( presentChar == ')' && topChar != '(' ) || ( presentChar == '}' && topChar != '{' ) || ( presentChar == ']' && topChar != '[' );
    }
}
