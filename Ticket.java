//super class
public abstract class Ticket
{
   
    private int ticketType;
    private Customer cust;
    private Travel trv;
    
    
    public Ticket()
    {
        
        ticketType = 0;
        
    }
    public Ticket(String cn,String cp,int cage,int tt,String d,int snum)
    {
        ticketType = tt;
        cust = new Customer (cn,cp,cage);
        trv = new Travel(d,snum);
        
    }
    //Setter
    
    public void setTicketType (int tt)
    {
     ticketType = tt;
    }
    
    public int getTicketType()
    {
        return ticketType;
    }
    
   
    public Customer getCustomer()
    {
        return cust;
    }
    
    public Travel getTravel()
     {
         return trv;
     }
    
    public abstract double calcPrice();
    
    
    
    public String toString()
    {
      return cust.toString()+trv.toString();
    }
    
    }
