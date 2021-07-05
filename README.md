# Dijkstra_INF4test

Der Dijkstra-Algorithmus dient zur Pfadfindung in
einem [Kantengewichteten Graph](https://de.wikipedia.org/wiki/Kantengewichteter_Graph). In einem Kantengewichteten Graph
ist jeder Kante zwischen verschiedenen Knoten ein Kantengewichtewicht (hier Entfernung zwischen den Knoten) zugeordnet.
Es ist zwischen gerichteten und ungerichteten Kanten zu unterschieden. Ungerichtete Kanten wären normale in beide
Richtungen befahrbare Straßen, während gerichtete Kanten mit Einbahnstraßen zu vergleichen wären, die nur in eine
Richtung befahrbar sind.

Der Algorithmus sucht sich immer die in Summe kleinste Entfernung aus.
https://de.wikipedia.org/wiki/Dijkstra-Algorithmus#/media/Datei:DijkstraStep04.svg

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/DijkstraStep03.svg/460px-DijkstraStep03.svg.png "Dijkstra Deutschland")

In obiger Abbildung ist die Vorgehensweise deutlicher zu sehen. Der kürzeste Weg vom Startpunkt "Frankfurt" ist "
Mannheim".

Der zweite Schritt vergleicht die nächsten möglichen Wege und die damit verbundene Distanz zum Startknoten. Der Weg von
Frankfurt über Mannheim nach Karlsruhe ist mit 165 km kürzer als der Weg von Frankfurt nach Kassel oder Würzburg.

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/DijkstraStep04.svg/460px-DijkstraStep04.svg.png "Dijkstra Deutschland")

Im nächsten Schritt ist zu sehen, dass die Distanz von Frankfurt &rarr; Mannheim &rarr; Karlsruhe &rarr; Augsburg mit
85km + 80km + 250km = 415km deutlich länger ist als der von Frankfurt nach Würzburg mit 217km. Allerdinks ist der Weg
von Frankfurt &rarr; Kassel mit 173km der kürzeste Weg aller Optionen und wird somit als bis dahin kürzester Weg
festgelegt.


