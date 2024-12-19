import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Hier werden die Grundfunktionen jeder Welt definiert.
 * 
 * @author Felix Heidisch
 * @version 2024-12-19
 */
public abstract class LabyrinthWorld extends World {
    /**
     * Erzeuge eine Welt mit der Größe 'x' und 'y'. Die Zellengröße ist immer auf 60, da das Hintergrundbild "cell.jpg" 60x60px groß ist.
     * In der erstellten Welt wird noch die Rheinfolge festgelegt, in der die Aktoren angezeigt werden (von oben nach unten).
     * 
     * @param x
     *      Die Größe in x Richtung.
     * @param y
     *      Die Größe in y Richtung.
     */
    public LabyrinthWorld(int x, int y) {
        super(x, y, 60);  // Erstelle die Welt mit der Größe x, y und einer Zellengröße von 60px
        
        setBackground("cell.jpg");
        setPaintOrder(Rabbit.class, Worker.class, Carrot.class, Rock.class, Marker.class);
        // setActOrder();
        
        // Rufe die "init()" Methode des LabyrinthActors auf
        LabyrinthActor.init();
    }
}