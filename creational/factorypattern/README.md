# Gyár (factory) tervezési minta

## Ellenőrző kérdések

* Hogy biztosítja a minta azt, hogy ne kelljen a kliens módosítani egy új termék
bevezetése esetén?
* A létrehozó metódusok miért nem `static` minősítésűek?
* A konkrét gyár honnan tudja, hogy melyik terméket kell létrehoznia?

## Állatok létrehozása 

Hozzunk létre egy `Animal` interfészt, melyben van egy `speak` metódus, melynek nincs paramétere,
 visszatérési értéke pedig az adott állat által keltett hang utánzó szó. (`String speak()`)

Implementáljuk az előző interfészt egy `Cock` osztályban úgy, hogy az 
adott metódus visszatérési értéke "kukuriku" legyen!

Implementáljuk az előző interfészt egy `Horse` osztályban úgy, hogy az 
adott metódus visszatérési értéke "nyihaha" legyen!

Implementáljuk az előző interfészt egy `Frog` osztályban úgy, hogy az 
adott metódus visszatérési értéke "brekeke" legyen!

Készítsünk egy `AminalFactory` interfészt. Tartalmazzon egy `create` metódust,
 amely képes létrehozni egy állatot! `String` típusú paramétere van, amely az állat angol neve (`Animal create(String animalName)`).
 
Készítsük el a konkrét gyárat `AnimalFactoryImpl` néven, melynek `create` metódusa
három féle paramétert ismer: "cock", "horse", "frog". A paraméter alapján létrehozza a 
megfelelő objektumot, és visszaadja.

Factory használatára hozzunk létre egy `Farm` osztályt, amely függősége az `AnimalFactory` egy példánya.
Az osztály nyilván tartja, hogy milyen állat van a farmon egy `animals` nevű listában (`List<Animal>`, használj `ArrayList`-et).
Hozz létre egy `void newAnimalArrived(Animal animal)` metódust, amely eltárolja a listában a jövevényt. (Ismeretlen állat esetén nem tárol semmit.)
Hozz létre egy `List<String> getAnimalVoices()` metódust, amely visszatér a farmon található állatok hangjával.
Új sorral válaszd el a különböző hangokat! Egy hang csak egyszer szerepeljen, és az előforduló
hangok abc sorrendben következzenek!





