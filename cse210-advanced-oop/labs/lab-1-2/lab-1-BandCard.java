/*
 * /home/grant/JavaClasses/Comp213/BandTrumps/BandCard.java
 *
 * Created: Thu Nov 15 23:43:24 2007
 *
 * copyright Grant Malcolm
 *
 *   This source code may be freely used, modified, or distributed
 *   provided due credit is given.
 *
 */

// package Comp213.BandTrumps;

/**
 * Stores data for a band, as used in a trump card game.
 *
 *   Instances of this class store:
 *   <ul>
 *    <li>the name of a band, as a string;</li>
 *    <li>an integer value for volume of the band;</li>
 *    <li>an integer value for attitude of the band;</li>
 *    <li>an integer value for cool of the band;</li>
 *    <li>an integer value for eclecticism of the band; and</li>
 *    <li>an integer value for hair of the band.</li>
 *   </ul>
 *   Each of these has an accessor method.
 *
 * @author <a href="mailto:grant@liverpool.ac.uk">Grant Malcolm</a>
 * @version 1.0
 */
public class BandCard 
{
   // ----- constants ------------------------------------------------------

   /**
    * The name of the band.
    *
    */
   private final String name;

   /**
    * The volume value for the band.
    *
    */
   private final int volume;

   /**
    * The attitude value for the band.
    *
    */
   private final int attitude;

   /**
    * The cool value for the band.
    *
    */
   private final int cool;

   /**
    * The eclecticism value for the band.
    *
    */
   private final int eclecticism;

   /**
    * The hair value for the band.
    *
    */
   private final int hair;


   // ----- constructor ----------------------------------------------------

   /**
    * Creates a new <code>BandCard</code> instance with the given data.
    *
    * @param name the name of the band
    * @param volume the volume value
    * @param attitude the attitude value
    * @param cool the cool value
    * @param eclecticism the eclecticism value
    * @param hair the hair value
    */
   public BandCard(String name,
                   int volume,
                   int attitude,
                   int cool,
                   int eclecticism,
                   int hair)
   {
      this.name = name;
      this.volume = volume;
      this.attitude = attitude;
      this.cool = cool;
      this.eclecticism = eclecticism;
      this.hair = hair;
   }


   // ----- methods --------------------------------------------------------

   /**
    * Returns the name of the band.
    *
    * @return the name of the band
    */
   public String getName()
   {
      return name;
   }

   /**
    * Returns the volume value for the band.
    *
    * @return the volume value
    */
   public int getVolume()
   {
      return volume;
   }

   /**
    * Returns the attitude value of the band.
    *
    * @return the attitude value
    */
   public int getAttitude()
   {
      return attitude;
   }

   /**
    * Returns the cool value of the band.
    *
    * @return the cool value
    */
   public int getCool()
   {
      return cool;
   }

   /**
    * Returns the eclecticism value of the band.
    *
    * @return the eclecticism value
    */
   public int getEclecticism()
   {
      return eclecticism;
   }

   /**
    * Returns the hair value of the band.
    *
    * @return the hair value
    */
   public int getHair()
   {
      return hair;
   }

   /**
    * For testing: see
    * <a href="BandCardTest.maude">"BandCardTest.maude</a>
    * for expected results.
    *
    * @param args not used
    */
   public static void main(String[] args)
   {
      BandCard bc = new BandCard("Goldfrapp", 5, 3, 7, 17, 12);

      // should be: "Goldfrapp"
      System.out.println(bc.getName());

      // should be: 5
      System.out.println(bc.getVolume());

      // should be: 3
      System.out.println(bc.getAttitude());

      // should be: 7
      System.out.println(bc.getCool());

      // should be: 17
      System.out.println(bc.getEclecticism());

      // should be: 12
      System.out.println(bc.getHair());
   }
}
