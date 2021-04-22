# Decorator

## Feladat html szöveg

Feladat egy html objektum forrássá alakítása osztályokkal. Származtatással
a sima szövegből több szöveg is specializálódik vastag,  dőlt, aláhúzott.
Megnézzük öröklődéssel, majd utána tartalmazással (dekorátor minta használatával)

Deklarálj egy `TextSource` interfészt az `isahasa` csomagban, melyben csak egy metódus van: `String getPlainText()`.

Hozz létre egy `HtmlText` osztályt az `isahasa` csomagban, ami implementálja a `TextSource`
 interfészt.
 Egy `plainText` attribútumban tárolja a kívánt szöveget, melyet a konstruktorban kap meg.
 * a `getPlainText()` ebben az esetben csak visszaadja a tárolt szöveget.
 
Hozz létre egy `Channel` interfészt, ami csak egy metódust tartalmaz: `int writeByte(byte[] bytes)`

Szükség van még egy kliens osztályra, amely kap egy `TextSource`-ot és ráírja a csatornára a tartalmát.
* A csatornáját egy attribútumban tárolja.
* Konstruktorban megkapja a csatorna referenciát, amit eltárol az attribútumban.
* definiál egy publikus `writeToChannel` metódust, ami megkap egy `TextSource` referenciát. A paraméter
tartalmát lekéri a `getPlainText` metódussal, amit átalakít byte tömbbé (`String` osztálynak van ilyen metódusa), és ezzel hívja a 
csatorna `writeByte` metódusát.
 
## Első megoldás származtatással

A `BoldHtmlText` a vastagon szedett szöveget megvalósító osztály az `isa` csomagban van, és a 
`HtmlText`-ből származik.
* a konstruktorban megkapott szöveget a `super`-nek adjuk át, így inicializáljuk.
* a `getPlainText` `<b>` és `</b>` közzé fogja az ősben definiált `getPlainText` eredményét.

A `ItalicHtmlText` a dőlten szedett szöveget megvalósító osztály az `isa` csomagban van, és a 
`HtmlText`-ből származik.
* a konstruktorban megkapott szöveget a `super`-nek adjuk át.
* a `getPlainText` `<i>` és `</i>` közzé fogja az ősben definiált `getPlainText` eredményét.

A `UnderlinedHtmlText` az aláhúzott szöveget megvalósító osztály az `isa` csomagban van, és a 
`HtmlText`-ből származik.
* a konstruktorban megkapott szöveget a `super`-nek adjuk át.
* a `getPlainText` `<u>` és `</u>` közzé fogja az ősben definiált `getPlainText` eredményét.

A `ItalicAndBoldHtmlText` a vastag betűt megvalósító osztály az `isa` csomagban van, és a 
`HtmlText`-ből származik.
* a konstruktorban megkapott szöveget a `super`-nek adjuk át.
* a `getPlainText` `<i><b>` és `</b></i>` közzé fogja az ősben definiált `getPlainText` eredményét.

Vegyük észre, hogy minden variációra külön osztály kell (pl.: vastagbetűs és aláhúzott és dőlt).

## Második megoldás tartalmazással (decorator minta)

Most oldjuk meg ezt a feladatot tartalmazással, a dekorátor minta segítségével.

Hozzunk létre egy `TextDecorator` abstract osztályt (a `hasa` csomagban), amely implementálja a konkrét dekorátoroknak
a tartalmazás kapcsolatot.
* A `TextSource` interfészt implementálja. (az előírt metódust nem definiálja
felül, ezért is lesz absztrakt)
* egy védett attribútuba van: `TextSource textSource`

`Bold` osztály (ami egy konkrét dekorátor a `hasa` csomagban) a `TextDecorator` osztályból származik.
* definiál egy konstruktort, amely megkap egy `TextDecorator` referenciát, amire beállítja az örökölt `textSource` attribútumot.
* implementálja az őstől kapott `getPlainText` metódust úgy, hogy a tartalmazott `textSource` referenciája meghívja a `getPlainText`
metódust, és a az értéket közrezárja a `<b>` és `</b>` közzé. (Ez még nagyon hasonló a származás megoldásához.
Különbség az, hogy ott a `super`-en hívtuk meg a `getPlainText` metódusát, itt pedig az attribútumon.)

`Italic` osztály (ami egy konkrét dekorátor a `hasa` csomagban) a `TextDecorator` osztályból származik.
* definiál egy konstruktort, amely megkap egy `TextDecorator` referenciát, amire beállítja az örökölt `textSource` attribútumot.
* implementálja az őstől kapott `getPlainText` metódust úgy, hogy a tartalmazott `textSource` referenciája meghívja a `getPlainText`
metódust, és a az értéket közrezárja a `<i>` és `</i>` közzé. 

`Underlined` osztály (ami egy konkrét dekorátor a `hasa` csomagban) a `TextDecorator` osztályból származik.
* definiál egy konstruktort, amely megkap egy `TextDecorator` referenciát, amire beállítja az örökölt `textSource` attribútumot.
* implementálja az őstől kapott `getPlainText` metódust úgy, hogy a tartalmazott textSource referenciája meghívja a `getPlainText`
metódust, és a az értéket közrezárja a `<u>` és `</u>` közzé. 


Az előbbi dekorátorok létrehozásának paramétere lehet az alap `HtmlText`, de lehet bármelyik dekorátor is,
hiszen mindegyik implementálja a `TextSource` interfészt. Ezért a dőlt vastagbetűs szöveget a dekorátorok
láncolásásval megoldhatjuk, nem kell új osztály. Ugyanígy a többi variációra sem kell. Az előbbi dekorátorokkal azok
bármilyen kombinációja láncolható.
