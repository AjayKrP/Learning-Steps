
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Importing the dataset
dataset = pd.read_csv('50_Startups.csv')
X = dataset.iloc[:, :-1].values
y = dataset.iloc[:, -1].values
# Encoding categorical data
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
labelencoder = LabelEncoder()
X[:, 3] = labelencoder.fit_transform(X[:, 3])
onehotencoder = OneHotEncoder(categorical_features = [3])
X = onehotencoder.fit_transform(X).toarray()

# Avoiding the Dummy Variable Trap
X = X[:, 1:]

# Splitting the dataset into the Training set and Test set
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

# Fitting Multiple Linear Regression to the Training set
from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train, y_train)

y_pred = regressor.predict(X_test)
#print y_pred
ms = 0
for i in range(len(y_pred)):
    ms = ms + (y_pred[i] - y_test[i])**2
ms = ms/len(y_pred)
rms = np.sqrt(ms)
#print 'Root mean square is : ', rms
#print y_pred

max = y_pred[0]
index = 0
for i in range(len(y_pred)):
   if(y_pred[i] > max):
       max = y_pred[i]
       index = i

#print index
#print X[index]


# plt.plot(y_pred, 'g-')
# plt.plot( y_test, 'r-')
# plt.show()

sum = 0
for i in range(len(y_pred)):
    sum = y_pred[i]

print 'sum := ', sum

# import statsmodels.formula.api as sm
# X = np.append(arr = np.ones(50, 1), values = X, axis=1)
# X_opt = X[:, [0, 1, 2, 3, 4]]
# regressor_OLS = sm.OLS(endog = y, exog = X_opt).fit()
# regressor_OLS.summary()
