addelement(H,L,[H|L]).

start(a).
goal(o).

vertex(a,[3,3,1]).
vertex(b,[2,3,0]).
vertex(c,[2,2,0]).
vertex(d,[1,3,0]).
vertex(e,[2,3,1]).
vertex(f,[0,3,0]).
vertex(g,[1,3,1]).
vertex(h,[1,1,0]).
vertex(i,[2,2,1]).
vertex(j,[2,0,0]).
vertex(k,[3,0,1]).
vertex(l,[1,0,0]).
vertex(m,[1,1,1]).
vertex(n,[2,0,1]).
vertex(o,[0,0,0]).

edge(a,b).
edge(a,c).
edge(a,d).
edge(c,e).
edge(d,e).
edge(e,f).
edge(f,g).
edge(g,h).
edge(h,i).
edge(i,j).
edge(j,k).
edge(k,l).
edge(l,m).
edge(l,n).
edge(m,o).
edge(n,o).


print_solution([]):-true,!.

print_solution([H|T],N):-vertex(H,L1),[C|M]=L1,[Mis|B]=M,[Bt|_]=B,nl,
  write(N),write(".  "),write("     LEFT SIDE : "),write(C),write("C "),write(Mis),write("M   "),C1 is 3-C,Mis1 is 3-Mis,
  write("     RIGHT SIDE : "),write(C1),write("C "),write(Mis1),write("M   "),
  ((Bt=:=1)->(write("   BOAT IS ON LEFT SIDE"),nl);(write("   BOAT IS ON RIGHT SIDE"),nl)),N1 is N+1,print_solution(T,N1).

path(X):- dfs(X,Y),!,print_solution(Y,1).
dfs(X,Y):-((goal(X))->(Y1=[],addelement(X,Y1,Y));( edge(X,Z) ,
	   dfs(Z,X1) , addelement(X,X1,Y))).