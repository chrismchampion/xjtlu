# towardsdatascience.com
import tensorflow as tf
import matplotlib.pyplot as plt
# Importing the required Keras modules containing model and layers
from keras.models import Sequential
from keras.layers import Dense, Conv2D, Dropout, Flatten, MaxPooling2D

'''image_size = 28
labels_size = 10
learning_rate = 0.05
steps_number = 1000
batch_size = 100
# Define placeholders
training_data = tf.placeholder(tf.float32, [None, image_size*image_size])
labels = tf.placeholder(tf.float32, [None, labels_size])'''
class_names = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']

# train_images and test_images parts contain greyscale RGB codes (from 0 to 255)
# train_labels and test_labels parts contains labels from 0 to 9 which represents which number they actually are
(train_images, train_labels),(test_images, test_labels) = tf.keras.datasets.mnist.load_data()

# EXPLORE THE DATA
image_index = 7777 # You may select anything up to 60,000
print(train_labels[image_index]) # The label is 8
plt.imshow(train_images[image_index], cmap='Greys')
#plt.show() # displays training label at index 7777: an 8

# use the “shape” attribute of numpy array
# to know the shape of the dataset to channel it to the convolutional neural network
shape = train_images.shape
print(shape) # 60000 = number of images in the train dataset
             # 28,28 = size of the images 28 x 28 pixels


# VERIFICATION TEST BEFORE BUILDING AND TRAINING THE NETWORK
plt.figure(figsize=(10,10))
for i in range(25):
    plt.subplot(5, 5, i+1)
    plt.xticks([])
    plt.yticks([])
    plt.grid(False)
    plt.imshow(train_images[i], cmap='Greys')
    plt.xlabel(class_names[train_labels[i]])
plt.show()

# RESHAPING AND NORMALZING THE IMAGES / PREPROCESS THE DATA
# To be able to use the dataset in Keras API, we need 4-dims numpy arrays. 
# As we see above, our array is 3-dimensional.
# Reshaping the array to 4-dims so that it can work with the Keras API
train_images = train_images.reshape(train_images.shape[0], 28, 28, 1)
test_images = test_images.reshape(test_images.shape[0], 28, 28, 1)
input_shape = (28, 28, 1)
# Making sure that the values are float so that we can get decimal points after division
train_images = train_images.astype('float32')
test_images = test_images.astype('float32')
# Normalizing the RGB codes by dividing it by the max RGB value.
train_images /= 255
test_images /= 255
print('train_images shape:', train_images.shape)
print('Number of images in train_images', train_images.shape[0])
print('Number of images in test_images', test_images.shape[0])




# BUILDING THE CONVOLUTIONAL NEURAL NETWORK (CNN)
# Creating a Sequential Model and adding the layers
model = Sequential()
model.add(Conv2D(28, kernel_size=(3,3), input_shape=input_shape))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Flatten()) # Flattening the 2D arrays for fully connected layers
model.add(Dense(128, activation=tf.nn.relu))
model.add(Dropout(0.2))
model.add(Dense(10,activation=tf.nn.softmax))

# COMPILING AND FITTING THE MODEL
# The above code creates an non-optimized empty CNN.
#
# Set an optimizer with a given loss function which uses a metric.
# Then, we can fit the model by using our train data.
model.compile(optimizer='adam', 
              loss='sparse_categorical_crossentropy', 
              metrics=['accuracy'])
model.fit(x=train_images,y=train_labels, epochs=2)


# EVALUATING THE MODEL
test_losss, test_acc = model.evaluate(test_images, test_labels, verbose=2)
print('\nTest accuracy:', test_acc)