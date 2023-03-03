package Model;

public interface State
{
   void onBorrow(Vinyl vinyl);

   void onReserved(Vinyl vinyl);

   void onReturn(Vinyl vinyl);
}
