package ru.geekbrains.seminar1.inmemorymodel;

import ru.geekbrains.seminar1.modelelements.Camera;
import ru.geekbrains.seminar1.modelelements.PoligonalModel;

import java.util.ArrayList;
import java.util.Collection;

public interface ModelChanger {

    void RegisterModelChanger(ModelChangedObserver o);
    void RemoveModelChanger(ModelChangedObserver o);
    void NotifyChange();
}
