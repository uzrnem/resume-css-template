var {cards, types, digits, symbols, playerSet,
  players, rows, playCard, finishedCard} = require('./data.js');

cards = cards.sort(function () { return Math.random() - 0.5; });

cards.forEach(function (card, c) {
    players[c % 4][card.getType()].push(digits[card.getNumber()]);
});

var playerId = 2;

console.log(players[playerId]);

for ( p = 0 ; p < 4 ; p++ ) {
  console.log("player[", p, "]:", players[p]);
}
var isStarted = true;
for (c = 0 ; c < 52; c ++ ) {
  for ( p = 0 ; p < 4 ; p++ ) {
    var card = playCard(players[p], p, rows, isStarted);
    if (card != null) {
      isStarted = false;
      if (finishedCard(players[p])) {
        console.log("Played & Wonned by " + p);
        c = 52;
        p = 4;
      } else {
        //console.log("Played " + p);
      }
    } else {
      //console.log("Passed by " + p)
    }
  }
}
console.log("rows:", rows);
for ( p = 0 ; p < 4 ; p++ ) {
  console.log("player[", p, "]:", players[p]);
}
