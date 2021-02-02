function [rawTable] = meanImputation(rawTable, cleanTable)
%MEANIMPUTATION Returns original table containing NaN values,
% replaced with corresponding column's mean value.

% Get mean values for each column from clean table
sepalLengthMean = mean(cleanTable{:, 'SepalLengthCm'});
sepalWidthMean = mean(cleanTable{:, 'SepalWidthCm'});
petalLengthMean = mean(cleanTable{:, 'PetalLengthCm'});
petalWidthMean = mean(cleanTable{:, 'PetalWidthCm'});

% Return rawTable with mean values in place of NaN
rawTable = fillmissing(rawTable, 'constant', sepalLengthMean, 'DataVariables',{'SepalLengthCm'});
rawTable = fillmissing(rawTable, 'constant', sepalWidthMean, 'DataVariables',{'SepalWidthCm'});
rawTable = fillmissing(rawTable, 'constant', petalLengthMean, 'DataVariables',{'PetalLengthCm'});
rawTable = fillmissing(rawTable, 'constant', petalWidthMean, 'DataVariables',{'PetalWidthCm'});

end
