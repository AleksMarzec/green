## SAST
![SAST](https://github.com/AleksMarzec/green/actions/workflows/codeql.yml/badge.svg)


# Zadania
## Transakcje
W pewnym dużym banku, każdego dnia, przeprowadzanych są tysiące transakcji na rachunkach.
Są to zarówno przelewy przychodzące (wpływy) jak i wychodzące (wydatki).

Jeden z działów banku chciałby wiedzieć, jak zmienia się saldo na wszystkich rachunkach po przetworzeniu transakcji z całego dnia.
Dodatkowo ma wymaganie, aby lista rachunków była posortowana rosnąco.

Przewiduje się, że w niedalekiej przyszłości, takich transakcji może być nawet 100 000, ponieważ stale powiększa się jego baza klientów.
Nasz system musi być na to gotowy!

### Zadanie:
Napisz algorytm, który przetworzy wszystkie transakcji i zwróci posortowaną listę rachunków, wraz z ilością uznań i obciążeń oraz saldo końcowe.
Zakłada się, że saldo początkowe każdego rachunku to 0zł.

## Serwis bankomatów
Zespół serwisujący bankomaty przychodzi do pracy po długim weekendzie.
System zleceń serwisowych zawiera zgłoszenia, które muszą ustawić w kolejce obsługi.
Kolejka związana jest trasą przejazdu grupy konwojowej przez poszczególne regiony a wyznaczona trasa przejazdu pomiędzy regionami została już zatwierdzona.
Zleceń jest bardzo dużo ponieważ oprócz zaplanowanych na dzisiaj standardowych i priorytetowych prac zasilenia bankomatu, pojawiły się inne zgłoszenia które również trzeba obsłużyć.
Jednym z takich zgłoszeń jest sygnał o niskim stanie gotówki bankomatu, który nie był na dzisiaj zaplanowany takie zgłoszenie powinno być zrealizowane zaraz po zakończeniu prac nad zleceniami planowanymi priorytetowymi w danym regionie.
Innym jest sygnał o awarii bankomatu z którym zespół techniczny nie ma komunikacji i nie może przeprowadzić procedury zdalnego ponownego uruchomienia. Takie zgłoszenie powinno zostać zrealizowane w pierwszej kolejności w danym regionie.
Priorytetowe planowane zasilenie bankomatu dotyczy urządzenia gdzie trend zużycia stanu gotówki jest wysoki dlatego ta operacja jest wykonywana przez zleceniami standardowymi.

### Zadanie
Przygotuj system który przygotuje odpowiednią kolejność zleceń do obsługi dla grupy konwojowej, przy założeniu że:
1)	konwój przejeżdża przez regiony biorąc pod uwagę rosnącą kolejność przydzielonych im numerów,
2)	dany bankomat na liście zleceń dla grupy konwojowej może wystąpić tylko raz.


## Gra online
Pewna świetna gra online w ostatnim czasie stała się bardzo popularna, a liczba graczy rośnie w szybkim tempie.
Oprócz standardowej rozgrywki, co jakiś czas odbywają się eventy specjalne, na których można zdobyć najwięcej punktów. Każdy gracz chce wziąć w nich udział.
Niestety, platforma na której uruchomiona jest gra, miewa problemy wydajnościowe dlatego wejście na plansze eventu odbywa się grupowo.
W grze można tworzyć klany, stworzone z większej ilości graczy. Siłę klanu definiuje suma punktów członków klanu.
Kolejność wejścia na event specjalny zależy od sumy punktów członków klanu.

Niestety, z powodu wyżej wspomnianych problemów wydajnościowych, wejście na planszę odbywa się zgodnie z poniższymi zasadami:
- gracze wpuszczani są grupami o maksymalnym rozmiarze (m)
- gracze z danej grupy wchodzą na planszę po kolei, a nie w jednym momencie, co oznacza że najlepsi gracze wejdą na serwer pierwsi
- członkowie klanu muszą koniecznie wejść razem w jednej grupie, aby móc korzystać ze swojej najsilniejszej broni, dlatego nie można ich dzielić
- grupy trzeba zoptymalizować w taki sposób, aby wpuszczać jak największą ilość graczy podczas jednego wejścia
- jeśli cała grupa się nie zmieści w danym wejściu, to pierwszeństwo ma kolejna grupa z mniejszą liczbą punktów
- jeśli dwa klany mają taką samą ilość punktów, to większy priorytet ma klan z mniejszą liczbą graczy (co oznacza, że klan ma silniejszych graczy)
- wszystkie klany muszą się dostać na event

### Zadanie
Napisz algorytm, który dla zadanej liczby miejsc w grupie (m) oraz klanów wraz z jej liczebnością (l) i łączną liczbą punktów (p) wyznaczy kolejność oraz układ w jakich gracze powinny wejść na planszę.
Liczba klanów może być naprawdę długa, nawet do 20 000.

Liczby przyjmują wartości zgodnie z poniższymi przedziałami:
m=<1,1000>
l=<1,1000>
p=<1,100 000>

Warunki:
l <= m

