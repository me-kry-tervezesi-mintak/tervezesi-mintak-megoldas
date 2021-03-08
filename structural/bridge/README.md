# Bridge

## játék 

Hozz létre egy `Item` absztakt osztályt, melyben most csak 
* `public String getCaption();`
* Egy védett metódust, ami visszaadja a reprezentációt.
van. Eltárol egy referenciát a _Represetntation_-ra.

Hozz létre egy `Representation` interfészt, melyben
* `String getCaption(String itemName);`

Minden `Item` implementáció a függőségeként megkapott Representation-t
használva állítja elő a feliratát, csak más ad át annak.

## Reprezentációk
A Bridge implementációja.
Implementáld a `Representation` interfészt egy `NormalRepresentation` osztályban.
A metódusban térj vissza a kapott paraméter kisbetűs verziójával.

Implementáld a `Representation` interfészt egy `VisuallyImparedRepresentation` osztályban.
A metódusban térj vissza a kapott paraméter NAGYBETŰS verziójával.

## Játék elemek
A Bridge abstrakciója.
Hozz létre egy `Settlement` osztályt, amely implementálja az `Item` interfészt.
Eltárolja a település nevét, melyre van setter.
Függősége a _Representation_ referencia (attribútum + konstruktor).
* a `getCaption` metódus használja a Representation-t, paraméterének a település nevét adja.

Hozz létre egy `Character` osztályt, amely implementálja az `Item` interfészt.
Eltárolja a karakter nevét, és a típusát.
Függősége a _Representation_ referencia (attribútum + konstruktor).
* a `getCaption` metódus használja a _Representation_-t, paraméterének a karakter nevét és típusát adja.
(pl.: "Logan (warrior)")

A karakter típusára vezess be egy _CharacterType_ felsorolt típust (Warrior, Wizard).
