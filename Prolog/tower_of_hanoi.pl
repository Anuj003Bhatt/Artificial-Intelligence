move(1,X,Y,Z):-write("MOVE TOP DISK FROM "),write(X),write(" TO "),write(Z),nl.

move(N,X,Y,Z):-N>1,M is N-1,move(M,X,Z,Y),move(1,X,Y,Z),move(M,Y,X,Z).