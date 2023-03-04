package Model;

public class BorrowedAndReserved implements State
{

  @Override public void onBorrow(Vinyl vinyl,String name)
  {
    //empty
  }

  @Override public void onReserved(Vinyl vinyl, String name)
  {
    //empty
  }

  @Override public void onReturn(Vinyl vinyl)
  {
    if (!vinyl.getBorrowedBy().equals("")){
      vinyl.returnVinyl();
      vinyl.reserve(vinyl.getReservedBy());
    }
  }

  public String toString(){
    return "Borrowed and Reserved";
  }
}
