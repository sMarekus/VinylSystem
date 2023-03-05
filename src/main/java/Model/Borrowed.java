package Model;

import View.VinylList;

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
    return "Borrowed";
  }
}
