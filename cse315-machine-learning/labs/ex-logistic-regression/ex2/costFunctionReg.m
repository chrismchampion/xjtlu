function [J, grad] = costFunctionReg(theta, X, y, lambda)
%COSTFUNCTIONREG Compute cost and gradient for logistic regression with regularization
%   J = COSTFUNCTIONREG(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta


% Copy of original costFunction.m without regularization:
% hypothesis
h = sigmoid(X * theta);

% cost
% Add regularization:
% reg = lambda / (2*m)
% we don't want all the thetas, only up to n
% size(theta) = [28 1]
% We want from the 2nd theta value to the end, all columns.
%                          [1,27] x [27,1] --> 1x1 so a scalar
reg = lambda / (2*m) * (theta(2:end,:)' * theta(2:end, :));
J = sum((-y .* log(h)) - (1 - y) .* log(1-h)) * 1/m + reg;

% gradient
% Must add a zero at the start to make the dimension match the cost
% function for when j=0 and for j>=1
%            28 x 1       +   27 x 1 (before adding 0, so add will work)
grad = X' * (h-y) * (1/m) + [0; lambda/m * theta(2:end, :)];




% =============================================================

end
