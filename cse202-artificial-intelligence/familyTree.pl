/* Family Tree */

parent(pete,ian).     % Pete is a parent of Ian
parent(ian,peter).
parent(ian,lucy).
parent(lou,pete).
parent(lou,pauline).
parent(cathy,ian).

female(cathy).        % Cathy is female.
female(lucy).
female(pauline).
female(lou).

male(ian).            % Ian is male.
male(pete).
male(peter).


/* X is the mother of Y if X is the parent
   of Y and X is female                   */

mother(X,Y):- parent(X,Y),female(X).

grandfather(X,Y):-father(X,Z),father(Z,Y).


ancestor(X,Y):-parent(X,Y).
ancestor(X,Y):-parent(X,Z),ancestor(Z,Y).


descendant(X,Y):-ancestor(Y,X).

sibling(X,Y):-parent(Z,X), parent(Z,Y), X\==Y.
% brother(X,Y) :- male(X), male(Y), X \= Y, mother(Z,X), mother(Z,Y).
brother(X,Y) :- male(X), male(Y), X \= Y, parent(Z,X), parent(Z,Y).

/* uncle_or_aunt(X,Y) will be defined
   to mean that X is the uncle or aunt of Y      */

% uncle(X,Y):-brother(X,Z),father(Z,Y).
uncle(X,Y):-brother(X,Z),parent(Z,Y).

uncle_or_aunt(X,Y):-parent(Z,Y),sibling(Z,X).