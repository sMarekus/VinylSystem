package Model;

public class Available implements State
{
  @Override public void onBorrow(Vinyl vinyl)
  {
    vinyl.setState(new VinylBorrow());
  }

  @Override public void onReserved(Vinyl vinyl)
  {
    vinyl.setState(new VinylReserve());
  }

  @Override public void onReturn(Vinyl vinyl)
  {

  }
}
