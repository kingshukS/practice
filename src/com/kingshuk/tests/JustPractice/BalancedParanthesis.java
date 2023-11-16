package com.kingshuk.tests.JustPractice;

import java.util.Stack;

public class BalancedParanthesis {
    static boolean isSame(Character c1,Character c2)
    {
        if(c1 == '{' && c2 == '}')
        {
            return true;
        }
        if(c1 == '(' && c2 == ')')
        {
            return true;
        }
        return c1 == '[' && c2 == ']';
    }
    static boolean isBalancedParan(char[] paran)
    {
        Stack<Character> s = new Stack<>();
        for(int i =0;i<paran.length;i++)
        {
            if(paran[i] == '{' || paran[i] == '(' || paran[i] == '[')
            {
                s.push(paran[i]);
            }
            if(paran[i]== '}' || paran[i]== ')' || paran[i]== ']')
            {
                if(s.isEmpty())
                {
                    return false;
                }
                if(isSame(s.pop(),paran[i]))
                {
                    s.pop();
                    return true;
                }

            }
        }
        return false;
    }
    public  static void main(String[] args)
    {
        char[] paran = {'[','(',']',')'};
        if(isBalancedParan(paran))
        {
            System.out.println("The paranthesis are balanced");
        }
        else
        {
            System.out.println("The paranthesis are not balanced");
        }
    }
}
