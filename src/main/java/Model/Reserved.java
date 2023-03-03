package Model;

import java.util.WeakHashMap;

public class Reserved implements State
{
  @Override public void onBorrow(Vinyl vinyl,String name)
  {
    if (vinyl.getBorrowedBy().equals(vinyl.getReservedBy())) {
      vinyl.setState(new Borrowed());
    }
  }

  @Override public void onReserved(Vinyl vinyl)
  {
    // Empty
  }


  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.setState(new Return());
  }
}
