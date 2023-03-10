# DDD challenge for a gaming platform

## Bilingual Training leagues - Sofkau

### Developed by [Jonathan Pinilla](https://github.com/JonathanPinilla) - 2023 - coached by Santiago Posada
#
Project made with Maven as package manager and Spring to run the tests that where made wit junit5 and mockito.
Java 17 was used as programming language.
#
I wanted to make a Domain Driven Design based on a business related to video-games and I got inspired by platforms as Epic games or Steam that sells games, offer online services and also communication between players.
So I started to think about the business and came up with the following diagram.
## Big Picture of the business
![Big picture game platform](https://github.com/JonathanPinilla/ddd-challenge/blob/master/readmeFiles/bigPicture.png?raw=true)

There we can se how I divided the business in 5 main parts, Game Lobby as my core Subdomain, 3 support subdomains as Game catalog, Game social and Game analytics and finally 1 generic subdomain as Advertising.

There are 4 bounded context that I identified, Ads and marketing app, game shopp app, administrative app and finally Online Game Services app that is the one I choose to make in this project.
#
### Bounded context aggregates diagram
![Bounded context aggregates diagram](https://github.com/JonathanPinilla/ddd-challenge/blob/master/readmeFiles/OnlineGameServicesBoundedContext.png?raw=true)
There I divided in three aggregates that hold all the information related to the games catalog, social interactions by messages and game sessions that hold the online service

For the purpose of this project I will only focus in some behaviors and not all the possibles.

So after defining the bounded context and the aggregates I started to define the entities and value objects that I will need to implement the use cases and also the comments and events that will occur in any aggregate as follows:
![Commands and events](https://github.com/JonathanPinilla/ddd-challenge/blob/master/readmeFiles/commandsAndEventsProposal.png?raw=true)
The commands and events in the picture are the ones I defined in the first time but some will be added after.

With that in mind I imagine the Entities and its behaviors and make the following domain diagram:
![Entities and behaviors](https://github.com/JonathanPinilla/ddd-challenge/blob/master/readmeFiles/domainModel.png?raw=true)

That's the way I imagine those aggregates were related and what are going to be their elements and behaviors, so I can have a more clear way to print these ideas in the code.

The challenge asked us to make at least 3 command driven use cases and 2 event driven use cases, so I decided to make the following:
### [GameSession use cases](https://github.com/JonathanPinilla/ddd-challenge/tree/master/src/main/java/co/com/sofkau/dddchallenge/business/gameSession)
- Create a game session (command use case)
- Add a client to a game session (command use case)
- Add a server to a game session (command use case)
- Connect a client to a server (command use case)
- Disconnect a client from a server (command use case)
- Close a server (command use case)
- Update the game state (command use case)
#
### [Social use cases](https://github.com/JonathanPinilla/ddd-challenge/tree/master/src/main/java/co/com/sofkau/dddchallenge/business/social)
- Create a Social (command use case)
- Add a player to a social (command use case)
- Add a Message to a social (command use case)
- Change social state (command use case)
- [Add Matches won to a player (event use case)](https://github.com/JonathanPinilla/ddd-challenge/blob/master/src/main/java/co/com/sofkau/dddchallenge/business/social/AddMatchesWonToPlayerEventUseCase.java) triggered by the event of updating the game state
#
### [Catalog use cases](https://github.com/JonathanPinilla/ddd-challenge/tree/master/src/main/java/co/com/sofkau/dddchallenge/business/catalog)
- Create a catalog (command use case)
- Add a game to a catalog (command use case)
- Add a publisher to a catalog (command use case)
- [Update Games sold (Event use case)](https://github.com/JonathanPinilla/ddd-challenge/blob/master/src/main/java/co/com/sofkau/dddchallenge/business/catalog/UpdateGamesSoldEventUseCase.java) triggered by the event of adding a game to a player

All the use cases listed before were tested but focusing on the event use cases I made the following test:

### Add Matches won to a player event use case test
![Add Matches to a player use case test](https://github.com/JonathanPinilla/ddd-challenge/blob/master/readmeFiles/AddMatchesWonEventUseCaseCoverage.png?raw=true)

### Update Games sold event use case test
![Update Games sold event use case test](https://github.com/JonathanPinilla/ddd-challenge/blob/master/readmeFiles/UpdateGamesSoldEventUseCaseCoverage.png?raw=true)

That as a result have a coverage of a 100% for classes and methods and around 87% for lines. Thats because the exceptions weren't tested.

