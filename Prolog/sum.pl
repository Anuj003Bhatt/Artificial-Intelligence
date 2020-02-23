sum([],Y):- Y is 0.
sum([H|T],X):-sum(T,X1),X is H+X1.