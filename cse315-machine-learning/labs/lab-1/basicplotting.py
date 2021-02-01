# Listing 6: Basic Plotting
# Activates the inline graph display
import  matplotlib

import pandas as pd
import numpy as np
# Import 'matplotlib.pyplot' to plot a simple straight line
import matplotlib.pyplot as plt

male100 = pd.read_csv('male100.csv', header=0)
female100 = pd.read_csv('female100.csv', header=0)

# Basic pandas plotting
male100.plot(x=0, y=1, kind='scatter', color='g', marker='v', label="Mens 100m")

# Simplified version
male100.plot.scatter(0, 1, color='g', label="Mens 100m")

# Two different datasets in one graph
ax = male100.plot(x=0, y=1, kind='scatter', color='g', label="Mens 100m")
female100.plot(x=0, y=1, kind='scatter', color='r', label="Womens 100m", ax=ax)

# We can use plt (imported from matplotlib) to plot a simple graph
# Define a graph with respect to all Olympic Years in male100.csv
y = -0.014*male100['Year'] + 38
plt.plot(male100['Year'], y, 'r-', color = 'r')
# have to use show() to display graph
plt.show()

