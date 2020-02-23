square([]).
square([H|T]):-write(H),write("  "),Sq is H*H,write(Sq),nl,square(T).