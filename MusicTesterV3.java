/**
 * This class demonstrates the binary search with an array of objects.
 *
 * @author Briana Berger
 * @version 04/14/18
 */

public class MusicTesterV3 {
    public static void main(String[] args)
    {
        Music[] playlist = new Music[10];
        
        playlist[0] = new Music("City of Stars", 2016, "La La Land Soundtrack");
        playlist[1] = new Music("Dangelion Hair", 2016, "Joe Brooks");
        playlist[2] = new Music("Hopeful", 2018, "Adam Barnes");
        playlist[3] = new Music("Atlas: Heart", 2016, "Sleeping At Last");
        playlist[4] = new Music("Let It Go", 2015, "James Bay");
        playlist[5] = new Music("White Summer Dress", 2017, "Taylor John Williams");
        playlist[6] = new Music("I Like You", 2017, "Olive James");
        playlist[7] = new Music("We Dance", 2014, "Cody Fry");
        playlist[8] = new Music("Wild Love", 2018, "James Bay");
        playlist[9] = new Music("Catch Me", 2009, "Demi Lovato");
 
        int test;
        
        printPlaylist(playlist);
        
        System.out.println("\n\nSearching for the song, White Summer Dress: ");
        insertionTitle(playlist);  
        
        test = findTitleBinary(playlist, "White Summer Dress");
        if(test != -1)
            System.out.println("Found: " + playlist[test]);
        else
            System.out.println("Not found. " );
        
        System.out.println("\n\nSearching the song, Despacito: ");
        test = findTitleBinary(playlist, "Despacito");
        if(test != -1)
            System.out.println("Found: " + playlist[test]);
        else
            System.out.println("Not found. " );
            
        System.out.println("\n\nSearching for 2016 Songs: ");
        insertionYear(playlist);
        findYearBinary(playlist, 2016);
       
        System.out.println("\n\nSearching for 1999 Songs: ");
        insertionYear(playlist);
        findYearBinary(playlist, 1999);
        
        System.out.println("\n\nSearching for James Bay Songs: ");
        insertionArtist(playlist);
        findArtistBinary(playlist, "James Bay");
       
        System.out.println("\n\nSearching for Selena Gomez Songs: ");
        insertionArtist(playlist);
        findArtistBinary(playlist, "Selena Gomez");
    }
   
    public static void printPlaylist(Music[] r)
    {
        System.out.println("Title                      Year        Artist");
        System.out.println("-------------------------------------------------------");
        for(int i = 0; i < r.length; i++)
            System.out.println(r[i]);
    }
   
    public static int findTitleBinary(Music[] r, String toFind)
    {
        int high = r.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;
            if( r[probe].getTitle().compareTo(toFind) > 0)
                high = probe;
            else
                low = probe;
        }
        
        if( (low >= 0) && (r[low].getTitle().compareTo(toFind) == 0 ))
            return low;
        else
            return -1;
    }
   
    public static void findYearBinary(Music[] r, int toFind)
    {
        int high = r.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;

            if(r[probe].getYear() > toFind)
                high = probe;
            else
            {
                low = probe;
                if( r[probe].getYear() == toFind)
                {
                    break;
                }
            }
        }
        
        if( (low >= 0) && (r[low].getYear() == toFind))
        {
            linearPrintYear(r, low, toFind);
        }
        else
            System.out.println("NOT found: " + toFind);
    }
    
    public static void findArtistBinary(Music[] r, String toFind)
    {
        int high = r.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;

            if(r[probe].getArtist().compareTo(toFind) > 0)
                high = probe;
            else
            {
                low = probe;
                if( r[probe].getArtist().compareTo(toFind) == 0)
                {
                    break;
                }
            }
        }
        
        if( (low >= 0) && (r[low].getArtist().compareTo(toFind) == 0 ))
        {
            linearPrintArtist(r, low, toFind);
        }
        else
            System.out.println("NOT found: " + toFind);
    }
    
    public static void linearPrintYear(Music[] r, int low, int toFind)
    {
        int i;
        int start = low;
        int end = low;

        // find starting point of matches
        i = low - 1;
        while((i >= 0) && (r[i].getYear() == toFind))
        {
            start = i;
            i--;
        }
        // find ending point of matches
        i = low + 1;
        while((i < r.length) && (r[i].getYear() == toFind))
        {
            end = i;
            i++;
        }
        // now print out the matches
        for(i = start; i <= end; i++)
            System.out.println(r[i]);
    }
   
    public static void linearPrintArtist(Music[] r, int low, String toFind)
    {
        int i;
        int start = low;
        int end = low;

        // find starting point of matches
        i = low - 1;
        while((i >= 0) && (r[i].getArtist().compareTo(toFind) == 0))
        {
            start = i;
            i--;
        }
        // find ending point of matches
        i = low + 1;
        while((i < r.length) && (r[i].getArtist().compareTo(toFind) == 0))
        {
            end = i;
            i++;
        }
        // now print out the matches
        for(i = start; i <= end; i++)
            System.out.println(r[i]);
    }
    
    // Insertion sort: sort array in ascending order based on title
    public static void insertionTitle(Music[] source)
    {
        Music[] dest = new Music[ source.length ];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Music next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if( next.getTitle().compareTo(dest[k-1].getTitle()) > 0 )
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
        }
        
        for(int i = 0; i < dest.length; i++)
            source[i] = dest[i];
    }
    
    // Insertion sort: sort array in ascending order based on year
    public static void insertionYear(Music[] source)
    {
        Music[] dest = new Music[ source.length ];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Music next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if( next.getYear() > dest[k-1].getYear())
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
        }
        
        for(int i = 0; i < dest.length; i++)
            source[i] = dest[i];
    }
    
    // Insertion sort: sort array in ascending order based on artist
    public static void insertionArtist(Music[] source)
    {
        Music[] dest = new Music[ source.length ];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Music next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if( next.getArtist().compareTo(dest[k-1].getArtist()) > 0 )
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
        }
        
        for(int i = 0; i < dest.length; i++)
            source[i] = dest[i];
    }
}
