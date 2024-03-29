package com.kingshuk.tests.misc;

public class SecureChannel {

    static final String negResponse = "-1";

    // Complete the secureChannel function below.
    static String secureChannel ( int operation, String message, String key ) {

        switch (operation) {
            case 1:
                return encoded ( message, key );
            case 2:
                return decoded ( message, key );
            default:
                return negResponse;
        }

    }


    private static String isEmpty ( String message, String key ) {
        if ( message == null || key == null )
            return negResponse;

        if ( message.isEmpty () && key.isEmpty () )
            return message;

        if ( ! message.isEmpty () && key.isEmpty () )
            return message;

        if ( message.isEmpty () && ! key.isEmpty () )
            return negResponse;


        return null;

    }

    /**
     * Input:
     * 2
     * Oppeeen
     * 123
     * <p>
     * Output:
     * Open
     *
     * @param message
     * @param key
     * @return
     */
    private static String decoded ( String message, String key ) {
        String corner = isEmpty ( message, key );
        if ( corner != null )
            return corner;


        if ( key.equals ( "0" ) )
            return message;

        int index = 0;
        final StringBuilder res = new StringBuilder ();

        char[] keys = key.toCharArray ();

        int i;
        for ( i = 0; i < keys.length; i++ ) {

            if ( index < message.length () ) {
                char current = message.charAt ( index );
                if ( Character.isDigit ( keys[i] ) ) {
                    int keyV = keys[i] - '0';
                    int x = 1;
                    while (x + index < message.length () && message.charAt ( x + index ) == current) {

                        x++;
                    }

                    if ( x == keyV ) { //this is correct
                        res.append ( current );
                    } else
                        return negResponse;
                    index = index + x;
                } else
                    return negResponse;

            } else
                break;
        }

        return getMessage ( message, index, res );


    }

    private static String getMessage ( String message, int index, StringBuilder res ) {
        if ( index < message.length () ) {
            String remaining = message.substring ( index );
            res.append ( remaining );
        }
        return res.toString ();

    }

    /**
     * Message: Open
     * Key: 123
     * <p>
     * Output:
     * Oppeeen
     *
     * @param message
     * @param key
     * @return
     */
    private static String encoded ( String message, String key ) {
        String corner = isEmpty ( message, key );
        if ( corner != null )
            return corner;

        int index = 0;
        final StringBuilder res = new StringBuilder ();

        char[] keys = key.toCharArray ();

        int i;
        for ( i = 0; i < keys.length; i++ ) {

            if ( index < message.length () ) {
                char current = message.charAt ( index );

                if ( Character.isDigit ( keys[i] ) ) {
                    int keyV = keys[i] - '0';

                    for ( int x = 0; x < keyV; x++ ) {
                        res.append ( current );
                    }

                    index++;
                } else
                    return negResponse;
            } else
                break;

        }

        return getMessage ( message, index, res );

    }

    public static void main ( String[] args ) {


        System.out.println ( secureChannel ( 2, "open", "aad" ) );

        System.out.println ( secureChannel ( 2, "", "" ) );


        System.out.println ( "this " + secureChannel ( 1, "oop", "223" ) );


        System.out.println ( secureChannel ( 2, "Oppeeennnn", "1234" ) );


        System.out.println ( secureChannel ( 1, "abcdefgh", "" ) );
        System.out.println ( secureChannel ( 2, "aaabbbcccdddeeefffggghhh", "" ) );


        System.out.println ( secureChannel ( 1, "abcdefgh", "0" ) );
        System.out.println ( secureChannel ( 2, "bcdefgh", "0" ) );


        System.out.println ( secureChannel ( 1, "abcdefgh", "" ) );
        System.out.println ( secureChannel ( 2, "aaabbbcccdddeeefffggghhh", "" ) );


        System.out.println ( secureChannel ( 1, "abcdefgh", "33333333333" ) );
        System.out.println ( secureChannel ( 2, "aaabbbcccdddeeefffggghhh", "33333333333" ) );


        System.out.println ( secureChannel ( 1, null, "9999" ) );
        System.out.println ( secureChannel ( 2, null, "9999" ) );

        System.out.println ( secureChannel ( 1, "", "9999" ) );
        System.out.println ( secureChannel ( 2, "", "9999" ) );

        System.out.println ( secureChannel ( 1, "Ope", "12345" ) );
        System.out.println ( secureChannel ( 2, "Oppeee", "12345" ) );


        System.out.println ( secureChannel ( 1, "open", "123" ) );
        System.out.println ( secureChannel ( 2, "Oppeeen", "123" ) );


        System.out.println ( secureChannel ( 1, "open", "1234" ) );
        System.out.println ( secureChannel ( 2, "oppeeennnn", "123" ) );


        System.out.println ( secureChannel ( 1, "o", "1234" ) );
        System.out.println ( secureChannel ( 2, "opp", "123" ) );
    }
}