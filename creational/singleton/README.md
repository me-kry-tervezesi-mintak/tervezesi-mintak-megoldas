# Singleton

## Raktár, termelő, fogyasztó szimuláció

Hozz létre egy termék (Product) oszályt, 
* amelynek van neve (final attribútum), 
* van konstruktora, amely beállítja a nevét, 
* és getter a nevére.

Hozz létre egy interfészt `Store` azonosítóval, a következő elemekkkel
* `add` metódus, amely bead egy terméket a raktárba. 
`StoreFullException` dobódik, ha már nem fér be a raktárba
* `remove` metódus, amely kivesz egy terméket a raktárból
`StoreEmptyException` kivétel dobódik, ha a raktár már üres.
* `reset` metódus, ami törli a raktár tartalát.
* `getProductCount` metódus, ami visszaadja a raktárbn levő termékek számát.

Implementáld a `Store` interfészt a `StoreImpl` osztályban úgy, hogy
A StoreImpl-ből csak 1 jöhet létre a rendszerben!
A termékek tárolására vezess be egy `products` nevű attribútumot (queue, LinkedList).
Vezess be egy `CAPACITY` konstanst 3000 értékkel.
Implementáld a megfelelő metódusokat értelemszerűen. (Ne feledkezz meg a két kivétel dobásáról sem.)

Hozz létre egy `Consumer` osztályt, melynek függősége a `Store`.
* Hozz létre benne egy `consume` metódust, ami megpróbál kivenni egy terméket a raktárból és visszaadja azt.
(kivételt nem kezeli.)

Hozz létre egy Producer osztályt, melynek függősége a `Store`.
* Hozz létre benne egy `produce` metódust, ami megpróbál létrehozni és betenni a raktárba egy terméket.
(kivételt nem kezeli.) A termék neve legyen product és a sorszáma. pl. product0, product1, ...