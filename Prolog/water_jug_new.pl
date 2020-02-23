goal(_,2).
rule(X,Y,P,Q):-((X>0,X=\=2)->(P is 0,Q is Y,not(state(P,Q)))),write("1"),nl,assert(state(P,Q)).
rule(X,Y,P,Q):-((Y>0)->(Q is 0,P is X,not(state(P,Q)))),write("2"),nl,assert(state(P,Q)).
rule(X,Y,P,Q):-((X<3,X=\=2)->(P is 3,Q is Y,not(state(P,Q)))),write("3"),nl,assert(state(P,Q)).
rule(X,Y,P,Q):-((Y<4)->(Q is 4,P is X,not(state(P,Q)))),write("4"),nl,assert(state(P,Q)).
rule(X,Y,P,Q):-((X>0,Y<4)->(D is 4-Y,((D>X)->(P is 0,Y1 is Y+X,Q is Y1,not(state(P,Q)),write("5"),nl,assert(state(P,Q)));(X1 is X-D,P is X1,Y1 is Y+D,Q is Y1,not(state(P,Q)),write("5"),nl,assert(state(P,Q)))))).
rule(X,Y,P,Q):-((X<3,Y>0)->(D is 3-X,((D>Y)->(Q is 0,X1 is Y+X,P is X1,not(state(P,Q)),write("6"),nl,assert(state(P,Q)));(Y1 is Y-D,Q is Y1,X1 is X+D,P is X1,not(state(P,Q)),write("6"),nl,assert(state(P,Q)))))).

path(X,Y):-((goal(X,Y))->(true,!);(assert(state(X,Y)),rule(X,Y,P,Q),path(P,Q))).