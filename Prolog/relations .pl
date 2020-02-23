male(a).
male(c).
male(e).
male(f).
male(h).
male(i).
male(k).
male(o).
male(r).
male(u).
male(t).
male(x).
male(ab).
male(w).

female(b).
female(d).
female(l).
female(m).
female(p).
female(s).
female(v).
female(n).
female(q).
female(g).
female(j).
female(y).
female(z).
female(cd).

father(a,d).
father(a,c).
father(c,e).
father(c,f).
father(w,g).
father(w,h).
father(e,k).
father(e,l).
father(f,m).
father(t,i).
father(t,j).

father(ab,z).
father(x,w).
father(o,n).
father(r,q).
father(u,t).

mother(b,d).
mother(b,c).
mother(z,e).
mother(z,f).
mother(d,g).
mother(d,h).
mother(g,i).
mother(g,j).
mother(n,k).
mother(n,l).
mother(q,m).
mother(cd,z).
mother(y,w).
mother(p,n).
mother(s,q).
mother(v,t).

son(X,Y) :- male(X),((father(Y,X),!);mother(Y,X)).
daughter(X,Y):-female(X),((father(Y,X),!);mother(Y,X)).

sibbling(X,X).
sibbling(X,Y):-father(P,X),father(Q,Y),mother(R,X),mother(S,Y),(sibbling(P,Q),!);(sibbling(P,S),!);(sibbling(Q,R),!);(sibbling(R,S),!).

descendent(P,P).
descendent(X,Y):-father(Z,X),(descendent(Z,Y),!).

uncle(X,Y):- male(X),father(Z,Y),mother(P,Y),((sibbling(X,Z),!);(sibbling(X,P),!)).