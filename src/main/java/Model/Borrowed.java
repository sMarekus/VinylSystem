package Model;

public class Borrowed implements State
{
  @Override public void onBorrow(Vinyl vinyl,String name)
  {
    // Empty
  }

  @Override public void onReserved(Vinyl vinyl)
  {
      vinyl.setState(new BorrowedAndReserved());

  }

  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.setState(new Available());
  }
}
