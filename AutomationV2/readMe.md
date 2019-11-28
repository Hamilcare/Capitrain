# ReadMe

_Valentin Quiédeville_  
_Vivien Louradour_


## Quickstart
```bash
java -jar main.jar <pathToPatternCsv> <Aggregator> <Feature> <ParserType> <PathToDataFile>
```

__pathToPatternCsv__ path to the pattern csv 

__aggregator__ choose among :
* min
* max

__feature__ choose among : 
* MAX
* MIN
* ONE
* SURFACE
* WIDHT

__parserType__ choose among :
* __single__ to parse a single line datafile
* __multiple__ to parse a multi line datafile

### Exemples
```bash
java -jar Main.jar ./resources/pattern/peak.csv min width  ./resources/input/pi_commun_dataset/1000.digt single
```

```bash
java -jar Main.jar ./resources/pattern/peak.csv min width  resources/input/other_dataset/consommation-quotidienne-totale multiple
```


## Implemented Features
* MAX
* MIN
* ONE
* SURFACE
* WIDHT

## Implemented Aggregators 
* MIN
* MAX

## Available Pattern ATM
```
cf resources/pattern
```
* increasing_sequence
* increasing_terrace
* increasing
* peak
* plateau
* proper_plateau
* strictly_increasing_sequence
* summit

## Pattern File
To describe pattern we use csv file as follows 
```
before,after
firstState,SecondState,ect
Alphabet,SemanticLetter,StartingState,TargetState
```

For instance increasing is writtent as follows
```
0,0
S
<,founde,S,S
>,out,S,S
=,out,S,S
```