%% =========== TASK 3: Decision Tree Algorithm =============
% Implement the ID3 decision tree from the pseudocode
% (recursive ID3 algorithm) and induce/learn the tree from the data
% in the figure of Task 2.2 ('playtennis.csv').

% Initialization
clear; close all; clc

% Load Training Data
fprintf('Importing comma-separated values ...\n')

% Use the 'TreatAsEmpty' name-value pair argument with the readtable
% function to specify the character vectors to treat as empty values.
S = readtable('playtennis.csv','TreatAsEmpty',{'', '.', '-', 'NA'});

% Target column for determining leaf nodes; contains {'Yes','No'} values
targets = S.('PlayTennis');

% Get attributes
attributes = S.Properties.VariableNames;
% Remove first and last column of attributes, i.e. 'Day' and 'PlayTennis'
attributes = attributes(2:length(attributes)-1);

fprintf('\nFound attributes:')
disp(attributes);

fprintf('Begin ID3 algorithm ...\n')
ID3(S, targets, attributes);

fprintf('\nTask 3 "Decision Tree Algorithm" complete. End of Task 3.\n');