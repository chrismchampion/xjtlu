%% =========== TASK 2: Decision Trees =============
% Initialization
clear; close all; clc

%% =========== TASK 2.2.1 =============
% Write a function that computes the entropy of a set S with
% Npos positive observations and Nneg negative observations.

% Load Training Data
fprintf('Loading Data ...\n')

% Use the 'TreatAsEmpty' name-value pair argument with the readtable
% function to specify the character vectors to treat as empty values.
S = readtable('playtennis.csv','TreatAsEmpty',{'', '.', '-', 'NA'});

whos
h = height(S);
w = width(S);

% Print summary info
fprintf('Number of samples: %d\n', h)
fprintf('Number of features: %d\n', w)
fprintf('\nPrinting Summary ...\n')
summary(S)

% Get number of pos/neg observations
% by getting index of 'Yes' and 'No'
% values in T.PlayTennis and retrieving
% number of elements.
yesIndex = find(contains(S.PlayTennis,'Yes'));
noIndex = find(contains(S.PlayTennis,'No'));
nPos = numel(yesIndex);
nNeg = numel(noIndex);

fprintf('Positive observations: %d\n' ,nPos);
fprintf('Negative observations: %d\n' ,nNeg);
fprintf('Entropy of set: %f\n', calcEntropy(nPos, nNeg));

fprintf('\nTask 2.2.1 "Entropy function" complete. Press any key to continue.\n');
pause;

%% =========== TASK 2.2.2 =============
% Write a function that takes input as a set S of observations
% and an attribute A from these observations, and calculates the
% information gain denoted as Gain(S,A), as if we were to split on that
% attribute in the context of the ID3 decision tree algorithm.

ig = { 'Outlook' 0;
       'Temperature' 0;
       'Humidity' 0;
       'Wind'   0      };
   
ig{1, 2} = infogain(S, ig{1, 1});
ig{2, 2} = infogain(S, ig{2, 1});
ig{3, 2} = infogain(S, ig{3, 1});
ig{4, 2} = infogain(S, ig{4, 1});

fprintf('\nTask 2.2.2 "Information Gain function" complete. Press any key to continue.\n\n');
pause;

%% =========== TASK 2.2.3 =============
% Estimate the information gain of all the attributes. 
% Which one will you choose for the root node of your decision tree?

disp(ig);
% find max info gain value from ig matrix column 2
[maxIG, idx] = max([ig{:,2}]);
rootName = ig{idx, 1};
fprintf('Root node selection (max. information gain): %s\n', rootName);

fprintf('\nTask 2.2.3 "Root Node selection" complete. End of Task 2.\n');