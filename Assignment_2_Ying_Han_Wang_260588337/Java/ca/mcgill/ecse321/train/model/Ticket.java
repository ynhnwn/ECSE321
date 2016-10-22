/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/

package ca.mcgill.ecse321.train.model;

// line 33 "../../../../../../../../ump/tmp269203/model.ump"
// line 97 "../../../../../../../../ump/tmp269203/model.ump"
public class Ticket
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ticket Associations
  private Person person;
  private Trip trip;
  private Cabin cabin;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ticket(Person aPerson, Trip aTrip, Cabin aCabin)
  {
    if (aPerson == null || aPerson.getTicket() != null)
    {
      throw new RuntimeException("Unable to create Ticket due to aPerson");
    }
    person = aPerson;
    if (!setTrip(aTrip))
    {
      throw new RuntimeException("Unable to create Ticket due to aTrip");
    }
    if (!setCabin(aCabin))
    {
      throw new RuntimeException("Unable to create Ticket due to aCabin");
    }
  }

  public Ticket(String aNameForPerson, Trip aTrip, Cabin aCabin)
  {
    person = new Person(aNameForPerson, this);
    trip = new Trip(null);
    cabin = new Cabin(null);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Person getPerson()
  {
    return person;
  }

  public Trip getTrip()
  {
    return trip;
  }

  public Cabin getCabin()
  {
    return cabin;
  }

  public boolean setTrip(Trip aNewTrip)
  {
    boolean wasSet = false;
    if (aNewTrip != null)
    {
      trip = aNewTrip;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setCabin(Cabin aNewCabin)
  {
    boolean wasSet = false;
    if (aNewCabin != null)
    {
      cabin = aNewCabin;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    Person existingPerson = person;
    person = null;
    if (existingPerson != null)
    {
      existingPerson.delete();
    }
    trip = null;
    cabin = null;
  }

}