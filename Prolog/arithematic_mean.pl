length([],0)
length([H|T],N):-length(T,N1),N is N1+1.

sum([],0).
sum([H|T],X):-sum(T,X1),X is X1+H.

armean(A,M):-sum(A,X),length(A,L),M is X/L.