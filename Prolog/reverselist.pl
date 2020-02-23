append([],L,L).
append([H|L1],L2,[H|L3]):-append(L1,L2,L3).

reverse([],Y):- Y =[].
reverse([H|T],X):- X1=[H],reverse(T,X2),append(X2,X1,X).