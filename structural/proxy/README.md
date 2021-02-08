# proxy

## Egy kötegelve loggoló proxy osztály

Hozz létre egy `Log` interfészt
* logRequest metódus (string paraméter)


Hozz létre egy `RealLogger` interfészt, amely a `Log` interfészből származik, de egy új metódust is deklarál
`void changeLogLevel();`


Hozz létre egy `LogProxy` osztályt, ami implementálja a Log interfészt
a loggolandó üzeneteket a `logMessages` a tényleges loggoló objektum referenciáját
 pedig a logger attribútumba tárolja.
* Definiálj egy `PAGE_SIZE` konstanst 10-es értékkel.
* definiálj egy konstruktort, amelyben magkapod a valós loggoló objektumot, és elmented.
* `addLogging` (private) : paramétere a log üzenenet, amit tárol a listában.
* `performLogging` (private): meghívja a valóságos loggoló fv-ét a RealLoggernek szükség esetén.
* `logRequest` metódus az implementációja az interfészben előírt metódusnak. Nem adja tovább a kérést közvetlen, hanem
  * csak minden PAGE_SIZE-adik alkalommal (most 10) hívja a `performLogging` metódust.
  * ha nem kell ténylegesen loggolni, akkor gyűjti a log üzeneteket a listába, azaz
  meghívja az `addLogging` metódust



