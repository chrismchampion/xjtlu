function [rawTable] = medianImputation(rawTable, cleanTable)
%MEDIANIMPUTATION Returns original table containing NaN values,
% replaced with corresponding column's median value.

% Get median values for each column from clean table
sepalLengthMedian = median(cleanTable{:, 'SepalLengthCm'});
sepalWidthMedian = median(cleanTable{:, 'SepalWidthCm'});
petalLengthMedian = median(cleanTable{:, 'PetalLengthCm'});
petalWidthMedian = median(cleanTable{:, 'PetalWidthCm'});

% Return rawTable with mean values in place of NaN
rawTable = fillmissing(rawTable, 'constant', sepalLengthMedian, 'DataVariables',{'SepalLengthCm'});
rawTable = fillmissing(rawTable, 'constant', sepalWidthMedian, 'DataVariables',{'SepalWidthCm'});
rawTable = fillmissing(rawTable, 'constant', petalLengthMedian, 'DataVariables',{'PetalLengthCm'});
rawTable = fillmissing(rawTable, 'constant', petalWidthMedian, 'DataVariables',{'PetalWidthCm'});

end
