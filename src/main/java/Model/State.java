package Model;

public interface State
{
   void onBorrow(Vinyl vinyl,String name);

   void onReserved(Vinyl vinyl);

   void onReturn(Vinyl vinyl);
}
