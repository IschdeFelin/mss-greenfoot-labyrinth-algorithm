import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.UUID;
import java.util.List;

/**
 * Die Klasse, in der die Grundfunktionen eines Arbeiter definiert und gesetzt werden.
 * 
 * @author Felix Heidisch
 * @version 2024-12-19
 */
public abstract class Worker extends LabyrinthActor {
    private static final GreenfootImage IMAGE_NONE = new GreenfootImage(28, 28);
    
    private UUID parentID;
    private int steps;
    
    /**
     * Erstellt einen Arbeiter und hinterlegt 'parentID' als die ID des Elternteils und 'stepsSinceRabbit' als die Schritte, die seit dem Hasen
     * bereits zurückgelegt wurden. Wenn in der "LabyrinthActor" Klasse SHOW_WORKER falsch ist wird ein durchsichtiges Bild verwendet.
     *
     * @param parentID
     *      Die ID des Elternteils.
     * @param stepsSinceRabbit
     *      Die vom Hasen aus bereits zurückgelegten Schritte.
     */
    public Worker(UUID parentID, int steps) {
        this.parentID = parentID;
        this.steps = steps;
        if (!SHOW_WORKER) {
            this.setImage(IMAGE_NONE);
        }
    }
    
    /**
     * Gibt die ID des Elternteils zurück.
     *
     * @return
     *      Die ID des Elternteils.
     */
    public UUID getParentID() {
        return this.parentID;
    }
    
    /**
     * Gibt die vom Hasen aus bereits zurückgelegten Schritte zurück.
     *
     * @return
     *      Die vom Hasen aus bereits zurückgelegten Schritte.
     */
    public int getSteps() {
        return this.steps;
    }
    
    /**
     * Erhöht die vom Hasen aus zurückgelegten Schritte um eins.
     *
     */
    public void madeStep() {
        this.steps++;
    }
    
    /**
     * Erstellt einen Marker an der aktuellen Position. Wenn bereits ein Marker vorhanden ist wird nichts gemacht??
     *
     */
    public void createMarker() {
        if (!isOnObject(Marker.class)) {
            getWorld().addObject(new Marker(getID(), getSteps()), getX(), getY());
        }
    }
    
    /**
     * Entfernt den aktuellen Arbeiter und setzt all seine Marker zu Stop, wenn er keine Kinder mehr hat. Dannach wird auf dem Elternteil die
     * kill() Funktion aufgerufen.
     *
     */
    public void kill() {
        World world = getWorld();
        
        // Prüfen ob noch Kinder existieren, sonst weiter
        List<Worker> workers = world.getObjects(Worker.class);
        if (workers.stream().anyMatch(w -> w.getParentID() == this.getID())) {
            return;
        }
        
        // Setze die Marker des Workers zu Stop
        List<Marker> markers = world.getObjects(Marker.class);
        markers.forEach(m -> {
            if (m.getOwnerID() == this.getID()) {
                m.setStop(true);
            }
        });
        
        // Sende kill Aufforderung an den Parent für den Fall, dass man das letzte Kind war
        if (this.parentID != null) {
            workers.forEach(w -> {
                if (w.getID() == this.parentID) {
                    w.kill();
                }
            });
        }
        
        // Entferne den Helfer aus der Welt
        world.removeObject(this);
    }
    
    /**
     * Generiert aus den von den Arbeitern erzeugten Markern den kürzesten Weg zur Karotte.
     *
     */
    public void generatePath() {
        // Bekomme den aktuellen Marker
        Marker marker = (Marker) getOneObjectAtOffset(0, 0, Marker.class);
        
        // Solange der Hase nicht erreicht wurde, verfolge den kürzesten Weg zurück und setzte die Marker zu Path
        while (marker != null && marker.getSteps() >= 0) {
            marker.setPath(true);
            marker = marker.getNearerMarkerNeighobour();
        }
        
        // Setze die Variable, dass der Weg generiert wurde auf wahr
        setPathGenerated(true);
        
        // Entferne alle Worker
        World world = getWorld();
        List<Worker> workers = world.getObjects(Worker.class);
        world.removeObjects(workers);
        
        // Entferne alle anderen Marker
        List<Marker> markers = world.getObjects(Marker.class);
        markers = markers.stream().filter(m -> !m.isPath()).toList();
        world.removeObjects(markers);
    }
}