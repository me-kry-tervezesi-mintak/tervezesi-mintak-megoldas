# Felelősség lánc

Készíts egy `Driver` interfészt (ennek most nincs implementációja, ezt később fogják implementálni).
* Egy metódusa van: `void giveItBack(int count);`

Szükség van egy `Money` osztályra, ami csak betokozza majd a pénz összegét.
Egy attribútoma van (amount, ami final), egy gettere az értékre, és egy konstruktora, ami beállítja.

`PayBackChain` absztrakt osztály a felelősség lánc egy általános elemét reprezentálja. Implementálja a láncoláshoz szükséges
dolgokat:
* megfelelő attribútumot
* egy settert, ami beállítja a következő elemet
* egy gettert, ami visszaadja
* jelen esetben előír még egy `dispense` metódust, aminek `Money` paramétere van (csak deklaráció).

Egymás után vannak láncolva a pénzérme tárolók, amlelyek visszaadnak.
Minden tároló tárol egy referenciát az egység driverére, amit megkap konstruktorban.
Minden tároló úgy írja felül a disponse metódust, hogy 
* ha kisebb összeget kap, mint ami egy egység, akkor hívja a következő azonos metódusát.
* ha nagyobb összeggel aktivizálják, mint az alap egysége, akkor
  * visszaad annyi érmét, amely szükséges (hívja a driver giveItBack metódusát)
  * tovább hívja a következő láncszem azonos metódusát a maradékkal

Storage100Ft -> Storage10Ft -> Storage1Ft
pl.: ha meghívják 523 összeggel, akkor
* a Storage100Ft visszaad 5 db-ot, majd hívja a következőt 23-al
* a Storage10Ft visszaad 2 db-ot, majd továbbad 3  értéket.
* az utolsó Storage1Ft visszaad 3-at.