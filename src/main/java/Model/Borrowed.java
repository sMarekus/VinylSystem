package Model;

import java.util.Objects;

public class Borrowed implements State
{
  @Override public void onBorrow(Vinyl vinyl,String name)
  {
    // Empty
  }

  @Override public void onReserved(Vinyl vinyl, String name)
  {
    if(!Objects.equals(name, "")) {
      vinyl.setState(new BorrowedAndReserved());
      vinyl.setReservedBy(name);
    }
  }

  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.setState(new Available());
  }

  public String toString(){
    return "Borrowed";
  }
}
