# Rock Paper Scissor Game
***

This is a test application developed by Marcos Cassiani 

## How to start it? 🚀

_This is a springboot application that use maven as dependency manager. You can run:_
```
mvn clean install
```

_Then, you can run the main class **RockPaperScissorsGameApplication**._

_This will run on port 8888, if that is a problem, you can change it from the **application.properties** file._

```
server.port=8888
```

### Testing the endpoints 🔧

_For testing the endpoints you could use the postman collection:_
```
resources/RockPaperScissorGame.postman_collection.json
```
1. _CreateMatch:_ Creates a new match.
2. _GetMatch:_ Get a specific match with its id.
3. _GetAllMatches:_ Get all existing matches.
4. _PlayRound:_ Play a new round on a match.
5. _GetMatchStats:_Get the stats for all matches.

Please note that if you change the server port, you will also need to update the ids of the postman requests.

## Running the automated tests ⚙️

_This project has 100% of code coverage. To run the automated test just execute the maven command:_

```
mvn test
```

## Author ✒️

* **Marcos Cassiani** - *Design and Development* 

## Licence 📄

Free to use for everyone.

---
⌨️ con ❤️ por Marcos Cassiani 😊