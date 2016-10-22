/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/

package ca.mcgill.ecse321.train.model;
import java.util.*;

// line 15 "../../../../../../../../ump/tmp269203/model.ump"
// line 86 "../../../../../../../../ump/tmp269203/model.ump"
public class Trip
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trip Attributes
  private String departureTime;
  private String arrivalTime;
  private String tripDuration;

  //Trip Associations
  private List<Cabin> availableCabins;
  private Destination destination;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trip(String aDepartureTime, String aArrivalTime, String aTripDuration, Destination aDestination)
  {
    departureTime = aDepartureTime;
    arrivalTime = aArrivalTime;
    tripDuration = aTripDuration;
    availableCabins = new ArrayList<Cabin>();
    boolean didAddDestination = setDestination(aDestination);
    if (!didAddDestination)
    {
      throw new RuntimeException("Unable to create availableTrip due to destination");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDepartureTime(String aDepartureTime)
  {
    boolean wasSet = false;
    departureTime = aDepartureTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrivalTime(String aArrivalTime)
  {
    boolean wasSet = false;
    arrivalTime = aArrivalTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setTripDuration(String aTripDuration)
  {
    boolean wasSet = false;
    tripDuration = aTripDuration;
    wasSet = true;
    return wasSet;
  }

  public String getDepartureTime()
  {
    return departureTime;
  }

  public String getArrivalTime()
  {
    return arrivalTime;
  }

  public String getTripDuration()
  {
    return tripDuration;
  }

  public Cabin getAvailableCabin(int index)
  {
    Cabin aAvailableCabin = availableCabins.get(index);
    return aAvailableCabin;
  }

  public List<Cabin> getAvailableCabins()
  {
    List<Cabin> newAvailableCabins = Collections.unmodifiableList(availableCabins);
    return newAvailableCabins;
  }

  public int numberOfAvailableCabins()
  {
    int number = availableCabins.size();
    return number;
  }

  public boolean hasAvailableCabins()
  {
    boolean has = availableCabins.size() > 0;
    return has;
  }

  public int indexOfAvailableCabin(Cabin aAvailableCabin)
  {
    int index = availableCabins.indexOf(aAvailableCabin);
    return index;
  }

  public Destination getDestination()
  {
    return destination;
  }

  public static int minimumNumberOfAvailableCabins()
  {
    return 0;
  }

  public Cabin addAvailableCabin(String aCabinNumber, double aPrice)
  {
    return new Cabin(aCabinNumber, aPrice, this);
  }

  public boolean addAvailableCabin(Cabin aAvailableCabin)
  {
    boolean wasAdded = false;
    if (availableCabins.contains(aAvailableCabin)) { return false; }
    Trip existingTrip = aAvailableCabin.getTrip();
    boolean isNewTrip = existingTrip != null && !this.equals(existingTrip);
    if (isNewTrip)
    {
      aAvailableCabin.setTrip(this);
    }
    else
    {
      availableCabins.add(aAvailableCabin);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAvailableCabin(Cabin aAvailableCabin)
  {
    boolean wasRemoved = false;
    //Unable to remove aAvailableCabin, as it must always have a trip
    if (!this.equals(aAvailableCabin.getTrip()))
    {
      availableCabins.remove(aAvailableCabin);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAvailableCabinAt(Cabin aAvailableCabin, int index)
  {  
    boolean wasAdded = false;
    if(addAvailableCabin(aAvailableCabin))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailableCabins()) { index = numberOfAvailableCabins() - 1; }
      availableCabins.remove(aAvailableCabin);
      availableCabins.add(index, aAvailableCabin);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAvailableCabinAt(Cabin aAvailableCabin, int index)
  {
    boolean wasAdded = false;
    if(availableCabins.contains(aAvailableCabin))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailableCabins()) { index = numberOfAvailableCabins() - 1; }
      availableCabins.remove(aAvailableCabin);
      availableCabins.add(index, aAvailableCabin);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAvailableCabinAt(aAvailableCabin, index);
    }
    return wasAdded;
  }

  public boolean setDestination(Destination aDestination)
  {
    boolean wasSet = false;
    if (aDestination == null)
    {
      return wasSet;
    }

    Destination existingDestination = destination;
    destination = aDestination;
    if (existingDestination != null && !existingDestination.equals(aDestination))
    {
      existingDestination.removeAvailableTrip(this);
    }
    destination.addAvailableTrip(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=availableCabins.size(); i > 0; i--)
    {
      Cabin aAvailableCabin = availableCabins.get(i - 1);
      aAvailableCabin.delete();
    }
    Destination placeholderDestination = destination;
    this.destination = null;
    placeholderDestination.removeAvailableTrip(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "departureTime" + ":" + getDepartureTime()+ "," +
            "arrivalTime" + ":" + getArrivalTime()+ "," +
            "tripDuration" + ":" + getTripDuration()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "destination = "+(getDestination()!=null?Integer.toHexString(System.identityHashCode(getDestination())):"null")
     + outputString;
  }
}