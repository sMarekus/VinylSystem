package Model;

import java.util.WeakHashMap;

public class Reserved implements State
{
  @Override public void onBorrow(Vinyl vinyl)
  {
    if (vinyl.getState()==Vinyl.State.RESERVED.getState()){
      System.out.println("Vinyl is already reserved");
    }
  }

  @Override public void onReserved(Vinyl vinyl, String name)
  {
    vinyl.setState(Vinyl.State.RESERVED);
  }


  @Override public void onReturn(Vinyl vinyl)
  {
   if (vinyl.getState()==Vinyl.State.BORROWED.getState()){
     vinyl.setState(Vinyl.State.AVAILABLE);
   }
  }
}
