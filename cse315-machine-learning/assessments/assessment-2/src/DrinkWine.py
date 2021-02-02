print("-----------------------------------------------")
print("STEP 1: IMPORT LIBRARIES AND MODULES")
print("-----------------------------------------------")
# numpy provides support for more efficient numerical computation
import numpy as np
# Pandas, a convenient library that supports dataframes
import pandas as pd

# Import functions for machine learning
# Module contains utilities that will help us choose between models
from sklearn.model_selection import train_test_split
# Contains utilities for scaling, transforming, and wrangling data.
from sklearn import preprocessing

# Import families of models we'll need.
# A "family" of models are broad types of models,
# such as random forests, SVM's, linear regression models, etc.
# Within each family of models, you'll get an actual model after you fit
# and tune its parameters to the data.
from sklearn.ensemble import RandomForestRegressor

# Importing the tools to help us perform cross-validation.
from sklearn.pipeline import make_pipeline
from sklearn.model_selection import GridSearchCV

# Import some metrics we can use to evaluate our model performance later.
from sklearn.metrics import mean_squared_error, r2_score

# Finally, import a way to persist our model for future use
from sklearn.externals import joblib


print("-----------------------------------------------")
print("STEP 2: LOAD RED WINE DATA")
print("-----------------------------------------------")
dataset_url = 'http://mlr.cs.umass.edu/ml/machine-learning-databases/wine-quality/winequality-red.csv'
data = pd.read_csv(dataset_url, sep=";")

# prints first n rows
#print(data.head())

# prints (1599, 12), i.e.
# 1599 samples (table rows) and 12 features (table columns)
print(data.shape)

# All of the features are numeric, which is convenient.
# However, they have some very different scales, so let's make a mental note to standardize the data later.
# prints summary statistics
print(data.describe())

print("-----------------------------------------------")
print("STEP 3: SPLIT DATA INTO TRAINING AND TEST SETS")
print("-----------------------------------------------")
print("Splitting the data into training and test sets at the beginning of your modeling workflow")
print("is crucial for getting a realistic estimate of your model's performance.")
print("-----------------------------------------------")
# First separate the target (y) features from our input (X) features:
y = data.quality
X = data.drop('quality', axis=1)

# Split data into train and test sets:
# Set aside 20% of the data as a test set for evaluating our model.
# Set an arbitrary "random state" (a.k.a. seed) so that we can reproduce our results.
# Stratifying your sample by the target variable will ensure your training set
# looks similar to your test set, making your evaluation metrics more reliable.
X_train, X_test, y_train, y_test = train_test_split(X, y,
                                    test_size=0.2, random_state=123,
                                    stratify=y)


print("-----------------------------------------------")
print("STEP 4: DECLARE DATA PREPROCESSING STEPS")
print("-----------------------------------------------")
print("Standardization is the process of subtracting the means")
print("from each feature and then dividing by the feature standard deviations.")
print("-----------------------------------------------")
# Won't use this code because we won't be able to perform the exact same transformation on the test set.
# Sure, we can still scale the test set separately,
# but we won't be using the same means and standard deviations
# as we used to transform the training set.
# Lazy way of scaling data
#X_train_scaled = preprocessing.scale(X_train)
#print(X_train_scaled)

# You can confirm that the scaled dataset is indeed centered at zero, with unit variance:
#print(X_train_scaled.mean(axis=0))
#print(X_train_scaled.std(axis=0))

#-----------------------------------------------
# Transformer API
#-----------------------------------------------
# Instead of directly invoking the scale function, can use a feature in Scikit-Learn called the Transformer API.
# The Transformer API allows you to "fit" a preprocessing step using the training data the same way you'd fit a model
# and then use the same transformation on future data sets!

# 1. Fit the transformer on the training set (saving the means and standard deviations)
scaler = preprocessing.StandardScaler().fit(X_train)

# 2. Apply the transformer to the training set (scaling the training data)
X_train_scaled = scaler.transform(X_train)
print(X_train_scaled.mean(axis=0))
print(X_train_scaled.std(axis=0))

# 3. Apply the transformer to the test set (using the same means and standard deviations)
X_test_scaled = scaler.transform(X_test)
print(X_test_scaled.mean(axis=0))
print(X_test_scaled.std(axis=0))

# Now the scaled features in the test set are not perfectly centered at zero with unit variance!
# This is exactly what we'd expect, as we're transforming the test set using the means from the training set, not from the test set itself.
# In practice, when we set up the cross-validation pipeline, we won't even need to manually fit the Transformer API.
# Instead, we'll simply declare the class object, like so:

# Pipeline with preprocessing model
pipeline = make_pipeline(preprocessing.StandardScaler(), RandomForestRegressor(n_estimators=100))


print("-----------------------------------------------")
print("STEP 5: DECLARE HYPERPARAMETERS TO TUNE")
print("-----------------------------------------------")
print("Two types of parameters we need to worry about: model parameters and hyperparameters.")
print("Models parameters can be learned directly from the data (i.e. regression coefficients), while hyperparameters cannot.")
print("-----------------------------------------------")
# Example: random forst hyperparameters
# Hyperparameters express "higher-level" structural information about the model, and they are typically set before training the model.

# List tunable hyperparameters
# print(pipeline.get_params())
# ...
# 'randomforestregressor__criterion': 'mse',
# 'randomforestregressor__max_depth': None,
# 'randomforestregressor__max_features': 'auto',
# 'randomforestregressor__max_leaf_nodes': None,
# ...

# Declare hyperparameters to tune
hyperparameters = {'randomforestregressor__max_features' : ['auto', 'sqrt', 'log2'],
                    'randomforestregressor__max_depth': [None, 5, 3, 1]}


print("-----------------------------------------------")
print("STEP 6: TUNE MODEL USING A CROSS-VALIDATION PIPELINE")
print("-----------------------------------------------")
print("One of the most important skills in all of machine learning")
print("because it helps you maximize model performance while reducing the chance of overfitting.")
print("-----------------------------------------------")
# These are the steps for CV:
#    1. Split your data into k equal parts, or "folds" (typically k=10).
#    2. Train your model on k-1 folds (e.g. the first 9 folds).
#    3. Evaluate it on the remaining "hold-out" fold (e.g. the 10th fold).
#    4. Perform steps (2) and (3) k times, each time holding out a different fold.
#    5. Aggregate the performance across all k folds. This is your performance metric.

# The best practice when performing CV is to include your data preprocessing steps
# inside the cross-validation loop. This prevents accidentally tainting your training folds
# with influential data from your test fold.
# Here's how the CV pipeline looks after including preprocessing steps:

#    1. Split your data into k equal parts, or "folds" (typically k=10).
#    2. Preprocess k-1 training folds.
#    3. Train your model on the same k-1 folds.
#    4. Preprocess the hold-out fold using the same transformations from step (2).
#    5. Evaluate your model on the same hold-out fold.
#    6. Perform steps (2) - (5) k times, each time holding out a different fold.
#    7. Aggregate the performance across all k folds. This is your performance metric.

# Sklearn cross-validation with pipeline
clf = GridSearchCV(pipeline, hyperparameters, cv=10)
# Fit and tune model
clf.fit(X_train, y_train)
print(clf.best_params_)


print("-----------------------------------------------")
print("STEP 7: REFIT THE ENTIRE TRAINING SET")
print("-----------------------------------------------")
# GridSearchCV from sklearn will automatically refit the model
# with the best set of hyperparameters using the entire training set.
#This functionality is ON by default, but you can confirm it:
print(clf.refit)


print("-----------------------------------------------")
print("STEP 8: EVALUATE MODEL PIPELINE ON TEST DATA")
print("-----------------------------------------------")
# Predict a new set of data
y_pred = clf.predict(X_test)

# Now we can use the metrics we imported earlier to evaluate our model performance.
print(r2_score(y_test, y_pred))
print(mean_squared_error(y_test, y_pred))


print("-----------------------------------------------")
print("STEP 9: SAVE MODEL FOR FUTURE USE")
print("-----------------------------------------------")
# Save model to a .pkl file
joblib.dump(clf, 'rf_regressor.pkl')

# Load model from .pkl file
clf2 = joblib.load('rf_regressor.pkl')

# Predict dataset using loaded model
clf2.predict(X_test)