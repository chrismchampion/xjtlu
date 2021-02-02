import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import classification_report,confusion_matrix
from sklearn import datasets as sk_datasets

# 1. LOAD IRIS DATASET
iris = sk_datasets.load_iris()        

# 2. TRAIN TEST SPLIT
X = iris.data[:, :]
y = iris.target
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.30)

# 3. TRAIN THE MODEL
# clf is classifier
clf = SVC()
clf.fit(X_train, y_train)

# 4. EVALUATE MODEL
# Get predictions from the model and create a confusion matrix
# and classification report.
pred = clf.predict(X_test)

print(confusion_matrix(y_test, pred))
print(classification_report(y_test, pred))

print('score', clf.score(X_test, y_test))
print('pred label', clf.predict(X_test))
