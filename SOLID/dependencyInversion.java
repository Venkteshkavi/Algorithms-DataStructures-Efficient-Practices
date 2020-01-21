/*
  * 1. High Level Modules should not depend on low-level modules. Both should depend on abstractions/
  * 2. Abstractions should not depend on details. Details should depend on abstractions.
*/

/*
  * The presenter depends on two classes which conceptually does the same thing
  * The presenter is also reponsible for creating those classes. Thats quite outside
  * what a presenter is supposed to do.
*/

/*
  * Here presenter knows way too much it creates db and network object and tries to save a note
  * Presenters role is to just act like a communicator between the view and data store service.
  * The problem here is say if we have a change in the datastore service, then the presenter module
  * alse needs to be changed, (Tight Coupling). This makes it a poor desing.
*/

public class NotePresenter{

  //We need to save Data, to both  a local and Remote Repo
  private NoteDatabase noteDatabase;
  private NoteNetworkService NoteNetworkService;

  //We have added an extra Responsibility to the presenter;
  // which is the creation of its own dependencies.
  public NotePresenter(){
    this.noteDatabase = new NoteDatabase();
    this.NoteNetworkService = new NoteNetworkService();
  }

  public void letsPretendViewCallsThis(String userInput){
    noteDatabase.saveNote{
      new Note(userInput);
    };

    NoteNetworkService.saveNote{
      new Note(userInput);
    };
  }
}

public class NoteDatabase{
  public void saveNote(Note note){
      //........//
  }
}

public class NoteNetworkService{
  public void saveNote(Note note){
    //.......//
  }
}

/*
  * Better Design
*/

public class NotePresenter{
  private NoteDatasource noteDatasource;

  //If we really want to decouple things, use Depedency Injection
  // In a word, that a simple means that we make something other than NotePresenter
  // responsible for creating the NoteRepository.

  @Inject
  public NotePresenter(NoteRepository noteRepository){
    return this.noteRepository = noteRepository;
  }

  public void letsPretendViewCallsThis(String userinput){
    noteRepository.saveNote{
      new Note(userInput)
    };
  }
}

public interface NoteDatasource{
  void saveNote(Note note){

  }
}

public class NoteRepository implements NoteDatasource{
  private NoteDatabase localStorage;
  private NoteNetworkService remoteStorage;

  @Override
  public void saveNote(final Note note){
    localStorage.saveNote(note);
    remoteStorage.saveNote(note);
  }
}
