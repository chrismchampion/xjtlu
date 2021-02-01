function p = predict(Theta1, Theta2, X)
%PREDICT Predict the label of an input given a trained neural network
%   p = PREDICT(Theta1, Theta2, X) outputs the predicted label of X given the
%   trained weights of a neural network (Theta1, Theta2)

% Useful values
m = size(X, 1);
num_labels = size(Theta2, 1);

% You need to return the following variables correctly
p = zeros(size(X, 1), 1);
X = [ones(m, 1) X];

% ====================== YOUR CODE HERE ======================
% Instructions: Complete the following code to make predictions using
%               your learned neural network. You should set p to a 
%               vector containing labels between 1 to num_labels.
%
% Hint: The max function might come in useful. In particular, the max
%       function can also return the index of the max element, for more
%       information see 'help max'. If your examples are in rows, then, you
%       can use max(A, [], 2) to obtain the max for each row.
%

% a1 is our input X
a1 = X;
%size(a1)        % [1  401]
% hidden layer has 25 nodes
%size(Theta1)    % [25 401]

z2 = a1 * Theta1';
% need to add first/bias node for all training examples
a2 = [ones(m,1), sigmoid(z2)];

z3 = a2 * Theta2';
a3 = sigmoid(z3);

[~, indices] = max(a3, [], 2);
p=indices;


% =========================================================================
tmp = X * Theta1';
tmp = sigmoid(tmp);
tmp = [ones(m, 1), tmp];
tmp2 = tmp * Theta2';
tmp2 = sigmoid(tmp2);
[~, p] = max(tmp2, [], 2);

end
