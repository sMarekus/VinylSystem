package Model;

public interface State
{
   void onBorrow(Vinyl vinyl);

   void onReserved(Vinyl vinyl,String name);

   void onReturn(Vinyl vinyl);
}
