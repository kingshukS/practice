package com.kingshuk.tests.graph;

import java.util.*;

class AccountMerge {

    public static void main ( String[] args ) {
        List<String> account1 = new ArrayList<> ();
        account1.add ( "John" );
        account1.add ( "johnsmith@mail.com" );
        account1.add ( "john_newyork@mail.com" );

        List<String> account2 = new ArrayList<> ();
        account2.add ( "John" );
        account2.add ( "johnsmith@mail.com" );
        account2.add ( "john00@mail.com" );

        List<String> account3 = new ArrayList<> ();
        account3.add ( "Mary" );
        account3.add ( "mary@mail.com" );

        List<String> account4 = new ArrayList<> ();
        account4.add ( "John" );
        account4.add ( "johnnybravo@mail.com" );

        List<List<String>> accountList = new ArrayList<> ();
        accountList.add ( account1 );
        accountList.add ( account2 );
        accountList.add ( account3 );
        accountList.add ( account4 );

        List<List<String>> mergedList = new AccountMerge ().accountsMerge ( accountList );
        System.out.println ( mergedList );
    }

    public List<List<String>> accountsMerge ( List<List<String>> accounts ) {
        int n = accounts.size ();
        DisjointSet ds = new DisjointSet ( n );
        Map<String, Integer> mailMap = new HashMap<> ();
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 1; j < accounts.get ( i ).size (); j++ ) {
                String mail = accounts.get ( i ).get ( j );
                if ( ! mailMap.containsKey ( mail ) ) {
                    mailMap.put ( mail, i );
                } else {
                    ds.unionBySize ( i, mailMap.get ( mail ) );
                }
            }
        }

        List<String>[] mergedMailLists = new List[n];
        for ( int i = 0; i < n; i++ )
            mergedMailLists[i] = new ArrayList<> ();

        for ( Map.Entry<String, Integer> entry : mailMap.entrySet () ) {
            int node = entry.getValue ();
            int u_parent = ds.find ( node );
            mergedMailLists[u_parent].add ( entry.getKey () );
        }

        List<List<String>> ans = new ArrayList<> ();
        for ( int i = 0; i < n; i++ ) {
            if ( mergedMailLists[i].size () == 0 ) continue;
            List<String> mergedMailList = mergedMailLists[i];
            Collections.sort ( mergedMailList );
            String name = accounts.get ( i ).get ( 0 );
            mergedMailList.add ( 0, name );
            //entryList.addAll(mergedMailList);
            ans.add ( mergedMailList );
        }

        return ans;
    }
}