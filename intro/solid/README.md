# SOLID elvek

## Ellenőrző kérdések

* Miért kell az osztály modosítását tiltani (miután kész van)?
* A specifikációt milyen kérdésekkel érdemes kiegészíteni?
* Milyen a rugalmas kód?

## UserController
Készítsünk egy web alkalmazás kontrollert `UserController`! Egy olyan osztályt, ami element
egy User példányt, de csak akkor, ha az adatok megfelelőek, azaz érvényesek 
(érvényes, ha legalább 6 karakterből áll, és nem tartalmaz space karaktereket).
Webalkalmazás esetén a bemenetet mindig szűrni kell a szerver oldalon!



Ha csak ennyi van a pecifikációban gondolkodjunk el a következőkön:
* Az előző leírás csak egy szöveg egység, de hány programozói egység valójában?
Hány felelősség? Hány különböző "dolgot" kell implementálnunk? (elment, ellenőriz)
* Ha egy osztályban lenne minden, akkor mi lenne a legjobb név az osztálynak? 
* Ha később bővülni fog a specifikáció milyen új igények jöhetnek be? 
Nem mondták, de mindig be szokott még jönni, hogy. 



Ahány felelősség, annyi osztály, ezért érdmes négy entitással kezdeni:
* User pojo - még senki nem mondta, de biztos lesz életkora, számlaszáma, 
címe, ...
Készítsünk egy konstruktort, ami a paraméterében kapott String-et elmenti a 
userName adattagba. Készítsünk egy gettert az adattagra!
* Validator - ellenörzést végez.
Valószínű ebből lesz több is, ezért nem egy osztályt hozunk létre, majd az 
módosítjuk minden alkalommal, amikor új igény jelentkezik, hanem egy interfészt,
`Validator` néven. Tartalmaz egy 
 `public boolean isValid(String userName)` metódust. A feladat most csak 2 szabályt ír le, 
 implementáljuk ezt egy `AccountValidator` osztályban.
* UserController - fogadja a kéréseket, használ másokat (felső réteg). 
Két külső függősége van: validátor(ok), userService
  *egy `public void createUser(String username)` - ezt hivják, majd kivülről
  *Kellene egy konstruktor, ami függőségeket fogadja, és menti adattagba. 
  Validátorok listája, UserService
  *Kellene egy `private boolean validUserName(String userName)` metódus, ami
  használja a már beadott validátorokat. (ha nincs egy külső se, akkor is működni kell,
  ekkor az input érvényes) Az összes valaidátort használja, és ha bármelyik
  ellenörző elutasítja a bemeneti értéket, akkor a bement érvénytelen
* UserService - webalkalmazástól mentes userekkel kapcsolatos műveleteket 
implementálja. Legyen ez most csak 1 interfész, ami csak a mentést save metódusát deklarálja.
`void save(User user)`

## Js injekció ellen védett UserController
Bővítsük ki az előző kódot, hogy ki tudja szűrni a JS injekció alapú támadásokat!
Készítsünk egy `JsInjectionValidator` osztályt, amely implementálja a `Validator` interfészt,
oly módon, hogy a kapott szöveg érvénytelen, ha tartalmazza a "<script>" szöveget!

## Bónusz feladat 1.

## Bónusz feladat 2.



