/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/

package ca.mcgill.ecse321.train.model;
import java.util.*;

// line 24 "../../../../../../../../ump/tmp269203/model.ump"
// line 92 "../../../../../../../../ump/tmp269203/model.ump"
public class Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private String creditCardToBill;
  private String authorizationCode;
  private boolean successful;

  //Transaction Associations
  private List<Ticket> tickets;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(String aCreditCardToBill, String aAuthorizationCode, boolean aSuccessful)
  {
    creditCardToBill = aCreditCardToBill;
    authorizationCode = aAuthorizationCode;
    successful = aSuccessful;
    tickets = new ArrayList<Ticket>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCreditCardToBill(String aCreditCardToBill)
  {
    boolean wasSet = false;
    creditCardToBill = aCreditCardToBill;
    wasSet = true;
    return wasSet;
  }

  public boolean setAuthorizationCode(String aAuthorizationCode)
  {
    boolean wasSet = false;
    authorizationCode = aAuthorizationCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setSuccessful(boolean aSuccessful)
  {
    boolean wasSet = false;
    successful = aSuccessful;
    wasSet = true;
    return wasSet;
  }

  public String getCreditCardToBill()
  {
    return creditCardToBill;
  }

  public String getAuthorizationCode()
  {
    return authorizationCode;
  }

  public boolean getSuccessful()
  {
    return successful;
  }

  public Ticket getTicket(int index)
  {
    Ticket aTicket = tickets.get(index);
    return aTicket;
  }

  public List<Ticket> getTickets()
  {
    List<Ticket> newTickets = Collections.unmodifiableList(tickets);
    return newTickets;
  }

  public int numberOfTickets()
  {
    int number = tickets.size();
    return number;
  }

  public boolean hasTickets()
  {
    boolean has = tickets.size() > 0;
    return has;
  }

  public int indexOfTicket(Ticket aTicket)
  {
    int index = tickets.indexOf(aTicket);
    return index;
  }

  public static int minimumNumberOfTickets()
  {
    return 0;
  }

  public boolean addTicket(Ticket aTicket)
  {
    boolean wasAdded = false;
    if (tickets.contains(aTicket)) { return false; }
    tickets.add(aTicket);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTicket(Ticket aTicket)
  {
    boolean wasRemoved = false;
    if (tickets.contains(aTicket))
    {
      tickets.remove(aTicket);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTicketAt(Ticket aTicket, int index)
  {  
    boolean wasAdded = false;
    if(addTicket(aTicket))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTickets()) { index = numberOfTickets() - 1; }
      tickets.remove(aTicket);
      tickets.add(index, aTicket);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTicketAt(Ticket aTicket, int index)
  {
    boolean wasAdded = false;
    if(tickets.contains(aTicket))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTickets()) { index = numberOfTickets() - 1; }
      tickets.remove(aTicket);
      tickets.add(index, aTicket);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTicketAt(aTicket, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    tickets.clear();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "creditCardToBill" + ":" + getCreditCardToBill()+ "," +
            "authorizationCode" + ":" + getAuthorizationCode()+ "," +
            "successful" + ":" + getSuccessful()+ "]"
     + outputString;
  }
}