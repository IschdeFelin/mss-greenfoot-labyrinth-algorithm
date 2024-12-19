import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Hier befindet sich die Logik des Arbeiters "MyWorker".
 * 
 * @author Felix Heidisch
 * @version 2024-12-19
 */
public class MyWorker extends Worker {
    private boolean summonedNewWorker;
    
    /**
     * Erstellt einen Arbeiter und dreht ihn in die in 'direction' angegebene Richtung.
     *
     * @param parentID
     *      Die ID des Elternteils.
     * @param steps
     *      Die vom Hasen aus bereits zurückgelegten Schritte.
     * @param direction
     *      Die gewünsche Anfangsrichtung.
     */
    public MyWorker(UUID parentID, int steps, int direction) {
        super(parentID, steps);
        this.setRotation(direction);
    }
    
    /**
     * Wenn der Arbeiter erstellt wurde geht er einen Schritt nach vorne und erstellt einen Marker.
     *
     * @param world
     *      Die Welt, in der der Arbeiter erstellt wurde.
     */
    public void addedToWorld(World world) {
        this.move();
        this.madeStep();
        
        this.createMarker();
    }
    
    /**
     * Wird für jeden Aufruf von Greenfoot (bei Run) oder durch manuelles klicken auf den 'Act' Button ausgeführt.
     */
    public void act() {
        World world = getWorld();
        
        // Falls auf Karotte, dann gib eine Nachricht aus und überspringe dich zukünftig
        if (isOnObject(Carrot.class)) {
            if (!isPathGenerated()) {
                System.out.println("Die Karotte wurde gefunden!");
                generatePath();
            }
            return;
        }
        
        // Falls bei Kreuzung, dann spawne neue Worker und überspringe dich
        if (List.of(canMoveInDirection(RIGHT), canMoveInDirection(DOWN), canMoveInDirection(LEFT), canMoveInDirection(UP)).stream().filter(b -> b).count() >= 3) {
            if (!summonedNewWorker) {
                summonWorker(getX(), getY(), getID(), getSteps());
            }
            return;
        }
        
        // Wenn möglich bewegen, sonst kill dich
        if (canMoveInDirection(getRotation(), true)) {
            move();
        } else if (canMoveInDirection(getRotation() + 90, true)) {
            turn(90);
            move();
        } else if (canMoveInDirection(getRotation() - 90, true)) {
            turn(-90);
            move();
        } else {
            kill();
            return;
        }
        
        // Schritte um eins erhöhen und Marker erstellen
        madeStep();
        createMarker();
    } 
}