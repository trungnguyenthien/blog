

```
@startuml

title Parallel - Activity Diagram 
start
:Eat Hot Wings;
:Drink Homebrew;
if (Turn On The Game?) then (yes)
  fork
    :__Having Fun__!!!;
  fork again
    :Scream At TV!!;
  end fork
else (no)
  :Not Having Fun;
  :Eat Poptart;
  stop
endif
:Go To Bed;
stop

@enduml
```

![PlantUML Diagram](https://www.planttext.com/api/plantuml/img/HP31Ri9034Jl_eh9BHpw0ycXKD72YI8HjSV81IUisEoYNGV4tzSXbNgoTcOyUjvbLauw3fv8dNh1dXDxBnulM1tLtPm-i7RS9nv0HCyuKVNEYcrKVBlGvzg4TNBXOj8WFqdkfhWEPJEcWC-0vYpOy22l2-XP0ig7v0K1NKmN6q3Ljbk-MHS-nj2sHL7KVpQuPnVcqE6On31MYkPhJaWupINYiw0CSMgjTWRsNpVbdhpxU9teftVMU2LRTfsXRoAQY3SvrTDzPj3IBFkJNm00)

```
@startuml
(*) --> [User tap on Helpful Button] "MarkInProgress"

if "Login Status?" then 
  -->[Login] "StartRequest"
  --> "Map ResponseStatus to Helpful Button"
  note left: wait for API's response
  --> (*)
else 
  -> [NotLogin] "Show LoginConfirmation\nPauseVideo"
  if "PressButton" then 
    --> [Login] "Show LoginScreen \n Do Login Success"
    --> "Back to Player \n Resume Video IfNeed"
    note left: wait user do login
    --> "StartRequest"
  else 
    --> [Cancel] "Unmark InProgess"
    --> "Resume Video IfNeed"
    --> (*)
  endif
endif
@enduml
```

![PlantUML Diagram](https://www.planttext.com/api/plantuml/img/TL9BJyCm3BxtLrYzy93s1pZ0s7QW4apLgd7PE4IjiqLBxP8uclZt97qCCSGbKMJxUpbpByf9Q6rsUty7izaZxBOU7OZgW0bUq7OwM5W44QOFoD-KEnLKEZuuz3xFCgCXV-M38QX4IV1FESWH2J98QBk-5EUgHBF1pu1Uyg6Mm3hOeE-OF0xJ87p5cPg91S6YbWSuAoEWsS5pMTnuSEFqY1WzP6WzzkpHofhb8k38P-WVIoPjNAl4CEsfLC7ZkscG4rDoKoPd8_d5ou2_-ujMrGvZovvWnJ064Ugw3sSQonUgFYLhfLLVCTpO76s75g4dXaAl4PkX_zfhIDje66o2_a6ypdDoFUfSAghHHg5RQkF6O5ZPRr7_IfYIZAZK69qDvpnUyPzy0m00)