import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import classification_report,confusion_matrix
from sklearn.decomposition import PCA
from sklearn.preprocessing import StandardScaler
from mpl_toolkits.mplot3d import Axes3D
from sklearn import datasets as sk_datasets

# 1. LOAD IRIS DATASET
iris = sk_datasets.load_iris()        

# 2. TRAIN TEST SPLIT
X = iris.data[:, :]
y = iris.target
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.30)

# 3. IMPLEMENT PRINICPAL COMPONENT ALGORITHM
pca = PCA(n_components=3)
pca.fit(X_train)
X_t_train = pca.transform(X_train)
X_t_test = pca.transform(X_test)

# clf is classifier
clf = SVC()

def PC_score(cols):
    clf.fit(X_t_train[:, cols], y_train)
    test_col = X_t_test[:, cols]
    return clf.score(test_col, y_test)

## Task 2.3: Compare individual principal compontent accuracies
# PC1
print('PC1 accuracy score', PC_score([0]))
# PC2
print('PC2 accuracy score', PC_score([1]))
# PC3
print('PC3 accuracy score', PC_score([2]))

## Task 2.4: Compare combination principal component accuracies
# PC1 AND PC2
print('PC1 AND PC2 accuracy score', PC_score([0, 1]))
# PC1 AND PC3
print('PC1 AND PC3 accuracy score', PC_score([0, 2]))
# PC2 AND PC3
print('PC2 AND PC3 accuracy score', PC_score([1, 2]))

# 4. TRAIN THE MODEL
clf.fit(X_t_train, y_train)

# 5. EVALUATE MODEL
# Get predictions from the model and create a confusion matrix
# and a classification report.
pred = clf.predict(X_t_test)

print(confusion_matrix(y_test, pred))
print(classification_report(y_test, pred))

print('score', clf.score(X_t_test, y_test))
print('pred label', clf.predict(X_t_test))

# 5. PLOT PCA
# normal distribution
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

fig = plt.figure(1, figsize=(16, 10))
ax = Axes3D(fig, elev=-150, azim=140)

# dimensionality reduction with PCA
X_reduced = PCA(n_components=3).fit_transform(X_scaled)
ax.scatter(X_reduced[:, 0], X_reduced[:, 1], X_reduced[:, 2], c=y,
           cmap=plt.cm.Set1, edgecolor='k', s=200)
ax.set_title("PCA Component Reduction")
ax.set_xlabel("Principal Component 1")
ax.w_xaxis.set_ticklabels([])
ax.set_ylabel("Principal Component 2")
ax.w_yaxis.set_ticklabels([])
ax.set_zlabel("Principal Component 3")
ax.w_zaxis.set_ticklabels([])

plt.show()

print("The number of features in the new subspace is ", X_reduced.shape[1])