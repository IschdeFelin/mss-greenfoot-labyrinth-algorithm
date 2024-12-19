import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse LabyrinthWorld_1.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LabyrinthWorld_1 extends LabyrinthWorld {
    /**
     * Konstruktor für Objekte der Klasse LabyrinthWorld_1
     */
    public LabyrinthWorld_1() {
        super(15, 14);
        prepare();
    }
    
    /**
     * Bereite die Welt für den Programmstart vor.
     * Das heißt: Erzeuge die Anfangs-Objekte und füge sie der Welt hinzu.
     */
    private void prepare() {
        for (int i=0; i<14;i++) {
            addObject(new Rock(),0,i);
            if (i != 10) {addObject(new Rock(),13,i);}
        }
        for (int i=1;i<14;i++) {
            addObject(new Rock(),i,0);
            addObject(new Rock(),i,13);
        }

        Rock rock54 = new Rock();
        addObject(rock54,2,1);
        Rock rock55 = new Rock();
        addObject(rock55,2,2);
        Rock rock56 = new Rock();
        addObject(rock56,2,3);
        Rock rock57 = new Rock();
        addObject(rock57,2,5);
        Rock rock58 = new Rock();
        addObject(rock58,2,6);
        Rock rock59 = new Rock();
        addObject(rock59,2,8);
        Rock rock60 = new Rock();
        addObject(rock60,2,10);
        Rock rock61 = new Rock();
        addObject(rock61,1,10);
        Rock rock62 = new Rock();
        addObject(rock62,2,12);
        Rock rock63 = new Rock();
        addObject(rock63,3,12);
        Rock rock64 = new Rock();
        addObject(rock64,5,12);
        Rock rock65 = new Rock();
        addObject(rock65,6,12);
        Rock rock66 = new Rock();
        addObject(rock66,7,12);
        Rock rock67 = new Rock();
        addObject(rock67,8,12);
        Rock rock68 = new Rock();
        addObject(rock68,12,12);
        Rock rock69 = new Rock();
        addObject(rock69,10,11);
        Rock rock70 = new Rock();
        addObject(rock70,10,10);
        Rock rock71 = new Rock();
        addObject(rock71,10,9);
        Rock rock72 = new Rock();
        addObject(rock72,11,9);
        Rock rock73 = new Rock();
        Rock rock74 = new Rock();
        addObject(rock74,4,2);
        Rock rock75 = new Rock();
        addObject(rock75,4,3);
        Rock rock76 = new Rock();
        addObject(rock76,5,3);
        Rock rock77 = new Rock();
        addObject(rock77,6,2);
        Rock rock78 = new Rock();
        addObject(rock78,7,2);
        Rock rock79 = new Rock();
        addObject(rock79,6,3);
        Rock rock80 = new Rock();
        addObject(rock80,7,3);
        Rock rock81 = new Rock();
        addObject(rock81,6,4);
        Rock rock82 = new Rock();
        addObject(rock82,6,5);
        Rock rock83 = new Rock();
        addObject(rock83,6,6);
        Rock rock84 = new Rock();
        addObject(rock84,4,5);
        Rock rock85 = new Rock();
        addObject(rock85,5,5);
        Rock rock86 = new Rock();
        addObject(rock86,3,5);
        Rock rock87 = new Rock();
        addObject(rock87,4,7);
        Rock rock88 = new Rock();
        addObject(rock88,4,8);
        Rock rock89 = new Rock();
        addObject(rock89,3,8);
        Rock rock90 = new Rock();
        addObject(rock90,5,8);
        Rock rock91 = new Rock();
        addObject(rock91,6,8);
        Rock rock92 = new Rock();
        addObject(rock92,7,8);
        Rock rock93 = new Rock();
        addObject(rock93,8,8);
        Rock rock94 = new Rock();
        addObject(rock94,8,7);
        Rock rock95 = new Rock();
        addObject(rock95,8,6);
        Rock rock96 = new Rock();
        addObject(rock96,8,5);
        Rock rock97 = new Rock();
        addObject(rock97,9,5);
        Rock rock98 = new Rock();
        addObject(rock98,9,3);
        Rock rock99 = new Rock();
        addObject(rock99,9,4);
        Rock rock100 = new Rock();
        addObject(rock100,4,1);
        Rock rock101 = new Rock();
        addObject(rock101,11,2);
        Rock rock102 = new Rock();
        addObject(rock102,11,3);
        Rock rock103 = new Rock();
        addObject(rock103,10,3);
        Rock rock104 = new Rock();
        addObject(rock104,8,9);
        Rock rock105 = new Rock();
        addObject(rock105,8,10);
        Rock rock106 = new Rock();
        addObject(rock106,8,11);
        Rock rock107 = new Rock();
        addObject(rock107,6,10);
        Rock rock108 = new Rock();
        addObject(rock108,3,10);
        Rock rock109 = new Rock();
        addObject(rock109,4,10);
        Rock rock110 = new Rock();
        addObject(rock110,5,10);
        Rock rock111 = new Rock();
        addObject(rock111,12,11);
        Rock rock112 = new Rock();
        addObject(rock112,12,9);
        Rock rock113 = new Rock();
        addObject(rock113,11,7);
        Rock rock114 = new Rock();
        addObject(rock114,10,7);
        Rock rock115 = new Rock();
        addObject(rock115,10,8);
        Rock rock116 = new Rock();
        addObject(rock116,11,5);
        Rock rock117 = new Rock();
        addObject(rock117,12,5);
        Rock rock118 = new Rock();
        addObject(rock118,9,1);

        MyRabbit myRabbit = new MyRabbit();
        addObject(myRabbit, 3, 1);
        myRabbit.setRotation(90);
        Carrot carrot = new Carrot();
        addObject(carrot, 14, 10);
    }
}