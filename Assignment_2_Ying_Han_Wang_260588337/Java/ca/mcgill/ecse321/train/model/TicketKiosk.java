/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/

package ca.mcgill.ecse321.train.model;
import java.util.*;

// line 4 "../../../../../../../../ump/tmp269203/model.ump"
// line 75 "../../../../../../../../ump/tmp269203/model.ump"
public class TicketKiosk
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TicketKiosk Associations
  private List<Destination> destinations;
  private List<Transaction> transactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TicketKiosk()
  {
    destinations = new ArrayList<Destination>();
    transactions = new ArrayList<Transaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Destination getDestination(int index)
  {
    Destination aDestination = destinations.get(index);
    return aDestination;
  }

  public List<Destination> getDestinations()
  {
    List<Destination> newDestinations = Collections.unmodifiableList(destinations);
    return newDestinations;
  }

  public int numberOfDestinations()
  {
    int number = destinations.size();
    return number;
  }

  public boolean hasDestinations()
  {
    boolean has = destinations.size() > 0;
    return has;
  }

  public int indexOfDestination(Destination aDestination)
  {
    int index = destinations.indexOf(aDestination);
    return index;
  }

  public Transaction getTransaction(int index)
  {
    Transaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  public List<Transaction> getTransactions()
  {
    List<Transaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(Transaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
    return index;
  }

  public static int minimumNumberOfDestinations()
  {
    return 0;
  }

  public boolean addDestination(Destination aDestination)
  {
    boolean wasAdded = false;
    if (destinations.contains(aDestination)) { return false; }
    destinations.add(aDestination);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDestination(Destination aDestination)
  {
    boolean wasRemoved = false;
    if (destinations.contains(aDestination))
    {
      destinations.remove(aDestination);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDestinationAt(Destination aDestination, int index)
  {  
    boolean wasAdded = false;
    if(addDestination(aDestination))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDestinations()) { index = numberOfDestinations() - 1; }
      destinations.remove(aDestination);
      destinations.add(index, aDestination);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDestinationAt(Destination aDestination, int index)
  {
    boolean wasAdded = false;
    if(destinations.contains(aDestination))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDestinations()) { index = numberOfDestinations() - 1; }
      destinations.remove(aDestination);
      destinations.add(index, aDestination);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDestinationAt(aDestination, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTransactions()
  {
    return 0;
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    transactions.add(aTransaction);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    if (transactions.contains(aTransaction))
    {
      transactions.remove(aTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTransactionAt(Transaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(Transaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    destinations.clear();
    transactions.clear();
  }

}