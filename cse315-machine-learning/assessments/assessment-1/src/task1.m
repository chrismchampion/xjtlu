%% =========== TASK 1: Data Pre-processing =============
% Initialization
clear; close all; clc

%% =========== TASK 1.1 =============
% Import the dataset irismissing.csv into a data frame and find the row
% number of each instance that has missing values. [10 marks]

% Dataset contains sample information about flowers including:
% Id,SepalLengthCm,SepalWidthCm,PetalLengthCm,PetalWidthCm,Species

% Load Training Data
fprintf('Loading Data ...\n')

% Use the 'TreatAsEmpty' name-value pair argument with the readtable
% function to specify the character vectors to treat as empty values.
T = readtable('irismissing.csv','TreatAsEmpty',{'', '.', '-', 'NA'});
whos
h = height(T);
w = width(T);

% Print summary info
fprintf('Number of samples: %d\n', h)
fprintf('Number of features: %d\n', w)
fprintf('\nPrinting Summary ...\n')
summary(T)

% Display the subset of rows from the table, T, that have at least one
% missing value. Source: MathWorks MATLAB Doc
TF = ismissing(T);
rowsWithMissing = T(any(TF,2),:);
fprintf('\nNumber of rows with missing values: %d\n', ...
    height(rowsWithMissing))
disp(rowsWithMissing);

fprintf('Task 1.1 "Load data" complete. Press any key to continue.\n');
pause;

%% =========== TASK 1.2 =============
% Write a program to drop missing values, and describe other
% two strategies (median, mean) for handling missing values and
% write a function to implement these strategies. 

% Create new table, Tclean, that only contains the rows from T without
% missing values. Source: MathWorks MATLAB Doc
Tclean = rmmissing(T);
if (height(Tclean) == (h - height(rowsWithMissing)))
    fprintf('Rows containing NaN successfully removed.\n');
    fprintf('Number of rows with missing values in transformed table: %d\n', ...
    height(Tclean(any(ismissing(Tclean),2),:)));
else
    fprintf('Internal error removing NaN values.');
end

% Mean imputation function
Tmean = meanImputation(T, Tclean);
fprintf('\nHandling missing values with mean imputation:\n');
disp(Tmean(rowsWithMissing.Id, :));

% Median imputation function
Tmed = medianImputation(T, Tclean);
fprintf('\nHandling missing values with median imputation:\n');
disp(Tmed(rowsWithMissing.Id, :));

fprintf('Task 1.2 "Imputation" complete. Press any key to continue.\n');
pause;

%% =========== TASK 1.3 =============
% Compare the results of applying each missing value strategy
% using some visualization method.

% Create features for Sepal- and PetalArea
Tclean.SepalArea = Tclean{:,'SepalLengthCm'}.*Tclean{:,'SepalWidthCm'};
Tclean.PetalArea = Tclean{:,'PetalLengthCm'}.*Tclean{:,'PetalWidthCm'};

% Create table for each species
setosaTableClean = Tclean(strcmp(Tclean.Species, 'Iris-setosa'), :);
versicolorTableClean = Tclean(strcmp(Tclean.Species, 'Iris-versicolor'), :);
virginicaTableClean = Tclean(strcmp(Tclean.Species, 'Iris-virginica'), :);

% Scatter plot rm NaN
figure
scatterPlotRmNaN = scatter(setosaTableClean.PetalArea, setosaTableClean.SepalArea);
title('Species comparison from dataset with missing values removed');
xlabel('Petal Area');
ylabel('Sepal Area');

hold on
scatter(versicolorTableClean.PetalArea, versicolorTableClean.SepalArea);

hold on
scatter(virginicaTableClean.PetalArea, virginicaTableClean.SepalArea);
legend('Iris-setosa', 'Iris-versicolor', 'Iris-virginica');

% Create features for Sepal- and PetalArea
Tmean.SepalArea = Tmean{:,'SepalLengthCm'}.*Tmean{:,'SepalWidthCm'};
Tmean.PetalArea = Tmean{:,'PetalLengthCm'}.*Tmean{:,'PetalWidthCm'};

% Create table for each species
setosaTableMean = Tmean(strcmp(Tmean.Species, 'Iris-setosa'), :);
versicolorTableMean = Tmean(strcmp(Tmean.Species, 'Iris-versicolor'), :);
virginicaTableMean = Tmean(strcmp(Tmean.Species, 'Iris-virginica'), :);

% Scatter plot mean imputation
figure
scatterPlotMeanImp = scatter(setosaTableMean.PetalArea, setosaTableMean.SepalArea);
title('Species comparison from dataset with mean imputation');
xlabel('Petal Area');
ylabel('Sepal Area');

hold on
scatter(versicolorTableMean.PetalArea, versicolorTableMean.SepalArea);

hold on
scatter(virginicaTableMean.PetalArea, virginicaTableMean.SepalArea);
legend('Iris-setosa', 'Iris-versicolor', 'Iris-virginica');

fprintf('Task 1.3 "Visualization" complete. End of Task 1.\n');