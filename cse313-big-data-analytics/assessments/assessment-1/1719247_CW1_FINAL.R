# Author: Christopher Champion
# Student ID: 1719247
# Date: 2019-10-10

# Import libraries
library("doBy") #include for length() function
library("ggplot2") #include for graph plotting
library("gtools") # include for sorting filenames mixedsort

# Constant values
# Number of CSV files to read in
SAMPLE_SIZE <- 21

print("*****************************************************")
print("I. DATA ACQUISITION")
# Management of raw (CSV) data, i.e. read in raw data using
# read.csv("PATH") function.
print("*****************************************************")

# Get Sys.time()
startTime <- Sys.time()
cat("Importing dataset...")

# Import CSV files
filenames <- list.files(pattern = "*.csv")
filenames <- mixedsort(sort(filenames))
dataset <- NULL
# read in all filenames
for (i in 1:SAMPLE_SIZE) {
  # arg 'header' specifies data includes a header row
  # arg 'sep' specifies data separated by commas (implied by CSV)
  # arg 'colClasses' specification reduces data import time'
  csv <- read.csv(filenames[i], header=TRUE, sep=",", colClasses="integer")
  csv$Day <-i # add day column
  if (is.null(dataset))
    dataset <- csv  # first frame is initialized
  else # all following frames are joined
    dataset <- rbind(dataset, csv)
}

# Print data import elapsed time
dataImportTime <- Sys.time() - startTime
cat("File import elapsed time:",dataImportTime,"seconds.\n")

print("*****************************************************")
print("II. UNDERSTANDING/EXPLORATION")
# Display information about the data by printing categories,
# number of rows by subset, and a summary of the dataset.
print("*****************************************************")

# Examine the dataset:
cat("Found", nrow(dataset),"records.\n")
cat("Sample size taken spans",max(dataset$Day),"days.\n")
cat("Male participants:", nrow(subset(dataset, Gender == 0)),"\n")
cat("Female participants:", nrow(subset(dataset, Gender == 1)),"\n\n")

cat("Data categories:\n",colnames(dataset),"\n")
print("-------------------------------------------------------")
cat("Number of records where 'Age' is less than 1:", nrow(subset(dataset, Age < 1)),"\n")
cat("Number of records where 'Gender' is not 0 or 1 (invalid):", nrow(subset(dataset, Gender != 0 & Gender != 1)),"\n")
cat("Number of records where 'Clicks' is greater than 'Impressions' (invalid):", nrow(subset(dataset, Clicks > Impressions)),"\n")
cat("Number of records where 'Signed_In' is 0:", nrow(subset(dataset, Signed_In == 0)),"\n")
cat("Number of records where 'Signed_In' is 0 and 'Age' > 0:", nrow(subset(dataset, Signed_In == 0 & Age > 0)),"\n")
cat("Number of records where 'Signed_In' is 0 and 'Gender' is 0:", nrow(subset(dataset, Signed_In == 0 & Gender == 0)),"\n")
cat("Number of records where 'Signed_In' is 0 and 'Gender' is 1:", nrow(subset(dataset, Signed_In == 0 & Gender == 1)),"\n")
cat("\nThis demonstrates a relation between 'Signed_In' value\nand attributes 'Age' and 'Gender', i.e. if user is not signed in\n")
cat("they are assigned an age and gender of 0 by default.\n")
print("-------------------------------------------------------")
cat("Data summary:\n")
print(summary(dataset))

print("*****************************************************")
print("III. PRE-PROCESSING")
# Clean/transform the data based on understanding from
# exploration in previous step, for example, a relation
# between the 'Signed_In', 'Age', and 'Gender' attributes
# was discovered so a subset of the dataset where Signed_In
# is true is created.
print("*****************************************************")

# Define click-through-rate (CTR)
dataset$CTR <- dataset$Clicks/dataset$Impressions

# Define age category
dataset$main.ageCat <- cut(dataset$Age, c(-Inf, 29, 39, 49, 59, Inf))

# Categorize into 5 ages groups: <30, 30-39, 40-49, 50-59, 60+
# Constraint data subset to users who are signed in, otherwise age/gender data is invalid.
dsSignedIn <- subset(dataset, Signed_In == 1)
# Note: Intervals defined by cut() function are (by default) closed on the right.
dsSignedIn$ageCat <- cut(dsSignedIn$Age, c(-Inf, 29, 39, 49, 59, Inf))

# View the result
cat("Created age categories from signed in users:\n")
print(summary(dsSignedIn$ageCat))

print("*****************************************************")
print("IV. ANALYSIS")
# Transformed data subset is examined and visualized with
# graph representations using the ggplot2 library.
print("*****************************************************")

cat("SUMMARY OF SIGNED IN USERS:\n")
print(summary(dsSignedIn))

# Define function 'siterange'
siterange <- function(x) {c(length(x), min(x), max(x), mean(x))}
print("-------------------------------------------------------")
print("siterange function: FUN1=length(x); FUN2=min(x); FUN3=max(x); FUN4=mean(x)")
print("-------------------------------------------------------")
cat("SUMMARY BY 'Age' WITH 'siterange':\n")
summaryBy(Age~ageCat, data=dsSignedIn, FUN=siterange)
print("-------------------------------------------------------")
cat("SUMMARY BY 'Gender' + 'Signed_In' + 'Impressions' + 'Clicks~ageCat':\n")
summaryBy(Gender+Signed_In+Impressions+Clicks~ageCat, data=dsSignedIn)
print("-------------------------------------------------------")
cat("SUMMARY BY 'Clicks' + 'Impressions~ageCat':\n")
summaryBy(Clicks+Impressions~ageCat, data=dsSignedIn)
# Results of CTR by age group: 0-29 have lowest avg Impressions but
# 2nd highest avg Clicks.
print("-------------------------------------------------------")

# Plot the data
# Graph 1
print(bar.numClicksBySignedIn <- ggplot(subset(dsSignedIn, Clicks > 0), aes(x=Day, y=Clicks, fill=factor(Gender)))
  + geom_bar(stat="identity")
  + ggtitle(paste("Number of clicks by signed-in users over", SAMPLE_SIZE, "days")))
# Graph 2
print(hist.numUsersAdClickByGender <- ggplot(subset(dsSignedIn, Clicks > 0), aes(x=Day, fill=factor(Gender)))
  + geom_histogram(position="dodge", binwidth=0.5)
  + ggtitle(paste("Number of signed-in users who clicked ads over", SAMPLE_SIZE, "days")))
# Graph 3
print(hist.numUsersAdClickByAgeCat <- ggplot(subset(dsSignedIn, Clicks > 0), aes(x=Day, fill=ageCat))
  + geom_histogram(position="dodge", binwidth=0.5)
  + ggtitle(paste("Number of signed-in users by age who clicked ads over", SAMPLE_SIZE, "days")))
# Graph 4
print(hist.numUsersAdClickByGender60 <- ggplot(subset(dsSignedIn, Clicks > 0 & Age > 59), aes(x=Day, fill=factor(Gender)))
  + geom_histogram(position="dodge", binwidth=0.5)
  + ggtitle(paste("Number of signed-in users (60+) who clicked ads over", SAMPLE_SIZE, "days")))
# Graph 5
print(hist.CTRByAgeCat <- ggplot(subset(dataset, CTR > 0), aes(x=CTR, fill=main.ageCat))
  + geom_histogram(binwidth=.025)
  + ggtitle(paste("Number of signed-in users by age click-through-rate over", SAMPLE_SIZE, "days")))
# Graph 6
print(line.clicksByDay <- ggplot(dataset, aes(x = Day)) + stat_summary_bin(aes(y = Clicks), fun.y = sum, geom = "line")
  + ggtitle(paste("Clicks by day over", SAMPLE_SIZE, "days")))
