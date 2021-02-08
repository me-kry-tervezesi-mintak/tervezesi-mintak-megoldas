# Template method

## Ellenőrző kérdések

* Honnan lehet meghívni a védett metódust?
* Hogyan biztopsítja a minta, hogy a meghívandó metódust később, mashol adjuk meg?
 
## Banki termék kezelése feladata
Hozz létre egy `GeneralProduct` osztályt, mely tárolja a termék árát (`price`, `int` típusú)!
Hozz létre egy konstruktort mellyel az attribútum beállítható.
Definiálj egy getter metódust a termék árának kinyerésére (`getPrice`).
Deklarálj egy absztrakt metódust, amely előírja a kerekítés implementációját.
Ez legyen védett, hogy a konkrét termékek tudják felüldefiniálni.
`protected abstract int round(double newPrice)`
Hozz létre egy áremelést (`increase`) megvalósító metódust. Ennek paramétere a az áremelés mértéke
százalékban, visszatérési értéke pedig a számolt egész érték.
`public int increase(double percent)`
Mivel az új érték nem biztos, hogy egész lesz, ezért kerekíteni kell.
Használjuk az előzőleg deklarált `round` metódust!
Mivel van egy abstract metódus, így maga az osztály is abstract lesz.

Hozzunk létre egy konkrét hitel `LoanProduct` terméket, amely a `GeneralProduct`
 osztályból származik (`extends`).
Hozz létre egy konstruktort, amely megkapja a termék árát, és használja
 az ős kontruktorát ezzel a kapott értékkel!
Hozd létre a `round` metódus implmentációját úgy, hogy öt tizedestől már
a következő egészet adja vissza! (1.5 -> 2)

Hozzunk létre egy konkrét hitel `YieldProduct` terméket, amely a `GeneralProduct`
 osztályból származik (`extends`).
Hozz létre egy konstruktort, amely megkapja a termék árát, és használja
 az ős kontruktorát ezzel a kapott értékkel!
Hozd létre a round metódus implmentációját úgy, hogy mindig a valós szám egész részét adja
vissza ! (1.9 -> 1)

