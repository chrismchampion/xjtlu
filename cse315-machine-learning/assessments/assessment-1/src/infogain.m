function [ig] = infogain(S,A)
%INFOGAIN Summary of this function goes here
%   Detailed explanation goes here

aMatrix = extractFeature(S, A, 'PlayTennis');

% information gain = entropy of parent set - entropy of attribute
ig = entropyOfSet(S, 'PlayTennis') - avgEntropy(aMatrix);

end

