package Model;

public class Borrowed implements State
{
  @Override public void onBorrow(Vinyl vinyl)
  {

  }

  @Override public void onReserved(Vinyl vinyl)
  {
    vinyl.setState(new VinylReserve());
  }

  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.setState(new VinylAvailable());
  }
}
