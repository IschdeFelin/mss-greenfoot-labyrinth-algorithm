import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse LabyrinthWorld_2_2.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LabyrinthWorld_2_2 extends LabyrinthWorld {

    /**
     * Konstruktor für Objekte der Klasse LabyrinthWorld_2_2
     * 
     */
    public LabyrinthWorld_2_2() {
        super(14, 15);
        prepare();
    }
    
    /**
     * Bereite die Welt für den Programmstart vor.
     * Das heißt: Erzeuge die Anfangs-Objekte und füge sie der Welt hinzu.
     */
    private void prepare() {
        for (int i=0; i<14;i++) {
            addObject(new Rock(),0,i);
            addObject(new Rock(),14,i);
        }
        for (int i=1;i<14;i++) {
            addObject(new Rock(),i,0);
            if (i != 9 && i != 4) addObject(new Rock(),i,13);
        }

        Rock rock118 = new Rock();
        addObject(rock118,2,1);
        Rock rock119 = new Rock();
        addObject(rock119,2,2);
        Rock rock120 = new Rock();
        addObject(rock120,2,3);
        Rock rock121 = new Rock();
        addObject(rock121,2,5);
        Rock rock122 = new Rock();
        addObject(rock122,2,6);
        Rock rock123 = new Rock();
        addObject(rock123,3,5);
        Rock rock124 = new Rock();
        addObject(rock124,4,1);
        Rock rock125 = new Rock();
        addObject(rock125,4,2);
        Rock rock126 = new Rock();
        addObject(rock126,4,3);
        Rock rock127 = new Rock();
        addObject(rock127,5,3);
        Rock rock128 = new Rock();
        addObject(rock128,6,3);
        Rock rock129 = new Rock();
        addObject(rock129,7,3);
        Rock rock130 = new Rock();
        addObject(rock130,6,2);
        Rock rock131 = new Rock();
        addObject(rock131,7,2);
        Rock rock132 = new Rock();
        addObject(rock132,9,1);
        Rock rock133 = new Rock();
        addObject(rock133,9,3);
        Rock rock134 = new Rock();
        addObject(rock134,10,3);
        Rock rock135 = new Rock();
        addObject(rock135,11,3);
        Rock rock136 = new Rock();
        addObject(rock136,11,2);
        Rock rock137 = new Rock();
        addObject(rock137,9,4);
        Rock rock138 = new Rock();
        addObject(rock138,9,5);
        Rock rock139 = new Rock();
        addObject(rock139,8,5);
        Rock rock140 = new Rock();
        addObject(rock140,6,4);
        Rock rock141 = new Rock();
        addObject(rock141,6,5);
        Rock rock142 = new Rock();
        addObject(rock142,6,6);
        Rock rock143 = new Rock();
        addObject(rock143,5,5);
        Rock rock144 = new Rock();
        addObject(rock144,4,5);
        Rock rock145 = new Rock();
        addObject(rock145,4,7);
        Rock rock146 = new Rock();
        addObject(rock146,2,8);
        Rock rock147 = new Rock();
        addObject(rock147,3,8);
        Rock rock148 = new Rock();
        addObject(rock148,4,8);
        Rock rock149 = new Rock();
        addObject(rock149,5,8);
        Rock rock150 = new Rock();
        addObject(rock150,6,8);
        Rock rock151 = new Rock();
        addObject(rock151,7,8);
        Rock rock152 = new Rock();
        addObject(rock152,8,8);
        Rock rock153 = new Rock();
        addObject(rock153,8,7);
        Rock rock154 = new Rock();
        addObject(rock154,8,6);
        Rock rock155 = new Rock();
        addObject(rock155,11,5);
        Rock rock156 = new Rock();
        addObject(rock156,12,5);
        Rock rock157 = new Rock();
        addObject(rock157,11,7);
        Rock rock158 = new Rock();
        addObject(rock158,10,7);
        Rock rock95 = new Rock();
        addObject(rock95,10,8);
        Rock rock96 = new Rock();
        addObject(rock96,10,9);
        Rock rock97 = new Rock();
        addObject(rock97,11,9);
        Rock rock98 = new Rock();
        addObject(rock98,12,9);
        Rock rock99 = new Rock();
        addObject(rock99,10,10);
        Rock rock100 = new Rock();
        addObject(rock100,12,11);
        Rock rock101 = new Rock();
        addObject(rock101,12,12);
        Rock rock102 = new Rock();
        addObject(rock102,10,11);
        Rock rock103 = new Rock();
        addObject(rock103,8,10);
        Rock rock104 = new Rock();
        addObject(rock104,8,11);
        Rock rock105 = new Rock();
        addObject(rock105,8,12);
        Rock rock106 = new Rock();
        addObject(rock106,6,10);
        Rock rock107 = new Rock();
        addObject(rock107,5,10);
        Rock rock108 = new Rock();
        addObject(rock108,4,10);
        Rock rock109 = new Rock();
        addObject(rock109,3,10);
        Rock rock110 = new Rock();
        addObject(rock110,2,10);
        Rock rock111 = new Rock();
        addObject(rock111,1,10);
        Rock rock112 = new Rock();
        addObject(rock112,2,12);
        Rock rock113 = new Rock();
        addObject(rock113,3,12);
        Rock rock114 = new Rock();
        addObject(rock114,5,12);
        Rock rock115 = new Rock();
        addObject(rock115,6,12);
        Rock rock116 = new Rock();
        addObject(rock116,7,12);
        Carrot carrot = new Carrot();
        addObject(carrot,9,14);
        MyRabbit myRabbit = new MyRabbit();
        addObject(myRabbit,1,1);
        myRabbit.turn(90);
        Rock rock63 = new Rock();
        addObject(rock63,4,9);
        rock116.setLocation(7,8);
        removeObject(rock115);
    }
}
