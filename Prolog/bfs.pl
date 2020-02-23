node(1,2,3).
node(2,4,5).
node(3,6,7).
node(4,8,9).
bfs(S,L3):-write(S),findall(X,node(S,X,Y),L),findall(Y,node(S,X,Y),L1),append(L3,L,NL),append(NL,L1,FL),!,root(FL).
root([H|T]):-bfs(H,T).
root([]).
