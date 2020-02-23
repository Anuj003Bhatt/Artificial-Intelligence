addelement(X,L,[X|L]).

remove([],_,[]).
remove([H|T],P,O):-P1 is P-1,remove(T,P1,X),((P=\=0)->(addelement(H,X,O));(O = X)).

