# Stratégia
 
## Termék - ár 

Hozz létre egy `RoundStrategy` interfészt, melyben csak 1 metódsu van:
`int convert(double from)`

Hozz létre egy `Product` osztályt, mely tárolja a termék árát (`price`, `int` típusú), és a kerekítést megvalósító 
interfész referenciáját (`RoundStrategy`)!
Hozz létre egy konstruktort mellyel az attribútumok beállíthatóak.
Definiálj egy getter metódust a termék árának kinyerésére (`getPrice`).
Hozz létre egy áremelést (`increase`) megvalósító metódust. Ennek paramétere a az áremelés mértéke
százalékban, visszatérési értéke pedig a számolt egész érték.
`public int increase(double percent)`
Mivel az új érték nem biztos, hogy egész lesz, ezért kerekíteni kell.
Használjuk az attribútumban tárolt kerekítő objektum `round` metódusát!
Mivel van egy abstract metódus, így maga az osztály is abstract lesz.

Hozz létre két kerekítő implementációt: egészre, ötösre kerekítőt.

