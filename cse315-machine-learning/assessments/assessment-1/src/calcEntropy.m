function [entropyOut] = calcEntropy(posObs,negObs)
%ENTROPY Summary of this function goes here
%   Detailed explanation goes here

p1 = posObs/(posObs+negObs);
p2 = negObs/(posObs+negObs);

if (p1 == 0 || p2 ==0)
    entropyOut = 0;
else
    H = -(p1 * log2(p1)) - (p2 * log2(p2));
    entropyOut = H;
end

end

