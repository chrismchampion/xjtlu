function [J, grad] = costFunction(theta, X, y)
%COSTFUNCTION Compute cost and gradient for logistic regression
%   J = COSTFUNCTION(theta, X, y) computes the cost of using theta as the
%   parameter for logistic regression and the gradient of the cost
%   w.r.t. to the parameters.

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
%
% Note: grad should have the same dimensions as theta
%


% First need hypothesis 'h_sub_theta' value.
%size(X)     % ans = [100 3]
%size(theta) % ans = [ 3  1]

% We want a prediction for all training examples,
% so the result should be [100 1]
h = sigmoid(X * theta);


% cost
% Note use .* to multiply element-wise because we want cost J for each
% training example.
J = sum((-y .* log(h)) - (1 - y) .* log(1-h)) * 1/m; % * 1/m to get the avg

% gradient
% take h-y for each training example.
%size((h-y)) % ans = [100 1]
%size(X)     % ans = [100 3]

% Taking transpose of X * (h-y) will give us a [3 1] vector.
grad = X' * (h-y) * 1/m;

% =============================================================

end
