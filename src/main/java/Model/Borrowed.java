package Model;

public class Borrowed implements State
{
  @Override public void onBorrow(Vinyl vinyl)
  {
    // Empty
  }

  @Override public void onReserved(Vinyl vinyl)
  {

  }

  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.setState(new Available());
  }
}
