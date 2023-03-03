package Model;

public class Return implements State
{
  @Override public void onReturn(Vinyl vinyl){
    vinyl.setState(new Available());
  }

  @Override public void onBorrow(Vinyl vinyl,String name){

  }

  @Override public void onReserved(Vinyl vinyl){

  }

  public String toString(){
    return "Available";
  }
}
