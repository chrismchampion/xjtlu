function [entropyOut] = entropyOfSet(set, targetColName)
%ENTROPY Summary of this function goes here
%   Detailed explanation goes here

% Get number of pos/neg observations
% by getting index of 'Yes' and 'No'
% values in T.PlayTennis and retrieving
% number of elements.
yesIndex = find(contains(set.(targetColName),'Yes'));
noIndex = find(contains(set.(targetColName),'No'));
nPos = numel(yesIndex);
nNeg = numel(noIndex);

%fprintf('Positive observations: %d\n' ,nPos);
%fprintf('Negative observations: %d\n' ,nNeg);

p1 = nPos/(nPos+nNeg);
p2 = nNeg/(nPos+nNeg);

if (p1 == 0 || p2 ==0)
    entropyOut = 0;
else
    H = -(p1 * log2(p1)) - (p2 * log2(p2));
    entropyOut = H;
end

end

