import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from sklearn.cluster import KMeans
from sklearn.decomposition import PCA
from sklearn import datasets

# 1. LOAD IRIS DATASET
iris = datasets.load_iris()
X = iris.data

# 2. FIT DATA TO KMEANS
kmeans = KMeans(n_clusters=3, random_state=0).fit(X)

# 3. PLOT RESULTS
fig = plt.figure(1, figsize=(4, 3))
ax = Axes3D(fig, rect=[0, 0, .95, 1], elev=180, azim=-90)
labels = kmeans.labels_

ax.scatter(X[:, 3], X[:, 0], X[:, 2], 
        c=labels.astype(np.float), edgecolor='k', s=10)

ax.w_xaxis.set_ticklabels([])
ax.w_yaxis.set_ticklabels([])
ax.w_zaxis.set_ticklabels([])
ax.set_xlabel('Petal width')
ax.set_ylabel('Sepal length')
ax.set_zlabel('Petal length')
ax.set_title("Iris dataset K-Means 4D")
ax.dist = 12

plt.show()

# 4. IMPLEMENT PCA
pca = PCA(n_components=3)
pca_X = pca.fit(X).transform(X)

kmeans = KMeans(n_clusters=3, random_state=0).fit(pca_X)

# 5. PLOT RESULTS
fig = plt.figure(2, figsize=(16, 10))
ax = Axes3D(fig, rect=[0, 0, .95, 1], elev=180, azim=-90)
labels = kmeans.labels_

ax.scatter(X[:, 2], X[:, 0], X[:, 1], 
        c=labels.astype(np.float), edgecolor='k', s=200)

ax.w_xaxis.set_ticklabels([])
ax.w_yaxis.set_ticklabels([])
ax.w_zaxis.set_ticklabels([])
ax.set_xlabel('Petal width')
ax.set_ylabel('Sepal length')
ax.set_zlabel('Petal length')
ax.set_title("Iris dataset K-Means PCA 3D")
ax.dist = 12

plt.show()