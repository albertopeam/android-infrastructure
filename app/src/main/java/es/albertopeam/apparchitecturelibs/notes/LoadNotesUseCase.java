package es.albertopeam.apparchitecturelibs.notes;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

import java.util.List;

import es.albertopeam.apparchitecturelibs.domain.NotesRepository;
import com.github.albertopeam.infrastructure.concurrency.UseCase;
import com.github.albertopeam.infrastructure.exceptions.ExceptionController;

/**
 * Created by Alberto Penas Amorberto Penas Amor on 22/05/2017.
 */

class LoadNotesUseCase
        extends UseCase<Void,List<String>> {


    private NotesRepository repository;


    LoadNotesUseCase(@NonNull ExceptionController exceptionController,
                     @NonNull LifecycleOwner lifecycleOwner,
                     @NonNull NotesRepository repository) {
        super(exceptionController, lifecycleOwner);
        this.repository = repository;
    }


    @Override
    protected List<String> run(Void aVoid) throws Exception {
        return repository.loadNotes();
    }
}
