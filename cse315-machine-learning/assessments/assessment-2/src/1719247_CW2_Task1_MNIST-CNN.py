import tensorflow as tf
import matplotlib.pyplot as plt
# Importing Keras modules for dataset and CNN:
from keras.datasets import mnist
from keras.models import Sequential
from keras.layers import Dense, Conv2D, Dropout, Flatten, MaxPooling2D

# Constant value
NUM_EPOCH = 5

## 1. LOAD MNIST DATASET
# x_train_img and x_test_img parts contain grayscale RGB codes (from 0 to 255)
# y_train_lbl and y_test_lbl parts contains labels from 0 to 9
(x_train_img, y_train_lbl),(x_test_img, y_test_lbl) = mnist.load_data()


## 2. EXPLORE DATA
# prints (6000, 28, 28) = num training images and image size in pixels
print('x_train_img shape:', x_train_img.shape)
print('Number of images in x_train_img', x_train_img.shape[0]) # 60000
print('Number of images in x_test_img', x_test_img.shape[0]) # 10000

# displays 10 x 10 matrix of training images and corresponding training (class) labels
class_names = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
plt.figure(figsize=(10,10))
for i in range(25):
    plt.subplot(5, 5, i+1)
    plt.xticks([])
    plt.yticks([])
    plt.grid(False)
    plt.imshow(x_train_img[i])
    plt.xlabel(class_names[y_train_lbl[i]])
plt.show()


## 3. RESHAPING/NORMALZING DATA
input_shape = (28, 28, 1)
# Reshaping arrays (from 3-dim) to 4-dim to work with Keras API
x_train_img = x_train_img.reshape(x_train_img.shape[0], 28, 28, 1)
x_test_img = x_test_img.reshape(x_test_img.shape[0], 28, 28, 1)

# convert training and test image samples (from integers) to floating-point numbers.
# divide by max RGB value:
x_train_img, x_test_img = x_train_img / 255.0, x_test_img / 255.0


## 4. BUILD CONVOLUTIONAL NEURAL NETWORK (CNN) MODEL
# creating Sequential Model and adding layers
# Note: creates an non-optimized empty CNN.
model = Sequential()
model.add(Conv2D(28, kernel_size=(3,3), input_shape=input_shape))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Flatten()) # Flattening the 2D arrays for fully connected layers
model.add(Dense(128, activation=tf.nn.relu))
model.add(Dropout(0.2))
model.add(Dense(10,activation=tf.nn.softmax))

## 5. COMPILE AND FIT/TRAIN CNN MODEL
# choose an optimizer and loss function for training;
# choose target metric for loss function:
model.compile(optimizer='adam', 
              loss='sparse_categorical_crossentropy', 
              metrics=['accuracy'])

# train the model:
model.fit(x=x_train_img,y=y_train_lbl, epochs=NUM_EPOCH) 


## 6. EVALUATE CNN MODEL FOR ACCURACY USING TEST DATA
test_loss, test_acc = model.evaluate(x_test_img, y_test_lbl, verbose=2)
print('\nTest loss:', test_loss)
print('Test accuracy:', test_acc) # The classifier is trained to ~98% accuracy.