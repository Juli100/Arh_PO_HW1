package ru.geekbrains.seminar1.inmemorymodel;

import ru.geekbrains.seminar1.modelelements.Camera;
import ru.geekbrains.seminar1.modelelements.Flash;
import ru.geekbrains.seminar1.modelelements.PoligonalModel;
import ru.geekbrains.seminar1.modelelements.Scene;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements ModelChanger {

    private Collection<Scene> scenes;

    private Collection<Flash> flashes;

    private Collection<PoligonalModel> models;

    private Collection<Camera> cameras;

    private Collection<ModelChangedObserver> ArrayList;
    private Collection<ModelChangedObserver> changeObservers = new ArrayList<>();

    //TODO: Доработать класс ...

    public ModelStore(Collection<Scene> scenes) {
        this.scenes = scenes;
    }

    public Collection<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(Collection<Scene> scenes) {
        this.scenes = scenes;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(Collection<Flash> flashes) {
        this.flashes = flashes;
    }

    public Collection<PoligonalModel> getModels() {
        return models;
    }

    public void setModels(Collection<PoligonalModel> models) {
        this.models = models;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(Collection<Camera> cameras) {
        this.cameras = cameras;
    }

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }

    @Override
    public void NotifyChange() {
            for (ModelChangedObserver o : changeObservers){
                o.ApplyUpdateModel();
            }
    }

}
