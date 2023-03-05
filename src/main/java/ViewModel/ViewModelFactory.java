package ViewModel;
import Model.ModelInterface;

public class ViewModelFactory
{
  private VinylViewModel vinylViewModel;
  private VinylListViewModel vinylListViewModel;

  public ViewModelFactory(ModelInterface model){
    vinylViewModel = new VinylViewModel(model);
    vinylListViewModel = new VinylListViewModel(model);
  }

  public VinylViewModel getVinylViewModel(){
    return vinylViewModel;
  }

  public VinylListViewModel getVinylListViewModel(){
    return vinylListViewModel;
  }
}
