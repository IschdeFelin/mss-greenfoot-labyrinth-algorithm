import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.List;

/**
 * Hier befindet sich die Hauptlogik des Hasen.
 * 
 * @author Felix Heidisch
 * @version 2024-12-19
 */
public class MyRabbit extends Rabbit {
    private boolean isFirstAct = true;
    private boolean isFirstStep = true;
    private int steps = 0;
    
    /**
     * Wird ausgeführt sobald der 'Act' oder 'Run' Button gedrückt wird.
     */
    public void act() {
        if (isFirstAct) {
            System.out.println("Suche nach dem Weg zur Karotte wird gestartet...");
            isFirstAct = false;
            
            // Erstelle einen Marker an der aktuellen Position
            getWorld().addObject(new Marker(getID(), 0), getX(), getY());
            
            // Erstelle die ersten Arbeiter
            summonWorker(getX(), getY(), null, 0);
        }
        
        if (isPathGenerated()) {
            // Zeige Nachricht
            if (isFirstStep) {
                System.out.println("Gehe zur Karotte...");
                isFirstStep = false;
            }
            
            // Gehe zur Karotte
            if (isPathInDirection(getRotation())) {
                move();
            } else if (isPathInDirection(getRotation() + 90)) {
                turn(90);
            } else if (isPathInDirection(getRotation() - 90)) {
                turn(-90);
            } else if (isPathInDirection(getRotation() + 180)) {
                turn(180);
            }
            
            // Wenn die Karotte erreicht wurde, sende eine Nachricht und beende das Programm
            if (isOnObject(Carrot.class)) {
                System.out.println("Karotte erreicht!");
                Greenfoot.stop();
            }
        } else {
            // Wenn kein Arbeiter mehr existiert, gib aus, dass die Karotte nicht erreichbar ist un beende das Programm
            List<Worker> workers = getWorld().getObjects(Worker.class);
            if (workers.isEmpty()) {
                System.out.println("Die Karotte ist nicht erreichbar!");
                Greenfoot.stop();
            }
        }
    }
}