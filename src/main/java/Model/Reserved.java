package Model;

import View.VinylList;

import java.util.Objects;

public class Reserved implements State
{
  @Override public void onBorrow(Vinyl vinyl,String name)
  {
    if (vinyl.getBorrowedBy().equals(vinyl.getReservedBy())) {
      vinyl.setState(new Borrowed());
    }
  }

  @Override public void onReserved(Vinyl vinyl, String name)
  {
    // Empty
  }


  @Override public void onReturn(Vinyl vinyl, String name)
  {
    if(name.equals(vinyl.getReservedBy()) || name.equals(vinyl.getBorrowedBy())){
    vinyl.setState(new Available());
    if(vinyl.isToBeRemoved()) {
      VinylList.getInstance().getVinyls().removeIf(obj -> Objects.equals(obj.getTitle(), vinyl.getTitle()));
    }
    }
  }

  public String toString(){
    return "Reserved";
  }
}
