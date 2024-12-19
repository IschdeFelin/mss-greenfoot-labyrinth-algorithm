import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.UUID;
import java.util.List;

/**
 * Die Marker die für den Algorithmus benötigt werden. Sie könne neben ihrem normalen Status, ebenfalls den Status Stop annehmen.
 * 
 * @author Felix Heidisch
 * @version 2024-12-19
 */
public class Marker extends LabyrinthActor {
    private static final GreenfootImage IMAGE_DEFAULT = new GreenfootImage("button-green.png");
    private static final GreenfootImage IMAGE_STOP = new GreenfootImage("button-red.png");
    private static final GreenfootImage IMAGE_PATH = new GreenfootImage("button-blue.png");
    private static final GreenfootImage IMAGE_NONE = new GreenfootImage(56, 56);
    
    private UUID owner;
    private int steps;
    private boolean isStop;
    private boolean isPath;
    
    /**
     * Erstellt einen Marker mit 'owner' als Besitzer und 'steps' als bis dorthin zurückgelegte Schritte.
     *
     * @param owner
     *      Der Besitzer des Markers.
     * @param steps
     *      Die bis zu diesem Punkt vom Hasen aus zurückgelegten Schritte.
     */
    public Marker(UUID owner, int steps) {
        this.owner = owner;
        this.steps = steps;
        this.isStop = false;
        this.isPath = false;
        if (!SHOW_MARKER) {
            this.setImage(IMAGE_NONE);
        }
    }
    
    /**
     * Gibt den Besitzer des Markers zurück.
     *
     * @return
     *      Die ID des Besitzers.
     */
    public UUID getOwnerID() {
        return this.owner;
    }
    
    /**
     * Gibt die bis zu diesem Punkt vom Hasen aus zurückgelegten Schritte zurück
     *
     * @return
     *      Die bis zu diesem Punkt vom Hasen aus zurückgelegten Schritte
     */
    public int getSteps() {
        return this.steps;
    }
    
    /**
     * Gibt zurück ob der Marker auf Stop gesetzt ist.
     *
     * @return
     *      Ob der Marker auf Stop gesetzt ist.
     */
    public boolean isStop() {
        return this.isStop;
    }
    
    /**
     * Setzt den Stop Status des Markers.
     *
     * @param stop
     *      Der neue Wert für isStop.
     */
    public void setStop(boolean stop) {
        this.isStop = stop;
        if (SHOW_MARKER) {
            if (stop) {
                this.setImage(this.IMAGE_STOP);
            } else {
                this.setImage(this.IMAGE_DEFAULT);
            }
        }
    }
    
    /**
     * Gibt zurück ob der Marker ein Teil des Weges ist.
     *
     * @return
     *      Ob der Marker ein Teil des Weges ist.
     */
    public boolean isPath() {
        return this.isPath;
    }
    
    /**
     * Setzt, ob der Marker ein Teil des Weges zur Karotte sein soll.
     *
     * @param path
     *      Ob der Marker ein Teil des Weges sein soll.
     */
    public void setPath(boolean path) {
        this.isPath = path;
        if (SHOW_MARKER) {
            if (path) {
                this.setImage(this.IMAGE_PATH);
            } else {
                this.setImage(this.IMAGE_DEFAULT);
            }
        }
    }
    
    /**
     * Gibt einen Marker zurück, der einen Schritt näher am Hasen ist als der aktuelle.
     *
     * @return
     *      Ein näherer Marker.
     */
    public Marker getNearerMarkerNeighobour() {
        // List<Marker> markers = this.getNeighbours(1, false, Marker.class); // Warum funktioniert das nicht? Bei Marker 31!
        List<Marker> markers = this.getObjectsInRange(1, Marker.class);
        Marker marker = markers.stream().filter(m -> m.getSteps() < this.getSteps()).findAny().orElse(null); // Vielleicht parallelStream()
        
        return marker;
    }
}