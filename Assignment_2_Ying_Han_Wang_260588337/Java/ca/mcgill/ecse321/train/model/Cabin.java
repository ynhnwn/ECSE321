/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/

package ca.mcgill.ecse321.train.model;

// line 57 "../../../../../../../../ump/tmp269203/model.ump"
// line 123 "../../../../../../../../ump/tmp269203/model.ump"
public class Cabin
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cabin Attributes
  private String cabinNumber;
  private double price;

  //Cabin Associations
  private Trip trip;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cabin(String aCabinNumber, double aPrice, Trip aTrip)
  {
    cabinNumber = aCabinNumber;
    price = aPrice;
    boolean didAddTrip = setTrip(aTrip);
    if (!didAddTrip)
    {
      throw new RuntimeException("Unable to create availableCabin due to trip");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCabinNumber(String aCabinNumber)
  {
    boolean wasSet = false;
    cabinNumber = aCabinNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public String getCabinNumber()
  {
    return cabinNumber;
  }

  public double getPrice()
  {
    return price;
  }

  public Trip getTrip()
  {
    return trip;
  }

  public boolean setTrip(Trip aTrip)
  {
    boolean wasSet = false;
    if (aTrip == null)
    {
      return wasSet;
    }

    Trip existingTrip = trip;
    trip = aTrip;
    if (existingTrip != null && !existingTrip.equals(aTrip))
    {
      existingTrip.removeAvailableCabin(this);
    }
    trip.addAvailableCabin(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Trip placeholderTrip = trip;
    this.trip = null;
    placeholderTrip.removeAvailableCabin(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "cabinNumber" + ":" + getCabinNumber()+ "," +
            "price" + ":" + getPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "trip = "+(getTrip()!=null?Integer.toHexString(System.identityHashCode(getTrip())):"null")
     + outputString;
  }
}