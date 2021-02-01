# For more details on Pandas functions, see the API: http://pandas.pydata.org/pandas-docs/stable/api.html.
# imports the Pandas and Numpy libraries and gives aliases pd/np
import pandas as pd
import numpy as np

# import the csv file. If file contains header row, set header to the line 0
# the import dataset will be sorted into DataFrame (male100)
male100 = pd.read_csv('male100.csv', header=0)
print(male100)

# output male100 dataset to demo.csv file
male100.to_csv('demo.csv')

# Listing 5: Data Processing
# Each column can be extracted by "dataframe name[column name]"
print(male100['Time'], "\n")

# Calculate mean and standard deviation
# Other common functions are also available: max(), median(), etc.
mean = male100['Time'].mean()
std = male100['Time'].std()

# To get some basic statistics, we can use the describe() method:
print(male100['Time'].describe(), "\n")
print(mean, std)
