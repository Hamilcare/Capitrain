# ReadMe

## Quickstart
java -jar main.jar


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