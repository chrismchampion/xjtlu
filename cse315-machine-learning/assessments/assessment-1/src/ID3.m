function [root] = ID3(Observations, Targets, Attributes)
% ID3 function induces decision tree from a passed in set of observations.
%   Arg1: Observations is a set of comma-separated values. The first row
%           must contain the column header names.
%   Arg2: Targets column specified in task3.m with desired target
%           values for determining leaf nodes,
%           e.g. Observations.'PlayTennis' contains {'Yes', 'No'} values.
%   Arg3: Attributes are the imported set's features, specified in task3.m;
%   used for decision nodes by calculating information gain.

fprintf('Observations\n');
disp(Observations);

% calculate highest info gain among attributes and assign to A
for i = 1:length(Attributes)
    attsInfoGain(i) = infogain(Observations, Attributes{i});
end

% get max info gain from attributesInfoGain array
[maxIG, idx] = max(attsInfoGain(:));
A = [Attributes(idx), maxIG];
fprintf('Node selection (highest info gain):');
disp(A);

% Assign unique feature values, e.g. Outlook = {Sunny, Overcast, Rain}
% Wind = {Weak, Strong}, to 'a'.
a = Observations.(A{1});
a = unique(a, 'stable');
fprintf('Branches of %s:\n', A{1});
disp(a);
root = A{1};

% for each possible branch 'a' of Observations 'A' do:
for i = 1:length(a)
    % Add a new tree branch below Root for A = a
    fprintf('Branch "%s":\n', a{i});
        
    % subset <-- Subset of Observations with A = a
    % get the indices of rows where, e.g. col 'Outlook' == 'Sunny'
    idx = find(contains(Observations.(A{1}), a{i}));
    subset = Observations(idx, :);
    fprintf('Observations\n');
    disp(subset);
        
    % Update targets to those of the subset
    Targets = subset.('PlayTennis');
    % Check for entropy == 0, i.e. all 'Yes's or all 'No's.
    yesIdx = find(contains(Targets,'Yes'));
    noIdx = find(contains(Targets,'No'));
    numYes = numel(yesIdx);
    numNo = numel(noIdx);

    % add leaf node with label of the most common value in Targets
    if (numYes > 0 && numNo == 0)
        fprintf('%s-->%s is a leaf node: Entropy(PlayTennis:"Yes") = 0.\n\n', A{1}, a{i});
    elseif (numNo > 0 && numYes == 0)
        fprintf('%s-->%s is a leaf node: Entropy(PlayTennis:"No") = 0.\n\n', A{1}, a{i});
        %root = Observations.Properties.VariableNames(1);
    % or split if entropy of node > 0
    else
        % SPLIT - add below branch ID3(Sui, Targets, Attributes - {A})
        fprintf('%s-->%s is not a leaf node.\n', A{1}, a{i});
        fprintf('Node will be split and a new decision node will be created below it.\n');
        % Remove current attribute from list of node's attributes
        Attributes(1) = [];
        fprintf('\nBegin ID3 algorithm ...\n');
        ID3(subset, Targets, Attributes);
    end
end

end