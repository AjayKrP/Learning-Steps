from sklearn.preprocessing import Imputer, StandardScaler
import pandas as pd
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
from sklearn.model_selection import train_test_split
import numpy as np
import matplotlib.pyplot as plt
np.set_printoptions(suppress = True)
dataset = pd.read_csv('Data.csv')
X = dataset.iloc[:, :-1].values # first : represent row and second : represent column
Y = dataset.iloc[:, 3].values
imputer  = Imputer(missing_values='NaN', strategy='mean', axis=0)
imputer1 = imputer.fit(X[:, 1:3])
X[:, 1:3] = imputer1.transform(X[:, 1:3])
#Encoding Categorical Data
le_X = LabelEncoder()
X[:, 0] = le_X.fit_transform(X[:, 0])
onehotenc = OneHotEncoder(categorical_features=[0])
X = onehotenc.fit_transform(X).toarray()
#print X[:, 0:3]
le_Y = LabelEncoder()
Y = le_Y.fit_transform(Y)
#FEATURE SCALING
print X
Sc_X = StandardScaler()
X[:, 3:] = Sc_X.fit_transform(X[:, 3:])

#spliting data into Training and Testing
X_train, X_test, Y_train,  Y_test = train_test_split(X, Y, test_size = 0.2, random_state=0)

print X
np.savetxt('Data1.csv', X, delimiter=', ')

plt.plot(X[:, 2:4])
plt.ylabel('some numbers')
plt.show()

#print ('X_test:{}\n, Y_test:{}\n, X_train:{}\n, Y_train:{}\n'.format(X_test, Y_test, X_train, Y_train))
 