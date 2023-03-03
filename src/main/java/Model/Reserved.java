package Model;

import java.util.WeakHashMap;

public class Reserved implements State
{
  @Override public void onBorrow(Vinyl vinyl)
  {
    //vinyl.setState(new VinylBorrow());
  }

  @Override public void onReserved(Vinyl vinyl)
  {

  }


  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.setState(new Available());
  }
}
