edge(a,b).
edge(a,c).
edge(b,d).
edge(b,e).
edge(c,f).
edge(c,g).
edge(d,h).
edge(e,i).
edge(g,j).

add(X,L,[X|L]).
dfs(X) :-write(),edge(X,Y),dfs(Y,L1).
 