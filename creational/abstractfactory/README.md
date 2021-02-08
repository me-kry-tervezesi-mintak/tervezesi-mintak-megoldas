# abstract factory tervezési minta

## Ellenőrző kérdések

* Hogy biztosítja a minta azt, hogy ne kelljen a kliens módosítani egy új termék
bevezetése esetén?
* A létrehozó metódusok miért nem `static` minősítésűek?
* Mi a különbség a factory és az abstract factory között?

## Kontinensekre jellemző kapcsolatban levő állatok létrehozása 

Állatok: növényevők, ragadozók. Kapcsolat az állatok között: A ragadozók megeszik a növényevőket.
Minden kontinensen kialakultak ezek a kategóriák, de mások. Egy kliens szempontjából lényegtelen, hogy milyen konkrét ragazodó van
csak az interfészét ismeri, és tudja használni.

Hozzunk létre egy `Herbivore` interfészt. 


Hozzunk létre egy `Carnivore` interfészt, melyben csak 1 `eat` metódus van, paramétere egy `Herbivore` példány. 

Hozzunk létre egy `AbstractAnimalFactory` interfészt, melyben két metódus van:
 * `Carnivore createCarnivore();`
 * `Herbivore createHerbivore();`

Hozz létre egy csomagot `america` névvel.
Ebben a csomagban 
* hozz létre egy `Bison` osztályt, ami implementálja a `Herbivore` interfészt.
* hozz létre egy `Wolf` osztályt, ami implementálja a `Carnivore` interfészt.
* hozz létre egy `AmericaAnimalFactory` osztályt, ami implementálja a `AbstractAnimalFactory` interfészt.
  * a `createCarnivore` visszaad egy `Wolf` példányt.
  * a `createHerbivore` visszaad egy `Bison` példányt.

Hozz létre egy csomagot `africa` névvel.
Ebben a csomagban 
* hozz létre egy `Wildebeest` osztályt, ami implementálja a `Herbivore` interfészt.
* hozz létre egy `Lion` osztályt, ami implementálja a `Carnivore` interfészt.
* hozz létre egy `AmericaAnimalFactory` osztályt, ami implementálja a `AbstractAnimalFactory` interfészt.
  * a `createCarnivore` visszaad egy `Lion` példányt.
  * a `createHerbivore` visszaad egy `Wildebeest` példányt.

Hozz létre egy `CameraMan` osztályt, aminek függősége a `AbstractAnimalFactory` interfész egy példánya.
Hozz létre attribútumot és konstruktort a függőség kezelésére.
Hozz létre egy `createMovie` metódust (paraméter nélküli). A törzsében használva a beinjektált
factoryt, létrehoz egy növényevőt, majd egy ragadozót, és meghívja az `eat` metódust.



