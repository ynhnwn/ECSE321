/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/

package ca.mcgill.ecse321.train.model;
import java.util.*;

// line 10 "../../../../../../../../ump/tmp269203/model.ump"
// line 80 "../../../../../../../../ump/tmp269203/model.ump"
public class Destination
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Destination Attributes
  private String name;

  //Destination Associations
  private List<Trip> availableTrips;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Destination(String aName)
  {
    name = aName;
    availableTrips = new ArrayList<Trip>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Trip getAvailableTrip(int index)
  {
    Trip aAvailableTrip = availableTrips.get(index);
    return aAvailableTrip;
  }

  public List<Trip> getAvailableTrips()
  {
    List<Trip> newAvailableTrips = Collections.unmodifiableList(availableTrips);
    return newAvailableTrips;
  }

  public int numberOfAvailableTrips()
  {
    int number = availableTrips.size();
    return number;
  }

  public boolean hasAvailableTrips()
  {
    boolean has = availableTrips.size() > 0;
    return has;
  }

  public int indexOfAvailableTrip(Trip aAvailableTrip)
  {
    int index = availableTrips.indexOf(aAvailableTrip);
    return index;
  }

  public static int minimumNumberOfAvailableTrips()
  {
    return 0;
  }

  public Trip addAvailableTrip(String aDepartureTime, String aArrivalTime, String aTripDuration)
  {
    return new Trip(aDepartureTime, aArrivalTime, aTripDuration, this);
  }

  public boolean addAvailableTrip(Trip aAvailableTrip)
  {
    boolean wasAdded = false;
    if (availableTrips.contains(aAvailableTrip)) { return false; }
    Destination existingDestination = aAvailableTrip.getDestination();
    boolean isNewDestination = existingDestination != null && !this.equals(existingDestination);
    if (isNewDestination)
    {
      aAvailableTrip.setDestination(this);
    }
    else
    {
      availableTrips.add(aAvailableTrip);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAvailableTrip(Trip aAvailableTrip)
  {
    boolean wasRemoved = false;
    //Unable to remove aAvailableTrip, as it must always have a destination
    if (!this.equals(aAvailableTrip.getDestination()))
    {
      availableTrips.remove(aAvailableTrip);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAvailableTripAt(Trip aAvailableTrip, int index)
  {  
    boolean wasAdded = false;
    if(addAvailableTrip(aAvailableTrip))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailableTrips()) { index = numberOfAvailableTrips() - 1; }
      availableTrips.remove(aAvailableTrip);
      availableTrips.add(index, aAvailableTrip);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAvailableTripAt(Trip aAvailableTrip, int index)
  {
    boolean wasAdded = false;
    if(availableTrips.contains(aAvailableTrip))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailableTrips()) { index = numberOfAvailableTrips() - 1; }
      availableTrips.remove(aAvailableTrip);
      availableTrips.add(index, aAvailableTrip);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAvailableTripAt(aAvailableTrip, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=availableTrips.size(); i > 0; i--)
    {
      Trip aAvailableTrip = availableTrips.get(i - 1);
      aAvailableTrip.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}