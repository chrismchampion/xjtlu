function [avgEntropyOut] = avgEntropy(pMatrix)

avgEntropy = 0;
entVector = [];
sumObsVector = [];

for this_row = pMatrix.'
    pPos = this_row(1:1);
    pNeg = this_row(2:2);    
    pObsSum = pPos + pNeg;
    
    % calculate entropy for each pair
    ent = calcEntropy(pPos, pNeg);

    % store entropy and sum of observations in vectors
    entVector = [entVector, ent];
    sumObsVector = [sumObsVector, pObsSum];
end

for i = 1:length(entVector)
    % get value from sum observation vector at i
    p1Plusp2 = sumObsVector(i);
    
    % divide by total
    prob = p1Plusp2 / sum(sumObsVector, 'all');
    
    % multiply probablility by corresponding entropy value in entVector
    avgEntropy = avgEntropy + (prob * entVector(i));    
end


avgEntropyOut = avgEntropy;

end