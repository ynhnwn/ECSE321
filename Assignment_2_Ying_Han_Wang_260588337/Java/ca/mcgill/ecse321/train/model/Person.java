/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/

package ca.mcgill.ecse321.train.model;

// line 40 "../../../../../../../../ump/tmp269203/model.ump"
// line 103 "../../../../../../../../ump/tmp269203/model.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;

  //Person Associations
  private Ticket ticket;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, Ticket aTicket)
  {
    name = aName;
    if (aTicket == null || aTicket.getPerson() != null)
    {
      throw new RuntimeException("Unable to create Person due to aTicket");
    }
    ticket = aTicket;
  }

  public Person(String aName, Trip aTripForTicket, Cabin aCabinForTicket)
  {
    name = aName;
    ticket = new Ticket(this, aTripForTicket, aCabinForTicket);
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

  public Ticket getTicket()
  {
    return ticket;
  }

  public void delete()
  {
    Ticket existingTicket = ticket;
    ticket = null;
    if (existingTicket != null)
    {
      existingTicket.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ticket = "+(getTicket()!=null?Integer.toHexString(System.identityHashCode(getTicket())):"null")
     + outputString;
  }
}