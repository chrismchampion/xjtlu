import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)
from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import confusion_matrix
from sklearn.model_selection import validation_curve
from sklearn.model_selection import KFold
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import GridSearchCV
import matplotlib.pyplot as plt
import seaborn as sns

train_data = pd.read_csv(r'C:\Users\ccham\Documents\Machine Learning\assignment 2\mnist_train.csv')
test_data = pd.read_csv(r'C:\Users\ccham\Documents\Machine Learning\assignment 2\mnist_test.csv')

print(train_data.shape) # (59999, 785)
print(test_data.shape) # (9999, 785)

print(train_data.head())

print("Dimensions: ", test_data.shape, "\n")
print(test_data.info())
test_data.head()

## Separating the X and Y variable

y = train_data['label']

## Dropping the variable 'label' from X variable
X = train_data.drop(columns = 'label')
print(train_data.shape)