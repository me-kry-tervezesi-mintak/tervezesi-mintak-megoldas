# Command

Készíts egy `Command` interfészt, amleyben csak két metódus van
* execute,
* unexecute

Készíts egy `Calculator` osztályt. Ez tartalmazza az üzleti logikát, és számítások eredményét.
* Tartalmaz egy `currentValue` attribútumot, amely tárolja az aktuális értéket.
* Hozz létre egy publikus gettert az attribútumra.
* Hozz létre egy operation metódust, amely kap két paramétert: operandus, operator.
A `currentValue`-n végrahajta a müveletet, és eltárolja abban.

Készíts egy `CalculatorCommand` osztályt, amely implementálja a Command interfészt.
* Konstruktorában kapja meg a szükséges adatokat:
  * végrehajtó objketum referenciáját (`Calculator` üzleti logikát implementálja)
  * operandust, 
  * operatort
* implementálja az `execute` metódust, hogy használja a `operation` metódusát a `Calculator` példányának.
* implementálja az `unexecute` metódust, hogy használja a `operation` metódusát a `Calculator` példányának,
de az operator az inverz operator legyen.
* érdemes lenne egy `reverseOperator` privát metódust bevezetni.

Készíts egy `Invoker` osztályt, amely létrehozza majd a parancsokat, eltakarja a szerkezetet a kliens elől és
 tárolja a parancsok listáját.
* Nyilvántartja a parancsok listáját, aktuális parancs indexét, és a `Calculator` példányát.
* Legyen egy `getActualValue`, amely visszaadja az aktuális értéket (`Calculator`-ban tárolt)
* Konstruktorban kapja meg a `Calculator`-t.
* Hozz létre egy `compute` metódust, ami létrehozza `CalculatorCommand` egy példányát, 
meghívja az `execute`-ot a parancsot, eltárolja a listában, aktualizálja az aktuális indexet.
(paraméterben megkapja az operációt és az operandust)
* Hozz létre egy `undo`, `redo`, amely megkapja a parancs indexét, amíg ismételni, vagy vissza kell vonni a parancsokat.
Elvégzi a visszavonásokat, ismétléseket használva a lista parancs elemeit, hívva az `execute`-ot, vagy `unexecute`-ot