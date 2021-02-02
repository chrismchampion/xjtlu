# https://medium.com/@the1ju/simple-logistic-regression-using-keras-249e0cc9a970
# Build the model of a logistic classifier
import os
import gzip
import six.moves.cPickle as pickle
import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.datasets import mnist
from keras.utils import np_utils

def build_logistic_model(input_dim, output_dim):
    model = Sequential()
    model.add(Dense(output_dim, input_dim=input_dim, activation='softmax'))

    return model


# READING IN THE DATA
# the data, shuffled and split between train and test sets
(X_train, y_train), (X_test, y_test) = mnist.load_data()


# RESHAPING AND NORMALIZING THE INPUTS
input_dim = 784 #28*28
nb_classes = 10
X_train = X_train.reshape(60000, input_dim) 
X_test = X_test.reshape(10000, input_dim) 
X_train = X_train.astype('float32') 
X_test = X_test.astype('float32') 
X_train /= 255 
X_test /= 255
print(X_train.shape[0], 'train samples')
print(X_test.shape[0], 'test samples')


# CONVERT CLASS VECTORS TO BINARY CLASS MATRICES
Y_train = np_utils.to_categorical(y_train, nb_classes) 
Y_test = np_utils.to_categorical(y_test, nb_classes)

model = build_logistic_model(input_dim, nb_classes)
model.summary()


# BUILD THE MODEL
output_dim = nb_classes = 10 
model = Sequential() 
model.add(Dense(output_dim, input_dim=input_dim, activation='softmax')) 
batch_size = 128 
nb_epoch = 20

# COMPILE THE MODEL
model.compile(optimizer='sgd', loss='categorical_crossentropy', metrics=['accuracy']) 
history = model.fit(X_train, Y_train, batch_size=batch_size, nb_epoch=nb_epoch, verbose=1, validation_data=(X_test, Y_test)) 
score = model.evaluate(X_test, Y_test, verbose=0) 
print('Test score:', score[0]) 
print('Test accuracy:', score[1])

# SAVE MODEL AND WEIGHTS
json_string = model.to_json() # as json
open('mnist_Logistic_model.json', 'w').write(json_string)
yaml_string = model.to_yaml() #as yaml
open('mnist_Logistic_model.yaml', 'w').write(yaml_string)

# save the weights in h5 format
model.save_weights('mnist_Logistic_wts.h5')

# uncomment the code below (and modify accordingly) to read a saved model and weights 
# model = model_from_json(open('my_model_architecture.json').read())# if json 
# model = model_from_yaml(open('my_model_architecture.yaml').read())# if yaml 
# model.load_weights('my_model_weights.h5')