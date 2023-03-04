package Model;

import java.util.Objects;

public class Available implements State
{
  @Override public void onBorrow(Vinyl vinyl,String name)
  {
    if(!Objects.equals(name, "")) {
      vinyl.setState(new Borrowed());
      vinyl.setBorrowedBy(name);
    }
  }

  @Override public void onReserved(Vinyl vinyl, String name)
  {
    if(!Objects.equals(name, "")) {
      vinyl.setState(new Reserved());
      System.out.println(name);
      vinyl.setReservedBy(name);
    }
  }

  @Override public void onReturn(Vinyl vinyl)
  {

  }

  public String toString(){
    return "Available";
  }
}
