package Model;

public class Available implements State
{
  @Override public void onBorrow(Vinyl vinyl)
  {
    vinyl.setState(new Borrowed());
  }

  @Override public void onReserved(Vinyl vinyl)
  {
    vinyl.setState(new Reserved());
  }

  @Override public void onReturn(Vinyl vinyl)
  {

  }
}
