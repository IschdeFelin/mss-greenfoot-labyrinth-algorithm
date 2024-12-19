import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.UUID;
import java.util.List;

/**
 * Die Hauptklasse von der alle Labyrinth Aktoren erben.
 * 
 * @author Felix Heidisch
 * @version 2024-12-19
 */
public abstract class LabyrinthActor extends Actor {
    // -------------------- Config -------------------- //
    /**
     * Wenn 'SHOW_MARKER' wahr ist werden die von den Arbeitern erstellten Marker angezeigt. Sonst wird ein leeres Bild verwendet.
     * 
     */
    protected static final boolean SHOW_MARKER = false;
    /**
     * Wenn 'SHOW_WORKER' wahr ist werden die Arbeiter angezeigt. Sonst wird ein leeres Bild verwendet.
     * 
     */
    protected static final boolean SHOW_WORKER = false;
    // -------------------- Config Ende -------------------- //
    
    
    protected static final int RIGHT = 0;
    protected static final int DOWN = 90;
    protected static final int LEFT = 180;
    protected static final int UP = 270;

    private final UUID id;
    private static boolean isPathGenerated;

    /**
     * Erstellt einen LabyrinthActor mit einer eindeutigen ID.
     * 
     */
    public LabyrinthActor() {
        this.id = UUID.randomUUID();
    }
    
    /**
     * Die init() Methode wird von der Welt aufgerufen, sobald diese erstellt wird. Hier werden die Statischen Variablen zurückgesetzt.
     *
     */
    public static void init() {
        isPathGenerated = false;
    }
    
    /**
     * Gibt zurück ob der Weg zur Karotte schon erstellt wurde.
     *
     * @return
     *      Ob der Weg erstellt wurde.
     */
    public static boolean isPathGenerated() {
        return isPathGenerated;
    }
    
    /**
     * Setzt die Variable, ob der Weg generiert wurde auf 'generated'.
     *
     * @param found
     *      Der neue Wert, ob der weg gefunden wurde.
     */
    public static void setPathGenerated(boolean generated) {
        isPathGenerated = generated;
    }

    /**
     * Gibt die ID vom LabyrinthActor zurück.
     *
     * @return
     *      Die ID vom LabyrinthActor.
     */
    public UUID getID() {
        return this.id;
    }

    /**
     * Erstellt für jede verfügbare Richtung einen Arbeiter.
     *
     * @param x
     *      Die x Position der Worker
     * @param y
     *      Die y Position der Worker
     * @param parentID
     *      Die ID des parents des Workers
     * @param stepsSinceRabbit
     *      Die vom Hasen aus bereits zurückgelegten Schritte
     */
    public void summonWorker(int x, int y, UUID parentID, int stepsSinceRabbit) {
        World world = getWorld();

        if (canMoveInDirection(RIGHT, true)) {
            world.addObject(new MyWorker(parentID, stepsSinceRabbit, RIGHT), x, y);
        }
        if (canMoveInDirection(DOWN, true)) {
            world.addObject(new MyWorker(parentID, stepsSinceRabbit, DOWN), x, y);
        }
        if (canMoveInDirection(LEFT, true)) {
            world.addObject(new MyWorker(parentID, stepsSinceRabbit, LEFT), x, y);
        }
        if (canMoveInDirection(UP, true)) {
            world.addObject(new MyWorker(parentID, stepsSinceRabbit, UP), x, y);
        }
    }

    /**
     * Prüft ob das gegebene Feld 'x', 'y' begehbar ist. Dabei werden der Weltrand, Steine und Stop Marker beachtet. Wenn der Parameter
     * 'careForMarkers' wahr ist werden zusätzlich auch alle anderen Marker beachtet, die keine Stop Marker sind.
     *
     * @param x
     *      Die x Position des Feldes.
     * @param y
     *      Die y Position des Feldes.
     * @param careForMarkers
     *      Ob alle Marker beachtet werden sollen oder nur Stop Marker.
     * @return
     *      Ob das Feld begehbar ist.
     */
    public boolean isValidField(int x, int y, boolean careForMarkers) {
        World world = getWorld();
        // Prüfe das Feld inerhald der Welt liegt
        if (x >= world.getWidth() || y >= world.getHeight() || x < 0 || y < 0) {
            return false;
        }

        // Prüfe ob auf diesem Feld ein Stein ist
        List<Rock> rocks = world.getObjectsAt(x, y, Rock.class);
        if (!rocks.isEmpty()) {
            return false;
        }

        // Prüfe ob auf diesem Feld ein Stop Marker ist
        List<Marker> markers = world.getObjectsAt(x, y, Marker.class);
        if (!markers.isEmpty()) {
            // Wenn alle Marker beachtet werden sollen gib false zurück
            if (careForMarkers) {
                return false;
            }

            // Wenn mindestens ein Marker Stop ist gib false zurück
            return !markers.stream().anyMatch(m -> m.isStop());
        }

        return true;
    }

    /**
     * Prüft ob das Nachbarfeld in die gegebene Richtung 'direction' begehbar ist. Es wird die "isValidField()" Methode verwendet, also werden alle dort
     * angegebenen Objekte beachtet. Dies gillt auch für den 'careForMarkers' Parameter, welcher an eben genannte Methode weitergegeben wird.
     *
     * @param direction
     *      Die zu prüfende Richtung.
     * @param careForMarkers
     *      Ob alle Marker beachtet werden sollen.
     * @return
     *      Ob das Feld in die gegebene Richtung begehbar ist.
     */
    public boolean canMoveInDirection(int direction, boolean careForMarkers) {
        int x = getX();
        int y = getY();
        direction = (direction + 360) % 360;
        switch (direction) {
            case RIGHT:
                x++;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case UP:
                y--;
                break;
        }

        return isValidField(x, y, careForMarkers);
    }

    /**
     * Prüft ob das Nachbarfeld in die gegebene Richtung 'direction' begehbar ist. Es wird die "isValidField()" Methode verwendet, also werden alle
     * dort angegebenen Objekte beachtet. Der careForMarkers Parameter ist hier immer auf false gesetzt.
     * 
     * @param direction
     *      Die zu prüfende Richtung.
     */
    public boolean canMoveInDirection(int direction) {
        return canMoveInDirection(direction, false);
    }
    
    /**
     * Prüft ob in die Richtung 'direction' ein Weg Marker ist.
     *
     * @param direction
     *      Die zu prüfende Richtung.
     * @return
     *      Ob dort ein Path Marker ist.
     */
    public boolean isPathInDirection(int direction) {
        List<Marker> markers = getObjectsInDirection(direction, Marker.class);
        return markers.stream().anyMatch(m -> m.isPath());
    }

    /**
     * Eine Variante der "Actor.move()" Methode ohne Parameter. Es wird immer genau ein Schritt zurückgelegt.
     *
     */
    public void move() {
        super.move(1);
    }

    /**
     * Prüft ob auf dem eigenen Feld ein bestimmtes Objekt der Klasse 'type' ist.
     *
     * @param type
     *      Die Klassenreferenz des zu prüfenden Objekts.
     * @return
     *      Ob ein Objekt vorhanden ist.
     */
    public boolean isOnObject(Class type) {
        Actor obj = getOneObjectAtOffset(0, 0, type);
        if (obj != null) {
            return true;
        }
        return false;
    }

    /**
     * Prüft ob in gegebener Richtung 'direction' ein Objekt des Types 'type' auf dem Nachbarfeld ist.
     *
     * @param direction
     *      Die zu prüfende Richtung.
     * @param type
     *      Die Klassenreferenz des zu prüfenden Objekts.
     * @return
     *      Ob ein Objekt vorhanden ist.
     */
    public <A> boolean isObjectInDirection(int direction, Class<A> type) {
        List<A> objects = getObjectsInDirection(direction, type);
        if (objects.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * Gibt alle Objekte des Types 'type' des Nachbarfeldes in der gegeben Richtung 'direction' zurück.
     *
     * @param direction
     *      Die zu prüfende Richtung.
     * @param type
     *      Die Klassenreferenz des gesuchten Objekts.
     * @return
     *      Eine Liste mit den gefundenen Objekten.
     */
    public <A> List<A> getObjectsInDirection(int direction, Class<A> type) {
        int x = 0;
        int y = 0;
        direction = (direction + 360) % 360;
        switch (direction) {
            case RIGHT:
                x++;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case UP:
                y--;
                break;
        }

        return getObjectsAtOffset(x, y, type);
    }
}